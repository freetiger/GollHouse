package cn.goll.servlet.houses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
import cn.goll.entity.Companys;
import cn.goll.entity.Houses;
import cn.goll.entity.Seek_Rents;
import cn.goll.entity.Small_Areas;
import cn.goll.service.IAreasService;
import cn.goll.service.ICompanysService;
import cn.goll.service.IHousesService;
import cn.goll.service.ISeek_RentsService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.impl.AreasServiceImpl;
import cn.goll.service.impl.CompanysServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.Seek_RentsServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;

public class SeekRentServlet extends HttpServlet{

	ISeek_RentsService seekRent=new Seek_RentsServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("selAll")){
			selAll(request,response);
		}
		if(method.equals("del"))
			deleteById(request,response);
		if(method.equals("check"))
			checkById(request,response);
		if(method.equals("selForFront"))
			selForFront(request,response);
		if(method.equals("saveSeek"))
			saveSeek(request,response);
						
	}
	//查询
	public void selAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ISeek_RentsService srService=new Seek_RentsServiceImpl();
		//查询未审核的求租
		List<Seek_Rents> srList=srService.queryAllSeek_Rents("0");
		//查询所有的求租 
		List<Seek_Rents> srAllList=srService.queryAllSeek_Rents(null);
		ServletContext application=this.getServletContext();
		application.setAttribute("OverSr", srList.size());
		application.setAttribute("OverSrAll", srAllList.size());
		DoPage pager=new DoPage();
		
		String state=request.getParameter("state");
		String ischeck;//审核
		try{
			ischeck=request.getParameter("ischeck");
		}catch(Exception e){
			ischeck=null;
		}
		pager.setCounts(seekRent.queryAllSeek_Rents(ischeck).size());
		String page=request.getParameter("page");
		try{//分页
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Seek_Rents> list=seekRent.queryAllSeek_Rents(ischeck, pager);
		 request.getSession(false).setAttribute("pages", pager);
		request.setAttribute("srList", list);
		if(state.equals("0")){//0查看-----1//删除----2、审核
			 request.setAttribute("jspParam", "SeekRent?method=selAll&state=0");
			 request.getRequestDispatcher("backstage/houses/web_page/houseSeekRent.jsp?state=0").forward(request, response);
		}
		if(state.equals("1")){//0查看-----1//删除----2、审核
			 request.setAttribute("jspParam", "SeekRent?method=selAll&state=1");
			 request.getRequestDispatcher("/backstage/houses/web_page/houseSeekRent.jsp?state=1").forward(request, response);
		}
		if(state.equals("2")){//0查看-----1//删除----2、审核
			 request.setAttribute("jspParam", "SeekRent?method=selAll&state=2");
			 request.getRequestDispatcher("/backstage/houses/web_page/houseSeekRent.jsp?state=2").forward(request, response);
		}
	}
	//删除
	public void deleteById(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("id");
		int sr_id=Integer.parseInt(id);
		seekRent.deleteSeek_Rents(sr_id);
		ISeek_RentsService srService=new Seek_RentsServiceImpl();
		//查询未审核的求租
		List<Seek_Rents> srList=srService.queryAllSeek_Rents("0");
		//查询所有的求租 
		List<Seek_Rents> srAllList=srService.queryAllSeek_Rents(null);
		ServletContext application=this.getServletContext();
		application.setAttribute("OverSr", srList.size());
		application.setAttribute("OverSrAll", srAllList.size());
		DoPage pager=new DoPage();		
		pager.setCounts(seekRent.queryAllSeek_Rents(null).size());
		String page=request.getParameter("page");
		try{//分页
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Seek_Rents> list=seekRent.queryAllSeek_Rents(null, pager);
		request.getSession(false).setAttribute("pages", pager);
		request.setAttribute("srList", list);
	    request.setAttribute("jspParam", "SeekRent?method=selAll&state=1");
	    request.getRequestDispatcher("/backstage/houses/web_page/houseSeekRent.jsp?state=1").forward(request, response);
	}
	//审核
	public void checkById(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("id");
		int sr_id=Integer.parseInt(id);
		seekRent.updateSeek_Rents(sr_id, "1");
		ServletContext application=this.getServletContext();
		application.setAttribute("OverSr", (Integer)application.getAttribute("OverSr")-1);
		DoPage pager=new DoPage();		
		pager.setCounts(seekRent.queryAllSeek_Rents("0").size());
		String page=request.getParameter("page");
		try{//分页
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Seek_Rents> list=seekRent.queryAllSeek_Rents("0", pager);
		request.getSession(false).setAttribute("pages", pager);
		request.setAttribute("srList", list);
	    request.setAttribute("jspParam", "SeekRent?method=selAll&state=2&ischeck=0");
	    request.getRequestDispatcher("/backstage/houses/web_page/houseSeekRent.jsp?state=2").forward(request, response);
		
	}
	
	//前台求租信息发布页的准备
	public void selForFront(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		IAreasService areaService=new AreasServiceImpl();
		ISmall_AreasService saService=new Small_AreasServiceImpl();
		List<Areas> alist=areaService.queryAllAreas("1");
		List<Small_Areas> salist=saService.querySmall_Areas("1");
		IHousesService houseservice=new HousesServiceImpl();
		List<Houses> hlist=houseservice.queryHousesByIsup(1);
		
		List<Houses> houselists=new ArrayList<Houses>();
		if(hlist.size()>=4){
			for (int i = 0; i < 4; i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				houselists.add(house);
			}			
		}
		if(hlist==null||hlist.size()<4){
			int count=4;
			List<Houses> houselist=houseservice.queryAllHouses("1");
			for (int i = 0; i < hlist.size(); i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				houselists.add(house);
				count--;
			}
			for (int j = 0; j <=count; j++) {
				int id=houselist.get(j).getH_id();
					Houses house=houseservice.queryHouseById(id);
					houselists.add(house);
					count--;
				
			}
		}
		
		request.setAttribute("houselist", houselists);
		request.setAttribute("alist", alist);
		request.setAttribute("salist", salist);
		request.getRequestDispatcher("front/person/web_page/qiuZu.jsp").forward(request, response);
	}
	
	//保存求租信息
	public void saveSeek(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String price1=request.getParameter("price1");
		String price2=request.getParameter("price2");
		String price=price1+"-"+price2;
		String area=request.getParameter("area");
		String small_area=request.getParameter("small_area");
		String sr_infos=request.getParameter("sr_infos");
		Seek_Rents seek=new Seek_Rents(price, tel, "0", Integer.parseInt(area), sr_infos, Integer.parseInt(small_area));
		ISeek_RentsService sr=new Seek_RentsServiceImpl();
		sr.insertSeek_Rents(seek);
		ISeek_RentsService srService=new Seek_RentsServiceImpl();
		//查询未审核的求租
		List<Seek_Rents> srList=srService.queryAllSeek_Rents("0");
		//查询所有的求租 
		List<Seek_Rents> srAllList=srService.queryAllSeek_Rents(null);
		ServletContext application=this.getServletContext();
		application.setAttribute("OverSr", srList.size());
		application.setAttribute("OverSrAll", srAllList.size());
		request.getRequestDispatcher("front/houses/web_page/index.jsp").forward(request, response);
		
	}
}
