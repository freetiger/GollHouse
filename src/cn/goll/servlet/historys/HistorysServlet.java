package cn.goll.servlet.historys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.goll.common.DoPage;
import cn.goll.entity.Historys;
import cn.goll.entity.Managers;
import cn.goll.service.IHistorysService;
import cn.goll.service.impl.HistorysServiceImpl;

public class HistorysServlet extends HttpServlet{

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
		if(method.equals("delete"))Delete(request,response);
		if(method.equals("queryTime"))QueryTime(request,response);
	}
	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IHistorysService hisService=new HistorysServiceImpl();
		List<Historys> historyList= hisService.queryAllHistorys();
		DoPage page=new DoPage();
		page.setCounts(historyList.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		historyList= hisService.queryAllHistorys(page);
		request.setAttribute("historyList", historyList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("jspparam", "Historys?method=query");
		request.getRequestDispatcher("backstage/history/web_page/historyList.jsp").forward(request, response);
	}
	private void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		IHistorysService hisService=new HistorysServiceImpl();
		hisService.deleteHistorys(Integer.parseInt(id));
		List<Historys> historyList= hisService.queryAllHistorys();
		DoPage page=new DoPage();
		page.setCounts(historyList.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		historyList= hisService.queryAllHistorys(page);
		request.setAttribute("historyList", historyList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("jspparam", "Historys?method=query");
		request.getRequestDispatcher("backstage/history/web_page/historyList.jsp").forward(request, response);
	}
	private void QueryTime(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Managers manager=(Managers) request.getSession(false).getAttribute("manager");
		int id=manager.getId();
		//对XML文件的读写所需的工具类
		//读SAXReader
		//输出格式对象
		OutputFormat outFormat=OutputFormat.createPrettyPrint();
		outFormat.setEncoding("gbk");
		SAXReader reader=new SAXReader();
		String filePath="d:\\gollhouse\\logintime\\user.xml";
		File file=new File(filePath);
		String time="";
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
					if(user.attributeValue("id").equals(String.valueOf(id))){
						time="您上次登录的时间："+user.element("lastTime").getText();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			 time="暂无您的记录";
		}
		PrintWriter out=response.getWriter();
		out.print(time);
		out.flush();
		out.close();
	}
}
