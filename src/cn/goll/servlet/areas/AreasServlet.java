package cn.goll.servlet.areas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
import cn.goll.service.IAreasService;
import cn.goll.service.impl.AreasServiceImpl;
@SuppressWarnings("serial")
public class AreasServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 if(method.equals("query"))Query(request,response,null,-1);
		 if(method.equals("querySmallAreas"))QuerySmallAreas(request,response,null,-1);
		 if(method.equals("remove"))Remove(request,response);
		 if(method.equals("removeAreas"))RemoveAreas(request,response);
		 if(method.equals("check"))Check(request,response);
		 if(method.equals("checkAreas"))CheckAreas(request,response);
	}

	public void QuerySmallAreas(HttpServletRequest request, HttpServletResponse response,String type,int result)
			throws ServletException, IOException {
		if(type==null)
			type=request.getParameter("type");
		String a_id=request.getParameter("a_id");
		request.getRequestDispatcher("SmallAreas?method=querySmallAreasByAreas&type="+type+"&a_id="+a_id).forward(request, response);
	}
	
	public void Query(HttpServletRequest request, HttpServletResponse response,String type,int result)
		throws ServletException, IOException {
	if(type==null)
		type=request.getParameter("type");
	String ischarge="";
	String action="";
	if(type.equals("1")){
		action="Areas?method=removeAreas&type=1";
		ischarge="1";
	}
	else if(type.equals("2")){
		action="Areas?method=checkAreas&type=2";
		ischarge="0";
	}else if(type.equals("0")){
		action="Areas?method=checkAreas&type=2";
		ischarge="1";
	}
	IAreasService areasService=new AreasServiceImpl();
	List<Areas> list=areasService.queryAllAreas(null);
	DoPage page=new DoPage();
	page.setCounts(list.size());
	try{
		page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
	}catch (Exception e) {
		page.setCurrentPage(1);
	}
	page.setPageSize(15);
	List<Areas> areaList=areasService.queryAllAreasByPage(page, ischarge);
	request.getSession(false).setAttribute("pages", page);
	request.setAttribute("areaList", areaList);
	request.setAttribute("action", action);
	request.getRequestDispatcher("backstage/area/web_page/areaList.jsp?type="+type+"&result="+result).forward(request, response);
	}
	
	public void Remove(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("a_id");
		int id=Integer.valueOf(idStr);
		IAreasService areasService=new AreasServiceImpl();
		int result=areasService.deleteAreas(id);
		Query(request,response,type,result);
	}
	
	public void RemoveAreas(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("a_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		IAreasService areasService=new AreasServiceImpl();
		int result=areasService.deleteAreasByIds(ids);
		Query(request,response,type,result);
	}
	
	public void Check(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("a_id");
		int id=Integer.valueOf(idStr);
		IAreasService areasService=new AreasServiceImpl();
		Areas area=areasService.queruAreasByid(id, null);
		area.setA_ischeck("1");
		int result=areasService.updateAreas(area);
		Query(request,response,type,result);
	}
	
	public void CheckAreas(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("a_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		IAreasService areasService=new AreasServiceImpl();
		List<Areas> areaList=areasService.queruAreasByids(ids, null);
		for (Areas areas : areaList) {
			areas.setA_ischeck("1");
		}
		int result=areasService.updateAreasList(areaList);
		Query(request,response,type,result);
	}
}
