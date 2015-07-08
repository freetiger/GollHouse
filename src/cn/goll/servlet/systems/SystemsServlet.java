package cn.goll.servlet.systems;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.goll.entity.Systems;
import cn.goll.service.ISystemsService;
import cn.goll.service.impl.SystemsServiceImpl;

public class SystemsServlet extends HttpServlet {

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
	}
	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String	status=request.getParameter("status");
		ISystemsService systemService=new SystemsServiceImpl();
		List<Systems> list=systemService.queryAllSystems();
		request.getSession(false).setAttribute("systems", list.get(0));
		request.getRequestDispatcher("backstage/common/web_information.jsp?status="+status).forward(request, response);
	}
	private void Update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String status=request.getParameter("status");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String dns=request.getParameter("dns");
		String tag=request.getParameter("tag");
		String logo=request.getParameter("logo");
		String qq=request.getParameter("qq");
		String tel=request.getParameter("tel");
		String date=request.getParameter("date");
		String infos=request.getParameter("infos");
		ISystemsService systemService=new SystemsServiceImpl();
		Systems s=systemService.querySystemsById(Integer.parseInt(id));
		s.setSys_name(name);
		s.setSys_dns(dns);
		s.setSys_logo(logo);
		s.setSys_qq(qq);
		s.setSys_tag(tag);
		s.setSys_tel(tel);
		s.setSys_date(date);
		s.setSys_infos(infos);
		if(systemService.updateSystems(s)>0){
			ServletContext application=this.getServletContext();
			application.setAttribute("Oversystems",s);
			request.getRequestDispatcher("Systems?method=query&status="+status).forward(request, response);
		}
	}
}
