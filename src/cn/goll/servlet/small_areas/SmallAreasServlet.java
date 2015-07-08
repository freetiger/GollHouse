package cn.goll.servlet.small_areas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
import cn.goll.entity.Companys;
import cn.goll.entity.House_Imgs;
import cn.goll.entity.Houses;
import cn.goll.entity.Personals;
import cn.goll.entity.Small_Area_Imgs;
import cn.goll.entity.Small_Areas;
import cn.goll.service.IAreasService;
import cn.goll.service.ICompanysService;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.IHousesService;
import cn.goll.service.ISmall_Area_ImgsService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.impl.AreasServiceImpl;
import cn.goll.service.impl.CompanysServiceImpl;
import cn.goll.service.impl.House_ImgsServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.PersonalsServiceImpl;
import cn.goll.service.impl.Small_Area_ImgsServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;
@SuppressWarnings("serial")
public class SmallAreasServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 if(method.equals("query"))Query(request,response,null,-1);
		 if(method.equals("querySmallAreasByAreas"))QuerySmallAreasByAreas(request,response,null,-1,null);
		 if(method.equals("remove"))Remove(request,response);
		 if(method.equals("removeSmallAreas"))RemoveAreas(request,response);
		 if(method.equals("check"))Check(request,response);
		 if(method.equals("checkSmallAreas"))CheckAreas(request,response);
		 if(method.equals("selForFront"))selForFront(request,response);
	}

	public void Query(HttpServletRequest request, HttpServletResponse response,String type,int result)
			throws ServletException, IOException {
		if(type==null)
			type=request.getParameter("type");
		String ischarge="";
		String action="";
		if(type.equals("1")){
			action="SmallAreas?method=removeSmallAreas&type=1";
			ischarge="1";
		}
		else if(type.equals("2")){
			action="SmallAreas?method=checkSmallAreas&type=2";
			ischarge="0";
		}else if(type.equals("0")){
			ischarge="1";
		}
		String jspParam="SmallAreas?method=query&type="+type;
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		IAreasService areasService=new AreasServiceImpl();
		List<Small_Areas> list=smallAreasService.querySmall_Areas(null);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_AreasByPages(page, ischarge);
		List<Areas> areaList=areasService.queryAllAreas(null);
		request.getSession(false).setAttribute("pages", page);
		request.setAttribute("smallAreaList", smallAreaList);
		request.setAttribute("areaList", areaList);
		request.setAttribute("action", action);
		request.setAttribute("jspParam", jspParam);
		request.getRequestDispatcher("backstage/smallArea/web_page/smallAreaList.jsp?type="+type+"&result="+result).forward(request, response);
	}
	
	public void QuerySmallAreasByAreas(HttpServletRequest request, HttpServletResponse response,String type,int result,String from)
		throws ServletException, IOException {
		String a_id=request.getParameter("a_id");
		if(type==null)
			type=request.getParameter("type");
		if(from==null)
			from=request.getParameter("from");
		String action="";
		if(type.equals("1"))
			action="SmallAreas?method=removeSmallAreas&type=1";
		else if(type.equals("2"))
			action="SmallAreas?method=checkSmallAreas&type=2";
		String jspParam="SmallAreas?method=querySmallAreasByAreas&a_id="+a_id+"&type="+type;
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		IAreasService areasService=new AreasServiceImpl();
		List<Small_Areas> list=smallAreasService.querySmall_AreasByA_id(Integer.valueOf(a_id), null);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_AreasByPagesWithA_id(Integer.valueOf(a_id), page, null);
		List<Areas> areaList=areasService.queryAllAreas(null);
		request.getSession(false).setAttribute("pages", page);
		request.setAttribute("smallAreaList", smallAreaList);
		request.setAttribute("areaList", areaList);
		request.setAttribute("action", action);
		request.setAttribute("jspParam", jspParam);
		request.getRequestDispatcher("backstage/smallArea/web_page/smallAreaList.jsp?type="+type+"&result="+result).forward(request, response);
	}
	
	public void Remove(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("sa_id");
		int id=Integer.valueOf(idStr);
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		int result=smallAreasService.deleteSmall_Areas(id);
		Query(request,response,type,result);
	}
	
	public void RemoveAreas(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("sa_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		int result=smallAreasService.deleteSmall_AreasByIds(ids);
		Query(request,response,type,result);
	}
	
	public void Check(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("sa_id");
		int id=Integer.valueOf(idStr);
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		Small_Areas smallArea=smallAreasService.querySmall_AreasById(id, null);
		smallArea.setSa_ischeck("1");
		int result=smallAreasService.updateSmall_Areas(smallArea);
		Query(request,response,type,result);
	}
	
	public void CheckAreas(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("sa_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_AreasByIds(ids, null);
		for (Small_Areas smallAreas : smallAreaList) {
			smallAreas.setSa_ischeck("1");
		}
		int result=smallAreasService.updateSmall_AreasList(smallAreaList);
		Query(request,response,type,result);
	}
	//前端查询
	public void selForFront(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
		List<Small_Areas> list=smallAreasService.querySmall_Areas("1");
		DoPage page=new DoPage();
		page.setCounts(list.size());
		page.setPageSize(10);
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		ISmall_Area_ImgsService saiservice=new Small_Area_ImgsServiceImpl();
		List<Small_Areas> small_list=smallAreasService.querySmall_AreasByPages(page, "1");
		List<Small_Area_Imgs> saimg;
		
		for (int i = 0; i < small_list.size(); i++) {
			String strimg=small_list.get(i).getSai_ids();
			String []arrImg=strimg.split(",");
			saimg=new ArrayList<Small_Area_Imgs>();
			for (int j = 0; j < arrImg.length; j++) {
				Small_Area_Imgs sai=saiservice.querySmall_Area_ImgsById(Integer.parseInt(arrImg[j]), "1");
				saimg.add(sai);
			}
			small_list.get(i).setList(saimg);
		}
		
		IHousesService houseservice=new HousesServiceImpl();
		List<Houses> hlist=houseservice.queryHousesByIsup(1);
		IHouse_ImgsService house_img=new House_ImgsServiceImpl();
		List<Houses> houselists=new ArrayList<Houses>();
		if(hlist.size()>=4){
			for (int i = 0; i < 4; i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				//将图片的个数存放在集合中，下标为4
				String h_hi_ids=house.getH_hi_ids();
				String[] imgs=h_hi_ids.split(",");
				List<House_Imgs> imgList=new ArrayList<House_Imgs>();
				for (int j = 0; j < imgs.length; j++) {
					House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[j]), null);
					imgList.add(houseImg);
					house.getList().add(imgList);
			}
				
				houselists.add(house);
			}			
		}
		if(hlist==null||hlist.size()<4){
			int count=4;
			List<Houses> houselist=houseservice.queryAllHouses("1");
			for (int i = 0; i < hlist.size(); i++) {
				int id=hlist.get(i).getH_id();
				Houses house=houseservice.queryHouseById(id);
				//将图片的个数存放在集合中，下标为4
				String h_hi_ids=house.getH_hi_ids();
				String[] imgs=h_hi_ids.split(",");
				List<House_Imgs> imgList=new ArrayList<House_Imgs>();
				for (int j = 0; j < imgs.length; j++) {
					House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[j]), null);
					imgList.add(houseImg);
					house.getList().add(imgList);
			}
				
				houselists.add(house);
				count--;
			}
			for (int j = 0; j <=count; j++) {
				int id=houselist.get(j).getH_id();
					Houses house=houseservice.queryHouseById(id);
					//将图片的个数存放在集合中，下标为4
					String h_hi_ids=house.getH_hi_ids();
					String[] imgs=h_hi_ids.split(",");
					List<House_Imgs> imgList=new ArrayList<House_Imgs>();
					for (int i = 0; i < imgs.length; i++) {
						House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[i]), null);
						imgList.add(houseImg);
						house.getList().add(imgList);
				}
					
					houselists.add(house);
					count--;
			}
		}		
		
		//查总房源数、个人房源数
		List<Houses> housel=houseservice.queryAllHouses("1");//总房源
		int numAll=housel.size();
		List<Houses> Phouse=houseservice.queryAllHouses(0);
		int Pnum=Phouse.size();
		List<Personals> ps=new PersonalsServiceImpl().queryAllPersonals("1");
		//	
	
		request.setAttribute("ps", ps.size());
		request.setAttribute("nam", numAll);
		request.setAttribute("Pnum", Pnum);
		request.setAttribute("houselist", houselists);
		request.setAttribute("pages", page);
		request.setAttribute("small_list", small_list);
		request.getRequestDispatcher("front/smallArea/web_page/smallAreaList.jsp").forward(request, response);
	}
}
