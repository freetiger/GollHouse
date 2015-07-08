package cn.goll.servlet.powers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Menus;
import cn.goll.entity.Powers;
import cn.goll.service.IMenusService;
import cn.goll.service.IPowersService;
import cn.goll.service.impl.MenusServiceImpl;
import cn.goll.service.impl.PowersServiceImpl;

public class PowersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("query"))Query(request,response);
		if(method.equals("update"))Update(request,response);
		if(method.equals("updateAll"))UpdateAll(request,response);

	}
	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		IPowersService powerService=new PowersServiceImpl();
		List<Powers> list=powerService.queryAllPowers();
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		list=powerService.queryAllPowers(page);
		request.setAttribute("powerlist", list);
		request.getSession(false).setAttribute("pages", page);
		request.getRequestDispatcher("backstage/power/web_page/powerList.jsp?status="+status).forward(request, response);
	}	
	private void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		String id=request.getParameter("id");
		IPowersService powerService=new PowersServiceImpl();
		Powers power=powerService.queryPowersById(Integer.parseInt(id));
		String menus[]=power.getP_menus().split(",");
		List<Powers> list=new ArrayList<Powers>();
		for (int i = 0; i < menus.length; i++) {
			Powers p=new Powers();
			p.setP_id(Integer.valueOf(menus[i].trim()));
			list.add(p);
		}
		IMenusService menuService=new MenusServiceImpl();
		List<Menus> menuList=menuService.queryAllMenus("1");
		String[] divStr=new String[menuList.size()*10];
		String str="";
		for (Menus m : menuList) {
			String	s="";
			if(m.getF_id()==0){
				divStr[m.getM_id()]="<td><div id='div"+m.getM_id()+"'>";//</div></td>
				 for (Powers p : list) {
					if(p.getP_id()==m.getM_id()){
						 s="checked='checked'";
					}
				}
				 str+="<td><a href='javascript:;' id='m"+m.getM_id()+"'>" +
					"<input type='checkbox' id='"+m.getM_id()+"' name='ch' onclick='check(this,"+m.getM_id()+")' value='"+m.getM_id()+"'"+s+"/>"+m.getM_name()+"</a></td>";
			} 
			
		}
		for(Menus m : menuList){
			for (Menus m2 : menuList){
				String	s="";
				if(m2.getF_id()==m.getM_id()){
					 for (Powers p : list) {
							if(p.getP_id()==m2.getM_id()){
								 s="checked='checked'";
							}
						}
					divStr[m.getM_id()]+="<a href='javascript:;' ><input type='checkbox'  id='"+m2.getM_id()+"'  onclick='checkMenu(this,"+m2.getF_id()+")' name='ch' value='"+m2.getM_id()+"'"+s+"/>"+m2.getM_name()+"</a>";
				}
			}
		}
		for(int i=0;i<divStr.length;i++){
			if(divStr[i]!=null)
				divStr[i]+="</div></td>";
		}
		request.setAttribute("power", power);
		request.setAttribute("divStr", divStr);
		request.getRequestDispatcher("backstage/power/web_page/powerAppend.jsp?status="+status+"&str="+str).forward(request, response);
	}
	private void UpdateAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("pid");
		String status=request.getParameter("status");
		String ids[]=request.getParameterValues("ch");
		String menu="";
		for (String i : ids) {
			menu+=i+",";
		}
		menu=menu.substring(0, menu.length()-1);
		IPowersService powerService=new PowersServiceImpl();
		Powers power=powerService.queryPowersById(Integer.parseInt(id));
		power.setP_menus(menu);
		if(powerService.updatePowers(power)>0)
			request.getRequestDispatcher("Powers?method=query&status="+status).forward(request, response);
	}
}
