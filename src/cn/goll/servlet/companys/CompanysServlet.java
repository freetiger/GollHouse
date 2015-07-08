package cn.goll.servlet.companys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Companys;
import cn.goll.entity.House_Imgs;
import cn.goll.entity.Houses;
import cn.goll.entity.Personals;
import cn.goll.service.ICompanysService;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.IHousesService;
import cn.goll.service.impl.CompanysServiceImpl;
import cn.goll.service.impl.House_ImgsServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.PersonalsServiceImpl;
@SuppressWarnings("serial")
public class CompanysServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method=request.getParameter("method");
		 if(method.equals("query"))Query(request,response,null,-1);
		 if(method.equals("remove"))Remove(request,response);
		 if(method.equals("removeCompanys"))RemoveCompanys(request,response);
		 if(method.equals("check"))Check(request,response);
		 if(method.equals("checkCompanys"))CheckCompanys(request,response);
		 if(method.equals("queryByCid"))QueryByCid(request,response,null,-1);
		 if(method.equals("selForFront")) selForFront(request,response);
	}

	public void Query(HttpServletRequest request, HttpServletResponse response,String type,int result)
		throws ServletException, IOException {
		if(type==null)
			type=request.getParameter("type");
		String ischarge="";
		String action="";
		if(type.equals("1")){
			action="Companys?method=removeCompanys&type=1";
			ischarge="1";
		}
		else if(type.equals("2")){
			action="Companys?method=checkCompanys&type=2";
			ischarge="0";
		}else if(type.equals("0")){
			ischarge="1";
		}
		ICompanysService companysService=new CompanysServiceImpl();
		List<Companys> list=companysService.queryAllCompanys(ischarge);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Companys> companyList=companysService.queryAllCompanysByPages(page, ischarge);
		request.getSession(false).setAttribute("pages", page);
		request.setAttribute("companyList", companyList);
		request.setAttribute("action", action);
		request.getRequestDispatcher("backstage/company/web_page/companyList.jsp?type="+type+"&result="+result).forward(request, response);
	}
	
	public void Remove(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("c_id");
		int id=Integer.valueOf(idStr);
		ICompanysService companysService=new CompanysServiceImpl();
		int result=companysService.deleteCompanys(id);
		ServletContext application=this.getServletContext();
		application.setAttribute("Overcompanys", (Integer)application.getAttribute("Overcompanys")-1);
		application.setAttribute("OvercompanysAll", (Integer)application.getAttribute("OvercompanysAll")-1);
		Query(request,response,type,result);
	}
	
	public void RemoveCompanys(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("c_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		ICompanysService companysService=new CompanysServiceImpl();
		int result=companysService.deleteCompanys(ids);
		//查询未审核公司
		List<Companys> companysList=companysService.queryAllCompanys("0");
		//查询所有公司
		List<Companys> companysAllList=companysService.queryAllCompanys(null);
		ServletContext application=this.getServletContext();
		application.setAttribute("Overcompanys", companysList.size());
		application.setAttribute("OvercompanysAll", companysAllList.size());
		Query(request,response,type,result);
	}
	
	public void Check(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String idStr=request.getParameter("c_id");
		int id=Integer.valueOf(idStr);
		ICompanysService companysService=new CompanysServiceImpl();
		Companys company=companysService.queryCompanysById(id, null);
		company.setC_ischeck("1");
		int result=companysService.updateCompanys(company);
		ServletContext application=this.getServletContext();
		application.setAttribute("Overcompanys", (Integer)application.getAttribute("Overcompanys")-1);
		Query(request,response,type,result);
	}
	
	public void CheckCompanys(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type=request.getParameter("type");
		String[] idsStr=request.getParameterValues("c_id");
		int[] ids=new int[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i]=Integer.valueOf(idsStr[i]);
		}
		ICompanysService companysService=new CompanysServiceImpl();
		List<Companys> companyList=companysService.queryCompanysById(ids, null);
		for (Companys companys : companyList) {
			companys.setC_ischeck("1");
		}
		int result=companysService.updateCompanys(companyList);
		List<Companys> companysList=companysService.queryAllCompanys("0");
		//查询所有公司
		List<Companys> companysAllList=companysService.queryAllCompanys(null);
		ServletContext application=this.getServletContext();
		application.setAttribute("Overcompanys", companysList.size());
		application.setAttribute("OvercompanysAll", companysAllList.size());
		Query(request,response,type,result);
	}
	public void QueryByCid(HttpServletRequest request, HttpServletResponse response,String type,int result)
			throws ServletException, IOException {
		if(type==null)
			type=request.getParameter("type");
		String c_id=request.getParameter("c_id");
		ICompanysService companysService=new CompanysServiceImpl();
		Companys companys=companysService.queryCompanysById(Integer.valueOf(c_id), null);
		request.setAttribute("companys", companys);
		Query(request,response,type,result);
	}
	//前端查询
	public void selForFront(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ICompanysService companysService=new CompanysServiceImpl();
		List<Companys> list=companysService.queryAllCompanys("1");
		DoPage page=new DoPage();
		page.setCounts(list.size());
		page.setPageSize(10);
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		
		List<Companys> companyList=companysService.queryAllCompanysByPages(page, "1");
		
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
		request.setAttribute("companyList", companyList);
		request.getRequestDispatcher("front/company/web_page/companyList.jsp").forward(request, response);
	}
}
