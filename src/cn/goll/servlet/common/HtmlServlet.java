package cn.goll.servlet.common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.goll.common.HtmlFactory;


/**
 * 静态生成servlet
 * 
 * @author stu
 * 
 */
public class HtmlServlet extends HttpServlet {
	
	final String houseHtmlPath="/house/";
	String root;
	public void init(ServletConfig config) throws ServletException {
		this.root=config.getServletContext().getRealPath("/");//绝对路径
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("house"))
			houseHtml(request, response);
	}

	protected void houseHtml(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		String page=request.getParameter("page");
		String id=request.getParameter("houseId");
		//前台查看时的路径，提前解析
		String url="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/findHouse?houseId="+id;
		String htmlName=method+"_"+id+".html";
		String sourceStr=HtmlFactory.getHTML(url);
		HtmlFactory.writeHTML(root+houseHtmlPath+htmlName, sourceStr);
		//跳转回原来的页面
		request.getRequestDispatcher("selectHouseInfo?page="+page).forward(request, response);
	}

}
