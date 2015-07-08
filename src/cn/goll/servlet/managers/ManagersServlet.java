package cn.goll.servlet.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.goll.common.DoPage;
import cn.goll.entity.Managers;
import cn.goll.entity.Menus;
import cn.goll.entity.Powers;
import cn.goll.entity.Systems;
import cn.goll.service.IManagersService;
import cn.goll.service.IMenusService;
import cn.goll.service.IPowersService;
import cn.goll.service.impl.ManagersServiceImpl;
import cn.goll.service.impl.MenusServiceImpl;
import cn.goll.service.impl.PowersServiceImpl;

public class ManagersServlet extends HttpServlet{
	
	IManagersService managerService=new ManagersServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("checklogin"))CheckLogin(request,response);
		if(method.equals("login"))Login(request,response);
		if(method.equals("logout"))Logout(request,response);
		if(method.equals("updatePwd"))UpdatePwd(request,response);
		if(method.equals("sel")){selAll(request,response,"0",null);}
		if(method.equals("selForDel")){selForDel(request,response,"1",null);}
		if(method.equals("selForcheck")){ManagerNotCheck(request,response);}
		if(method.equals("del")){delById(request,response);}
		if(method.equals("datchDel")){datchDel(request,response);}
		if(method.equals("add")){addManager(request,response);}
		if(method.equals("prepAdd")){prepAdd(request,response);}
		if(method.equals("check")){checkManager(request,response);}
	}
	
	private void CheckLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		String ValiCode=(String)request.getSession(false).getAttribute("Code");
		IManagersService managerService=new ManagersServiceImpl();
		Managers manager=managerService.queryManagersByName(uname, "1");
		PrintWriter out=null;
		if(manager!=null){
			out=response.getWriter();
			String strpwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(pwd))+uname));
			if(!manager.getPwd().equals(strpwd))
				out.print("1");
			else{
				if(code.equalsIgnoreCase(ValiCode)){
					if(manager.getIsonline()==0){
						manager.setIsonline(1);
						managerService.updateManagers(manager);
						request.getSession(false).setAttribute("manager", manager);
						out.print("0");
					}else{
						out.print("4");
					}
				}else
					out.print("3");
			}
		}else{
			out=response.getWriter();
			out.print("2");
		}
		out.flush();
		out.close();
	}
	
	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Managers manager=(Managers)request.getSession(false).getAttribute("manager");
		String times=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//对XML文件的读写所需的工具类
		//读SAXReader
		//写XMLWriter
		XMLWriter writer=null;
		//输出格式对象
		OutputFormat outFormat=OutputFormat.createPrettyPrint();
		outFormat.setEncoding("gbk");
		SAXReader reader=new SAXReader();
		String path="d:\\gollhouse\\logintime";
		File f=new File(path);
		if(!f.exists())
			f.mkdirs();
		String filePath=path+"\\user.xml";
		File file=new File(filePath);
		boolean isok=true;
		if(file.exists()){
			try {
				//获取xml文档对象
				Document document=reader.read(new FileInputStream(file),"gbk");
				//修改
				//获取根节点
				Element root=document.getRootElement();
				//遍历指定子节点
				for(Iterator i=root.elementIterator("user");i.hasNext();){
					//获取当前子节点
					Element user=(Element) i.next(); 
					if(user.attributeValue("id").equals(String.valueOf(manager.getId()))){
						user.element("lastTime").setText(user.element("time").getText());
						user.element("time").setText(times);
						isok=false;
						continue;
					}
				}
				if(isok){
					//添加
					Element user=root.addElement("user");
					//添加属性节点
					user.addAttribute("id", String.valueOf(manager.getId()));
					Element name=user.addElement("name");
					name.setText(manager.getUname());
					Element time=user.addElement("time");
					time.setText(times);
					Element lastTime=user.addElement("lastTime");
					lastTime.setText("暂无您上次登录的信息");
				}
				writer = new XMLWriter(new FileWriter(filePath), outFormat);
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			try{
				//创建
				Document document=DocumentHelper.createDocument();
				Element root=document.addElement("users");
				Element user=root.addElement("user");
				//添加属性节点
				user.addAttribute("id", String.valueOf(manager.getId()));
				Element name=user.addElement("name");
				name.setText(manager.getUname());
				Element time=user.addElement("time");
				time.setText(times);
				Element lastTime=user.addElement("lastTime");
				lastTime.setText("暂无您上次登录的信息");
				writer=new XMLWriter(new FileWriter(filePath),outFormat);
				writer.write(document);
				writer.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletContext application=this.getServletContext();
		application.setAttribute("online", (Integer)application.getAttribute("online")+1);
		Systems si=new Systems();
		si.setSys_name(request.getServerName());
		si.setSys_infos(getServletContext().getServerInfo());
		si.setSys_dns(request.getProtocol());
		si.setSys_logo(String.valueOf(request.getServerPort()));
		request.getSession(false).setAttribute("sys", si);
		IPowersService powerService=new PowersServiceImpl();
		Powers managerPower=powerService.queryPowersById(manager.getP_id());
		request.getSession(false).setAttribute("managerPower", managerPower);
		String[] menu=managerPower.getP_menus().split(",");
		List<Menus> menuList=new ArrayList<Menus>();
		IMenusService menuService=new MenusServiceImpl();
		for (String s : menu) {
			Menus m=menuService.queryMenusById(Integer.parseInt(s), "1");
			menuList.add(m);
		}
		request.getSession(false).setAttribute("menuList", menuList);
		response.sendRedirect("backstage/frame/web_page/frame.jsp");
	}
	
	private void Logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Managers m=(Managers) session.getAttribute("manager");
		if(m!=null){
			m.setIsonline(0);
			IManagersService ms=new ManagersServiceImpl();
			ms.updateManagers(m);
			session.removeAttribute("manager");
			session.invalidate();
			session=null;
		}
		ServletContext application=this.getServletContext();
		if((Integer)application.getAttribute("online")!=0)
			application.setAttribute("online", (Integer)application.getAttribute("online")-1);
		response.sendRedirect("login.jsp");
	}
	//查看所有的管理员
	public void selAll(HttpServletRequest request, HttpServletResponse response,String state,String flag)
		throws ServletException, IOException {
		DoPage pager=new DoPage(); 
		String page=request.getParameter("page");
		pager.setCounts(managerService.queryAllManagers().size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Managers> list=managerService.queryAllManagers(pager);
		request.getSession().setAttribute("pages", pager);
		request.setAttribute("list",list);
		if(state.equals("0")){
			request.setAttribute("jspParam", "Managers?method=sel");
		}if(state.equals("1")){
			request.setAttribute("jspParam", "Managers?method=selForDel");
		}
		request.getRequestDispatcher("backstage/manager/web_page/managerList.jsp?state="+state+"&flag="+flag).forward(request, response);
	}
	public void selForDel(HttpServletRequest request, HttpServletResponse response,String state,String flag)
	throws ServletException, IOException {
		DoPage pager=new DoPage(); 
		String page=request.getParameter("page");
		pager.setCounts(managerService.queryAllManagers().size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Managers> list=managerService.queryAllManagers(pager);
		request.getSession().setAttribute("pages", pager);
		request.setAttribute("list",list);
		request.setAttribute("jspParam", "Managers?method=selForDel");
		request.getRequestDispatcher("backstage/manager/web_page/managerList.jsp?state=1&flag="+flag).forward(request, response);
}
	//删除
	public void delById(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		int m_id=Integer.parseInt(id);
		boolean flag=false;
		if(managerService.deleteManagers(m_id)>0)
			flag=true;
		selAll(request,response,"1",String.valueOf(flag));
	}
	//批量删除
	public void datchDel(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String[] id=request.getParameterValues("id");
		boolean flag=true;
		for (int i = 0; i < id.length; i++) {
			int m_id=Integer.parseInt(id[i]);
			if(managerService.deleteManagers(m_id)<1)
				flag=false;
		}		
		selAll(request,response,"1",String.valueOf(flag));
	}
	//添加管理员
	public void addManager(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String name=request.getParameter("name");
		IManagersService managerService=new  ManagersServiceImpl();
		Managers m=managerService.queryManagersByName(name, null);
		PrintWriter out=response.getWriter();
		if(m!=null){
			out.print("1");
		}
		else{
			String pwd=request.getParameter("pwd");
			String power=request.getParameter("power");
			pwd=DigestUtils.md5Hex(DigestUtils.md5Hex("pwd")+name);
			Managers manger=new Managers(name,pwd,Integer.parseInt(power.trim()),"0",0);
			boolean flag=managerService.insertManagers(manger);
			if(flag)
				out.print("2");
		}
		out.flush();
		out.close();
	}
	//预添加管理员
	public void prepAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 IPowersService powerService=new PowersServiceImpl();
		 List<Powers> powers=powerService.queryAllPowers();
		 request.setAttribute("ps",powers);
		 request.getRequestDispatcher("backstage/manager/web_page/managerAppend.jsp").forward(request, response);
	}
	
	//查询待审核的用户
	public void ManagerNotCheck(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String ischeck=request.getParameter("ischeck");
		mancheck(request,response,ischeck,null);
		
	}
	//审核用户
	public void checkManager(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		int m_id=Integer.parseInt(id);
		int line=managerService.updateManagers(m_id, "1");
		ServletContext application=this.getServletContext();
		application.setAttribute("OverManager",(Integer)application.getAttribute("OverManager")-1 );
		mancheck(request,response,"0",String.valueOf(line));
	}
	
	//查询待审核的用户的通用方法
	public void mancheck(HttpServletRequest request, HttpServletResponse response,String ischeck,String flag)
	throws ServletException, IOException {
		DoPage pager=new DoPage(); 
		String page=request.getParameter("page");
		pager.setCounts(managerService.queryAllManagers("0").size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Managers> list=managerService.queryAllManagers(ischeck,pager);
		request.getSession().setAttribute("pages", pager);
		request.setAttribute("jspParam", "Managers?method=selForcheck&ischeck=0");
		request.setAttribute("list",list);
		request.getRequestDispatcher("backstage/manager/web_page/managerList.jsp?state=2&flag="+flag).forward(request, response);
	}
	public void UpdatePwd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		String newPwd=request.getParameter("newPwd");
		String newPwd2=request.getParameter("newPwd2");
		
		Managers manager=(Managers) request.getSession(false).getAttribute("manager");
		pwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(pwd))+manager.getUname()));
		PrintWriter out=response.getWriter();
		if(!pwd.equals(manager.getPwd())){
			out.print("0");
		}
		if(!newPwd.equals(newPwd2))
			out.print("1");
		newPwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf(newPwd))+manager.getUname()));
		manager.setPwd(newPwd);
		manager.setIscheck("1");
		IManagersService managerService=new ManagersServiceImpl();
		if(managerService.updateManagers(manager)>0)
			out.print("2");
		out.flush();
		out.close();
	}

}
