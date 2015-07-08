package cn.goll.servlet.menus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.goll.entity.Managers;
import cn.goll.entity.Menus;
import cn.goll.entity.Powers;
import cn.goll.service.IMenusService;
import cn.goll.service.IPowersService;
import cn.goll.service.impl.MenusServiceImpl;
import cn.goll.service.impl.PowersServiceImpl;

public class MenusServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.endsWith("query"))Query(request,response);
		if(method.endsWith("queryAll"))QueryAll(request,response);
		if(method.endsWith("add"))AddMenus(request,response);
		if(method.endsWith("delete"))Delete(request,response);
		if(method.endsWith("deleteAll"))DeleteAll(request,response);
		if(method.endsWith("update"))Update(request,response);
	}
		
	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		IMenusService menuService=new MenusServiceImpl();
		List<Menus> mlist=menuService.queryMenusByFid(Integer.parseInt(id), "1");
		Managers manager=(Managers)request.getSession(false).getAttribute("manager");
		IPowersService powerService=new PowersServiceImpl();
		Powers managerPower=powerService.queryPowersById(manager.getP_id());
		request.getSession(false).setAttribute("managerPower", managerPower);
		String[] menu=managerPower.getP_menus().split(",");
		List<Menus> menus=new ArrayList<Menus>();
		for (Menus m : mlist) {
			for (String str : menu) {
				if(m.getM_id()==Integer.parseInt(str))
					menus.add(m);
			}
		}
		request.getSession(false).setAttribute("menus", menus);
		request.getRequestDispatcher("backstage/frame/web_page/left.jsp").forward(request, response);
	}
	
	private void QueryAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IMenusService menuService=new MenusServiceImpl();
		List<Menus> menus=menuService.queryAllMenus(null);
		request.setAttribute("allmenus", menus);
		request.getRequestDispatcher("backstage/menu/web_page/menu.jsp").forward(request, response);
	}
	
	private void AddMenus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fid=request.getParameter("fid");
		IMenusService menuService=new MenusServiceImpl();
		Menus menu=new Menus();
		menu.setF_id(Integer.parseInt(fid));
		menu.setM_isckeck("1");
		long id=menuService.insertMenus(menu);
		PrintWriter out=response.getWriter();
		out.print(String.valueOf(id));
		out.flush();
		out.close();
	}
	private void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		IMenusService menuService=new MenusServiceImpl();
		PrintWriter out=response.getWriter();
		if(menuService.deleteMenus(Integer.valueOf(id))>0) {
			out.print(true);
		}else
			out.print(false);
		out.flush();
		out.close();	
	}
	private void DeleteAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		IMenusService menuService=new MenusServiceImpl();
		PrintWriter out=response.getWriter();
		String[] ids=id.split(",");
		boolean isok=true;
		for(int i=0;i<ids.length;i++){
			menuService.deleteMenus(Integer.valueOf(ids[i]));
			//还要删除fid对应的菜单
		}
		out.print(isok);
		out.flush();
		out.close();	
	}
	private void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String url=request.getParameter("url").replaceAll("#", "&");
		IMenusService menuService=new MenusServiceImpl();
		Menus menu=menuService.queryMenusById(Integer.parseInt(id), null);
		menu.setM_name(name);
		menu.setM_url(url);
		PrintWriter out=response.getWriter();
		if(menuService.updateMenus(menu)>0)
			out.print(true);
		else
			out.print(false);
		out.flush();
		out.close();	
		}
}
