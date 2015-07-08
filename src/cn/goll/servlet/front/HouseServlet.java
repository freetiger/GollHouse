package cn.goll.servlet.front;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
import cn.goll.entity.Brokers;
import cn.goll.entity.House_Imgs;
import cn.goll.entity.House_Types;
import cn.goll.entity.House_Years;
import cn.goll.entity.Houses;
import cn.goll.entity.Out_Rents;
import cn.goll.entity.Personals;
import cn.goll.entity.Rent_Moneys;
import cn.goll.entity.Rent_Types;
import cn.goll.entity.Seek_Rents;
import cn.goll.entity.Small_Areas;
import cn.goll.service.IAreasService;
import cn.goll.service.IBrokersService;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.IHouse_TypesService;
import cn.goll.service.IHouse_YearsService;
import cn.goll.service.IHousesService;
import cn.goll.service.IOut_RentsService;
import cn.goll.service.IPersonalsService;
import cn.goll.service.IRent_MoneysService;
import cn.goll.service.IRent_TypesService;
import cn.goll.service.ISeek_RentsService;
import cn.goll.service.ISmall_Area_ImgsService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.impl.AreasServiceImpl;
import cn.goll.service.impl.BrokersServiceImpl;
import cn.goll.service.impl.House_ImgsServiceImpl;
import cn.goll.service.impl.House_TypesServiceImpl;
import cn.goll.service.impl.House_YearsServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.Out_RentsServiceImpl;
import cn.goll.service.impl.PersonalsServiceImpl;
import cn.goll.service.impl.Rent_MoneysServiceImpl;
import cn.goll.service.impl.Rent_TypesServiceImpl;
import cn.goll.service.impl.Seek_RentsServiceImpl;
import cn.goll.service.impl.Small_Area_ImgsServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;
@SuppressWarnings("serial")
public class HouseServlet extends HttpServlet{
	IHousesService housesService=new HousesServiceImpl();
	IHouse_ImgsService houseImgsService=new House_ImgsServiceImpl();
	IAreasService areasService=new AreasServiceImpl();
	IRent_MoneysService rentMoneysService=new Rent_MoneysServiceImpl();
	IHouse_TypesService houseTypesService=new House_TypesServiceImpl();
	IRent_TypesService rentTypesService=new Rent_TypesServiceImpl();
	IHouse_YearsService houseYearsService=new House_YearsServiceImpl();
	ISmall_AreasService smallAreasService=new Small_AreasServiceImpl();
	ISmall_Area_ImgsService smallAreaImgsService=new Small_Area_ImgsServiceImpl();
	IOut_RentsService rentOutsService=new Out_RentsServiceImpl();
	IBrokersService brokersService=new BrokersServiceImpl();
	IPersonalsService personalsService=new PersonalsServiceImpl();
	ISeek_RentsService seekRentsService=new Seek_RentsServiceImpl();
	String rentOutSql="select * from houses h,areas a,house_types ht,out_rents ors,rent_types rt,small_areas sa,pay_types pt "+
				"where ors.a_id=a.a_id and ors.h_id=h.h_id and h.ht_id=ht.ht_id and h.rt_id=rt.rt_id and pt.pt_id=h.pt_id "+
				"and sa.sa_id=ors.sa_id and h.h_isrent=0 and h.h_ischeck=1";//出租房源sql查询语句
	String area_sql="";//区域条件
	String rentMoney_sql="";//价格条件
	String houseType_sql="";//房源类型条件
	String rentType_sql="";//出租类型条件
	String houseYear_sql="";//年份条件
	String smallArea_sql="";//小区条件
	/* 房源表关联
	out_rents----small_Areas,rent_types,houses
	small_areas----small_area_imgs,areas
	
	houses-----pay_type,house_types,house_imgs,brokers,house_equip_type,rent_types
	brokers----companys,houses
	*/
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("queryIndex"))QueryIndex(request,response);
		if(method.equals("queryRentOut"))QueryRentOut(request,response);
		if(method.equals("queryPersonal"))QueryPersonal(request,response);
		if(method.equals("querySeekRent"))QuerySeekRent(request,response);
		if(method.equals("queryCompany"))QueryCompany(request,response);
		if(method.equals("queryBroker"))QueryBroker(request,response);
		if(method.equals("querySmallArea"))QuerySmallArea(request,response);
		if(method.equals("queryRentOutByPage"))QueryRentOutByPage(request,response);
	}
	
	//查询所有的房源信息
	public void QueryIndex(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		List<Houses> list=housesService.queryAllHouses();
		int personalCount=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getH_ischarge()==0)
				personalCount++;
		}
		DoPage page=new DoPage();
		page.setCounts(list.size());
		page.setCurrentPage(1);
		page.setPageSize(6);
		List<Houses> houseList=housesService.queryAllHouses(0, page);
		List<String> houseImgPathList=new ArrayList<String>();
		for (Houses houses : houseList) {
			String h_hi_ids=houses.getH_hi_ids();
			String[] ids=h_hi_ids.split(",");
			House_Imgs houseImg=houseImgsService.queryHouse_ImgsById(Integer.valueOf(ids[0]), "1");
			houseImgPathList.add(houseImg.getHi_url());
		}
		List<Areas> areaList=areasService.queryAllAreas("1");
		List<Rent_Moneys> rentMoneyList=rentMoneysService.queryAllRent_Moneys();
		List<House_Types> houseTypeList=houseTypesService.queryAllHouse_Types();
		List<Rent_Types> rentTypeList=rentTypesService.queryAllRent_Types();
		List<House_Years> houseYearList=houseYearsService.queryAllHouse_Years();
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_Areas("1");
		List<Out_Rents> rentOutList=rentOutsService.queryAllOut_Rents("1");
		List<Houses> interestList=housesService.queryHousesByIsupAndtime(1);
		List<House_Imgs> interestImgList=new ArrayList<House_Imgs>();
		House_Imgs houseImg=new House_Imgs();
		for (Houses houses : interestList) {
			String[] hi_ids=houses.getH_hi_ids().split(",");
			houseImg=houseImgsService.queryHouse_ImgsById(Integer.valueOf(hi_ids[0]), "1");
			interestImgList.add(houseImg);
		}
		request.setAttribute("houseList", houseList);
		request.setAttribute("houseImgPathList", houseImgPathList);
		request.setAttribute("areaList", areaList);
		request.setAttribute("rentMoneyList", rentMoneyList);
		request.setAttribute("houseTypeList", houseTypeList);
		request.setAttribute("rentTypeList", rentTypeList);
		request.setAttribute("houseYearList", houseYearList);
		request.setAttribute("smallAreaList", smallAreaList);
		request.setAttribute("personalCount", personalCount);
		request.setAttribute("houseCount", list.size());
		request.setAttribute("rentOutList", rentOutList);
		request.setAttribute("interestList", interestList);
		request.setAttribute("interestImgList", interestImgList);
		request.getRequestDispatcher("front/houses/web_page/index.jsp?flag=1").forward(request, response);
	}
	
	//出租列表操作
	public void QueryRentOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_name=request.getParameter("id_name");
		if(id_name.equals("all_id"))QueryRentOutByAll(request,response);
		if(id_name.equals("a_id"))QueryRentOutByAreas(request,response);
		if(id_name.equals("rm_id"))QueryRentOutByRentMoneys(request,response);
		if(id_name.equals("ht_id"))QueryRentOutByHouseTypes(request,response);
		if(id_name.equals("rt_id"))QueryRentOutByRentTypes(request,response);
		if(id_name.equals("hy_id"))QueryRentOutByHouseYears(request,response);
		if(id_name.equals("sa_id"))QueryRentOutBySmallAreas(request,response);
	}
	
	//出租列表页面分页操作
	public void QueryRentOutByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql=rentOutSql+area_sql+rentMoney_sql+houseType_sql+rentType_sql+houseYear_sql+smallArea_sql;
		List<Houses> list=housesService.queryHousesBySql(sql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(sql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//出租列表页面跳转
	public void ForwardRentOut(HttpServletRequest request, HttpServletResponse response,List<Houses> list,DoPage page)
			throws ServletException, IOException {
		List<String> houseImgPathList=new ArrayList<String>();
		for (Houses houses : list) {
			String h_hi_ids=houses.getH_hi_ids();
			String[] ids=h_hi_ids.split(",");
			House_Imgs houseImg=houseImgsService.queryHouse_ImgsById(Integer.valueOf(ids[0]), "1");
			houseImgPathList.add(houseImg.getHi_url());
		}
		List<Areas> areaList=areasService.queryAllAreas("1");
		List<Rent_Moneys> rentMoneyList=rentMoneysService.queryAllRent_Moneys();
		List<House_Types> houseTypeList=houseTypesService.queryAllHouse_Types();
		List<Rent_Types> rentTypeList=rentTypesService.queryAllRent_Types();
		List<House_Years> houseYearList=houseYearsService.queryAllHouse_Years();
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_Areas("1");
		List<Out_Rents> rentOutList=rentOutsService.queryAllOut_Rents("1");
		List<Personals> personalList=personalsService.queryAllPersonals("1");
		List<Brokers> brokerList=brokersService.queryAllBrokers("1");
		int count=housesService.queryAllHouses("1").size();
		request.setAttribute("houseImgPathList", houseImgPathList);
		request.setAttribute("areaList", areaList);
		request.setAttribute("rentMoneyList", rentMoneyList);
		request.setAttribute("houseTypeList", houseTypeList);
		request.setAttribute("rentTypeList", rentTypeList);
		request.setAttribute("houseYearList", houseYearList);
		request.setAttribute("smallAreaList", smallAreaList);
		request.setAttribute("houseCount", count);
		request.setAttribute("houseList", list);
		request.setAttribute("rentOutList", rentOutList);
		request.setAttribute("personalList", personalList);
		request.setAttribute("brokerList", brokerList);
		request.setAttribute("pager", page);
		request.getRequestDispatcher("front/houses/web_page/HouseMenus.jsp").forward(request, response);
	}
	
	//查询所有的房源信息
	public void QueryRentOutByAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Houses> list=housesService.queryHousesBySql(rentOutSql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(rentOutSql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//查询指定区域的房源信息
	public void QueryRentOutByAreas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_id=request.getParameter("a_id");
		if(!a_id.equals("0"))
			area_sql=" and a.a_id="+a_id;
		else
			area_sql="";
		String sql=rentOutSql+area_sql+rentMoney_sql+houseType_sql+rentType_sql+houseYear_sql+smallArea_sql;
		List<Houses> list=housesService.queryHousesBySql(sql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(sql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//查询指定价格的房源信息
	public void QueryRentOutByRentMoneys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	//查询指定房源类型的房源信息
	public void QueryRentOutByHouseTypes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ht_id=request.getParameter("ht_id");
		if(!ht_id.equals("0"))
			houseType_sql=" and h.ht_id="+ht_id;
		else
			houseType_sql="";
		String sql=rentOutSql+area_sql+rentMoney_sql+houseType_sql+rentType_sql+houseYear_sql+smallArea_sql;
		List<Houses> list=housesService.queryHousesBySql(sql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(sql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//查询指定出租类型的房源信息
	public void QueryRentOutByRentTypes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rt_id=request.getParameter("rt_id");
		if(!rt_id.equals("0"))
			rentType_sql=" and h.rt_id="+rt_id;
		else
			rentType_sql="";
		String sql=rentOutSql+area_sql+rentMoney_sql+houseType_sql+rentType_sql+houseYear_sql+smallArea_sql;
		List<Houses> list=housesService.queryHousesBySql(sql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(sql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//查询指定年份的房源信息
	public void QueryRentOutByHouseYears(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	//查询指定小区的房源信息
	public void QueryRentOutBySmallAreas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sa_id=request.getParameter("sa_id");
		if(!sa_id.equals("0"))
			smallArea_sql=" and ors.sa_id="+sa_id;
		else
			smallArea_sql="";
		String sql=rentOutSql+area_sql+rentMoney_sql+houseType_sql+rentType_sql+houseYear_sql+smallArea_sql;
		List<Houses> list=housesService.queryHousesBySql(sql);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySqlWithPage(sql, page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request,response,houseList,page);
	}
	
	//个人房源列表
	public void QueryPersonal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Houses> list=housesService.queryAllHouses(0);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryAllHouses(0,page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		ForwardRentOut(request, response, houseList, page);
	}
	
	//求租列表
	public void QuerySeekRent(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		List<Seek_Rents> list=seekRentsService.queryAllSeek_Rents("1");
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Seek_Rents> seekRentList=seekRentsService.queryAllSeek_Rents("1", page);
		List<Small_Areas> smallAreaList=smallAreasService.querySmall_Areas("1");
		List<Rent_Moneys> rentMoneyList=rentMoneysService.queryAllRent_Moneys();
		request.setAttribute("seekRentList", seekRentList);
		request.setAttribute("smallAreaList", smallAreaList);
		request.setAttribute("rentMoneyList", rentMoneyList);
		request.setAttribute("houseCount", list.size());
		request.setAttribute("pager", page);
		request.getRequestDispatcher("front/seekRent/web_page/seekRentList.jsp").forward(request, response);
	}
	
	//公司关联的房源列表
	public void QueryCompany(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_id=request.getParameter("c_id");
		String typeName=request.getParameter("typeName");
		List<Houses> list=housesService.queryHousesByC_id(Integer.valueOf(c_id));
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesByC_idWithPage(Integer.valueOf(c_id), page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		request.setAttribute("typeName", typeName);
		ForwardRentOut(request, response, houseList, page);
	}
	
	//经纪人关联的房源列表
	public void QueryBroker(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_id=request.getParameter("b_id");
		String typeName=request.getParameter("typeName");
		List<Houses> list=housesService.selectHouses(1, Integer.parseInt(b_id), "1");
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHouses(1,Integer.valueOf(b_id),"1", page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		request.setAttribute("typeName", typeName);
		ForwardRentOut(request, response, houseList, page);
	}
	
	//小区关联的房源列表
	public void QuerySmallArea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sa_id=request.getParameter("sa_id");
		String typeName=request.getParameter("typeName");
		List<Houses> list=housesService.queryHousesBySa_id(Integer.valueOf(sa_id));
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.valueOf(request.getParameter("page")));
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryHousesBySa_idWithPage(Integer.valueOf(sa_id), page);
		int count=housesService.queryAllHouses(0).size();
		request.setAttribute("personalCount", count);
		request.setAttribute("typeName", typeName);
		ForwardRentOut(request, response, houseList, page);
	}
	
	//搜索框关键字查询
	public void QueryTag(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(111);
		String tags=housesService.queryHousesAllTag();
		List<String> tagList=new ArrayList<String>();
		String[] tagArr=tags.split(",");
		for (int i = 0; i < tagArr.length; i++) {
			tagList.add(tagArr[i]);
		}
		request.setAttribute("tagList", tagList);
		request.getRequestDispatcher("front/common/searchBar.jsp?flag=1").forward(request, response);
	}
}
