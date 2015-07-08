package cn.goll.servlet.houses;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
import cn.goll.entity.Brokers;
import cn.goll.entity.House_Equip_Types;
import cn.goll.entity.House_Imgs;
import cn.goll.entity.Houses;
import cn.goll.entity.Out_Rents;
import cn.goll.entity.Personals;
import cn.goll.entity.Small_Areas;
import cn.goll.entity.Systems;
import cn.goll.service.IHouse_Equip_TypesService;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.IHousesService;
import cn.goll.service.IOut_RentsService;
import cn.goll.service.IPersonalsService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.ISystemsService;
import cn.goll.service.impl.AreasServiceImpl;
import cn.goll.service.impl.House_Equip_TypesServiceImpl;
import cn.goll.service.impl.House_ImgsServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.Out_RentsServiceImpl;
import cn.goll.service.impl.PersonalsServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;
import cn.goll.service.impl.SystemsServiceImpl;
@SuppressWarnings("serial")
public class HouseServlet extends HttpServlet{
	
	IHousesService houseService=new HousesServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String method=request.getParameter("method");
			if(method.equals("queryAll")){//0表示不显示操作栏的按钮，1显示删除按钮，2显示审核按钮
				queryAll(request,response,"0");
			}
			if(method.equals("queryHousesBySa_id")){
				queryHousesBySa_id(request,response,null,-1,1);
			}
			if(method.equals("queryForDel")){
				queryAll(request,response,"1");
			}
			if(method.equals("queryForCheck")){
				queryNotCheck(request,response);
			}
			if(method.equals("queryForCharge")){
				queryForCharge(request,response,"0");
			}
			if(method.equals("queryHouseById")){
				queryHouseById(request,response);
			}
			if(method.equals("del")){
				delHouseById(request,response);
			}
			if(method.equals("delHouseByhId")){
				delHouseByhId(request,response);
			}
			if(method.equals("datchDel")){
				datchDelHouse(request,response);
			}
			if(method.equals("check")){
				checkById(request,response);
			}
			if(method.equals("isup")){
				Isup(request,response);
			}
			if(method.equals("add")){
				Add(request,response);
			}
			if(method.equals("addNewHouse")){
				insertPersonHouse(request,response);
			}
			if(method.equals("queryHouseBybid")){
				queryHouseBybid(request,response);
			}
	}
	
	//查询所有的房源信息
	public void queryAll(HttpServletRequest request, HttpServletResponse response,String state)
		throws ServletException, IOException {
		DoPage pager=new DoPage();
		String page=request.getParameter("page");
		pager.setCounts(houseService.queryAllHouses().size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Houses> list=houseService.queryAllHouses(pager);
		 request.getSession(false).setAttribute("pages", pager);
		 request.setAttribute("houseList", list);
		 if(state.equals("0")){
			 request.setAttribute("jspParam", "Houses?method=queryAll");
		 }
		 if(state.equals("1")){
			 request.setAttribute("jspParam", "Houses?method=queryForDel");
		 }
		 if(state.equals("3")){
			 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=1&state=3");
		 }
		 request.getRequestDispatcher("backstage/houses/web_page/houseList.jsp?state="+state).forward(request, response);
	}
	//查询小区id所关联的房源信息
	public void queryHousesBySa_id(HttpServletRequest request, HttpServletResponse response,String state,int result,int ischarge)
		throws ServletException, IOException {
		String sa_id=request.getParameter("sa_id");
		if(state==null)
			state=request.getParameter("state");
		String jspParam="Houses?method=queryHousesBySa_id&sa_id="+sa_id+"&state="+state;
		IHousesService housesService=new HousesServiceImpl();
		List<Houses> list=housesService.queryAllHousesBySa_id(Integer.valueOf(sa_id), ischarge, null);
		DoPage page=new DoPage();
		page.setCounts(list.size());
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		page.setPageSize(15);
		List<Houses> houseList=housesService.queryAllHousesBySa_idWithPages(Integer.valueOf(sa_id), ischarge, page, null);
		request.getSession(false).setAttribute("pages", page);
		request.setAttribute("houseList", houseList);
		request.setAttribute("jspParam", jspParam);
		request.getRequestDispatcher("backstage/houses/web_page/houseList.jsp?state="+state+"&result="+result).forward(request, response);
	}
	//查询审核类型的房源信息
	public void queryNotCheck(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String h_isCheck=request.getParameter("h_isCheck");
		String	state=request.getParameter("state");
		DoPage pager=new DoPage();
		String page=request.getParameter("page");
		pager.setCounts(houseService.queryAllHouses(h_isCheck).size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Houses> list=houseService.queryAllHouses(h_isCheck,pager);
		request.getSession(false).setAttribute("pages", pager);
		 request.setAttribute("houseList", list);
		 if(state.equals("0")){
			 if(h_isCheck.equals("0")){
				 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=0&state=0");
			 }
			 if(h_isCheck.equals("1")){
				 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=1&state=0");
			 }
		 }
		 if(state.equals("2")){
			 if(h_isCheck.equals("0")){
				 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=0&state=2");
			 }
		 }
		 if(state.equals("3")){
			 if(h_isCheck.equals("1")){
				 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=1&state=3");
			 }
		 }
		 request.getRequestDispatcher("backstage/houses/web_page/houseList.jsp?state="+state).forward(request, response);
	
	}
	
	
	//按发布人的类型查询房源信息
	public void queryForCharge(HttpServletRequest request, HttpServletResponse response,String state)
		throws ServletException, IOException {
		String h_ischarge=request.getParameter("h_ischarge");
		int h_ischarges=Integer.parseInt(h_ischarge);
		DoPage pager=new DoPage();
		String page=request.getParameter("page");
		pager.setCounts(houseService.queryAllHouses(h_ischarges).size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Houses> list=houseService.queryAllHouses(h_ischarges,pager);
		request.getSession(false).setAttribute("pages", pager);
		 request.setAttribute("houseList", list);
		 if(h_ischarge.equals("0")){
			 request.setAttribute("jspParam", "Houses?method=queryForCharge&h_ischarge=0");
		 }
		 if(h_ischarge.equals("1")){
			 request.setAttribute("jspParam", "Houses?method=queryForCharge&h_ischarge=1");
		 }
		 request.getRequestDispatcher("backstage/houses/web_page/houseList.jsp?state="+state).forward(request, response);
	}
	
	//依照Id查询房源信息
	public void queryHouseById(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("h_id");
		int h_id=Integer.parseInt(id);
		String skipTo=request.getParameter("skipTo");
		Houses  house=houseService.queryHouseById(h_id);	
		//查找图片
		String h_hi_ids=house.getH_hi_ids();
		String[] imgs=h_hi_ids.split(",");
		IHouse_ImgsService house_img=new House_ImgsServiceImpl();
		List<House_Imgs> imgList=new ArrayList<House_Imgs>();
		for (int i = 0; i < imgs.length; i++) {
				House_Imgs houseImg=house_img.queryHouse_ImgsById(Integer.valueOf(imgs[i]), null);
				imgList.add(houseImg);
		}
		house.getList().add(imgList.size());//将图片的个数存放在集合中，下标为4
		request.setAttribute("imgList", imgList);
		 request.setAttribute("house", house);
		 if(skipTo.equals("back")){
			 request.setAttribute("jspParam", "Houses?method=queryAll");
			 request.getRequestDispatcher("backstage/houses/web_page/houseInformation.jsp").forward(request, response);
		 }
		 if(skipTo.equals("front")){
				 String	typeName=request.getParameter("typeName");
				 if(typeName==null||typeName==""){
					 typeName="租房信息";
				 };
			
			 	ISystemsService systemService=new SystemsServiceImpl();
				List<Systems> list=systemService.queryAllSystems();
				request.setAttribute("systems", list.get(0));
				//查看房源配置
				String p=house.getHet_ids();
				String[]arr=p.split(",");
				List<House_Equip_Types> hetList=new ArrayList<House_Equip_Types>();
				for (int i = 0; i < arr.length; i++) {
					int het_id=Integer.parseInt(arr[i]);
					IHouse_Equip_TypesService hetService=new House_Equip_TypesServiceImpl();
					hetList.add(hetService.queryHouse_Equip_TypesById(het_id));
				}
			IOut_RentsService outRent=new Out_RentsServiceImpl();
			Out_Rents outRents=outRent.selOut_RentsByid(h_id, "1");
			Areas area=new AreasServiceImpl().queruAreasByid(outRents.getA_id(), "1");
			Small_Areas sa=new Small_AreasServiceImpl().querySmall_AreasById(outRents.getSa_id(), "1");
				//查询经纪人人关联的房源
			List<Houses> house_list=houseService.selectHouses(house.getH_ischarge(), house.getH_relevance_id(), "1");
			request.setAttribute("house_list", house_list);
			request.setAttribute("hetList", hetList);
			request.setAttribute("area", area);
			request.setAttribute("sa", sa);
			request.getRequestDispatcher("front/houses/web_page/HouseDetails.jsp?typeName="+typeName).forward(request, response);
		 }
	}
	//删除单个房源
	public void delHouseById(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("h_id");
		int h_id=Integer.parseInt(id);
		houseService.deleteHouses(h_id);
		ServletContext application=this.getServletContext();
		//查询未审核的房源
		List<Houses> houseList=houseService.queryAllHouses("0");
		application.setAttribute("Overhouse", houseList.size());
		application.setAttribute("OverhouseAll", (Integer)application.getAttribute("OverhouseAll")-1);
		queryAll(request,response,"1");
	}
	//批量删除
	public void datchDelHouse(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String [] ids=request.getParameterValues("h_id");
		boolean flag=true;
		for (int i = 0; i < ids.length; i++) {
			int h_id=Integer.parseInt(ids[i]);
			if(houseService.deleteHouses(h_id)<=1){
				flag=false;
			}
		}
		ServletContext application=this.getServletContext();
		//查询未审核的房源
		List<Houses> houseList=houseService.queryAllHouses("0");
		//查询所有房源
		List<Houses> houseAllList=houseService.queryAllHouses("null");
		application.setAttribute("Overhouse", houseList.size());
		application.setAttribute("OverhouseAll", houseAllList.size());
			queryAll(request,response,"1");
	}
	
	//审核
	public void checkById(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String h_id=request.getParameter("h_id");
		int id= Integer.parseInt(h_id);
		houseService.updateHousesCheck("1",id);
		ServletContext application=this.getServletContext();
		application.setAttribute("Overhouse", (Integer)application.getAttribute("Overhouse")-1);
		DoPage pager=new DoPage();
		String page=request.getParameter("page");
		pager.setCounts(houseService.queryAllHouses("0").size());
		try{
			pager.setCurrentPage(Integer.parseInt(page));
		}catch(Exception e){
			pager.setCurrentPage(1);
		}
		List<Houses> list=houseService.queryAllHouses("0",pager);
		request.getSession(false).setAttribute("pages", pager);
		 request.setAttribute("houseList", list);
		 request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=0&state=2");
		 request.getRequestDispatcher("backstage/houses/web_page/houseList.jsp?state=2").forward(request, response);
	}
	//置顶
	public void Isup(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("h_id");
		String isup=request.getParameter("isup");
		String page=request.getParameter("page");
		IHousesService houseService=new HousesServiceImpl();
		Houses house=houseService.queryHouseById(Integer.parseInt(id));
		house.setH_isup(Integer.parseInt(isup));
		house.setH_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		houseService.updateHouses(house);
		request.setAttribute("jspParam", "Houses?method=queryForCheck&h_isCheck=1&state=3");
		request.getRequestDispatcher("Houses?method=queryForCheck&h_isCheck=1&state=3&page="+page).forward(request, response);
	}
	//添加
	public void Add(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String h_ischarge=request.getParameter("h_ischarge");
		String h_number=request.getParameter("h_number");
		String rt_id=request.getParameter("rt_id");
		String h_proportion=request.getParameter("h_proportion");
		String h_floor=request.getParameter("h_floor");
		String h_all_floor=request.getParameter("h_all_floor");
		String h_price=request.getParameter("h_price");
		String ht_id=request.getParameter("ht_id");
		String sa_id=request.getParameter("sa_id");
		String pt_id=request.getParameter("pt_id");
		String h_xpoint=request.getParameter("h_xpoint");
		String h_ypoint=request.getParameter("h_ypoint");
		String h_title=request.getParameter("h_title");
		String h_tag=request.getParameter("h_tag");
		String[] het_ids=request.getParameterValues("het_ids");
		String infos=request.getParameter("infos");
		String[] path=request.getParameterValues("path");
		String ids="";
		for(int i=0;i<het_ids.length;i++){
			ids+=het_ids[i]+",";
		}
		Houses house=new Houses();
		house.setH_number(h_number);
		house.setRt_id(Integer.parseInt(rt_id));
		house.setH_proportion(h_proportion);
		house.setH_floor(h_floor);
		house.setH_all_floor(h_all_floor);
		house.setH_price(h_price);
		house.setHt_id(Integer.parseInt(ht_id));
		house.setPt_id(Integer.parseInt(pt_id));
		house.setH_xpoint(h_xpoint);
		house.setH_ypoint(h_ypoint);
		house.setH_title(h_title);
		house.setH_tag(h_tag);
		house.setH_infos(infos);
		house.setHet_ids(ids.substring(0,ids.length()-1));
		house.setH_ischarge(Integer.parseInt(h_ischarge));
		house.setH_isrent("0");
		house.setH_ischeck("0");
		house.setH_publictime((String)new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); 
		if(h_ischarge.equals("1")){
			house.setH_relevance_id(((Brokers)request.getSession(false).getAttribute("broker")).getB_id());
		}
		IHouse_ImgsService hiService=new House_ImgsServiceImpl();
		House_Imgs hi=null;
		List<House_Imgs> list=new ArrayList<House_Imgs>();
		if(path!=null){
			for(int i=0;i<path.length;i++){
				hi=new House_Imgs();
				hi.setHi_url(path[i]);
				hi.setHi_ischeck("0");
				list.add(hi);
			}
			String str="";
			for (int i = 0; i < list.size(); i++) {
				long id=hiService.insertHouse_Imgs(list.get(i));
				str+=String.valueOf(id)+",";
			}
			house.setH_hi_ids(str.substring(0, str.length()-1));
		}
		IHousesService houseService=new  HousesServiceImpl();
		Long id=houseService.insertHouses(house);
		
		Out_Rents or=new Out_Rents();
		or.setH_id(id.intValue());
		or.setRt_id(Integer.parseInt(rt_id));
		or.setSa_id(Integer.parseInt(sa_id));
		or.setOr_ischeck("1");
		ISmall_AreasService saService=new Small_AreasServiceImpl();
		Small_Areas sa=saService.querySmall_AreasById(Integer.parseInt(sa_id), "1");
		or.setA_id(sa.getA_id());
		IOut_RentsService orService=new Out_RentsServiceImpl();
		orService.insertOut_Rents(or);
		//查询未审核的房源
		List<Houses> houseList=houseService.queryAllHouses("0");
		//查询所有房源
		List<Houses> houseAllList=houseService.queryAllHouses("null");
		ServletContext application=this.getServletContext();
		application.setAttribute("Overhouse", houseList.size());
		application.setAttribute("OverhouseAll", houseAllList.size());
		response.sendRedirect("brokerFrame/frame.jsp");
	}
	//个人发布的房源的页面提交
	public void insertPersonHouse(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try{
		//个人资料
		String pName=request.getParameter("p_name");
		String phone=request.getParameter("p_tel");
		//房源信息
		String hName=request.getParameter("h_name");
		String hmonry=request.getParameter("h_monry");
		String size=request.getParameter("h_size");
		String floor=request.getParameter("h_floor");
		String Allfloor=request.getParameter("h_all_floor");
		String infos=request.getParameter("h_information");
		int isp=0;
		int pid=0;
		String imgArr="1,";
		String title=request.getParameter("h_info");
		String tag="出租";
		String ischeck="0";
		String x="104.07223";
		String y="30.663469";
		String isRent="0";
		String [] hetid=request.getParameterValues("deploy");
		String hets="";//配置
		for (String s : hetid) {
			hets+=s+",";
		}
		int h_isup=0;
		
		String py=request.getParameter("py");
		String ht=request.getParameter("ht");
		String rt=request.getParameter("rt_type");
		Date da=new Date();
		String dates=da.getMonth()+"-"+da.getDate()+" "+da.getHours()+":"+da.getMinutes()+":"+da.getSeconds();
		Houses house=new Houses("10000", dates, hName, hmonry, size, floor, Allfloor, infos, isp, pid, imgArr, title, tag, ischeck, x, y, isRent, hets, h_isup, dates,Integer.parseInt(py), Integer.parseInt(ht),Integer.parseInt(rt));
		int hid=houseService.addHouses(house);//先添加房源信息并返回新的id
		Personals pson=new Personals(pName, phone, "1", hid);
		IPersonalsService personService=new PersonalsServiceImpl();//添加个人消息，将房源id做关联，并返回新的个人表中的id号
		int p_id=personService.addPersonals(pson);
		houseService.updateHouses(hid, p_id);//利用个人的id改变房源中的相关联的的发布人的id
		Out_Rents or=new Out_Rents();
		or.setA_id(Integer.parseInt(request.getParameter("area")));
		or.setSa_id(Integer.parseInt(request.getParameter("smallArea")));
		or.setH_id(hid);
		or.setOr_ischeck("1");
		or.setRt_id(Integer.parseInt(rt));
		addOutRent(or);
		
		request.getRequestDispatcher("Houses?method=queryHouseById&skipTo=front&h_id="+hid).forward(request, response);
		
		}catch(Exception e){}
	}
	//将出租表和房源相关联
	public boolean addOutRent(Out_Rents or){
		IOut_RentsService ors=new Out_RentsServiceImpl();
		return ors.insertOut_Rents(or);		
	}
	//查询经纪人的房源
	public void queryHouseBybid(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url=request.getParameter("url");
		Brokers broker=(Brokers) request.getSession(false).getAttribute("broker");
		IHousesService houseService=new HousesServiceImpl();
		List<Houses> hList=houseService.queryHouseBybid(broker.getB_id(), "1");
		DoPage page=new DoPage();
		page.setCounts(hList.size());
		page.setPageSize(10);
		try{
			page.setCurrentPage(Integer.parseInt(request.getParameter("page")));
		}catch (Exception e) {
			page.setCurrentPage(1);
		}
		hList=houseService.queryHouseBybid(broker.getB_id(), "1",page);
		IHouse_ImgsService hiService=new House_ImgsServiceImpl();
		String hi_id=null;
		for(int i=0;i<hList.size();i++){
			Houses h=hList.get(i);
			hi_id=h.getH_hi_ids();
			House_Imgs hi=hiService.queryHouse_ImgsById(Integer.parseInt(hi_id.substring(0, 1)), "1");
			h.getList().add(hi.getHi_url());
		}
		request.setAttribute("hList", hList);
		request.getSession(false).setAttribute("pages", page);
		request.getSession(false).setAttribute("jspparam","Houses?method=queryHouseBybid&url="+url);
		request.getRequestDispatcher("brokerFrame/web_page/"+url+".jsp").forward(request, response);
	}
	//删除单个房源
	public void delHouseByhId(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String id=request.getParameter("id");
		int h_id=Integer.parseInt(id);
		PrintWriter out=response.getWriter();
		if(houseService.deleteHouses(h_id)>0){
			ServletContext application=this.getServletContext();
			//查询未审核的房源
			List<Houses> houseList=houseService.queryAllHouses("0");
			application.setAttribute("Overhouse", houseList.size());
			application.setAttribute("OverhouseAll", (Integer)application.getAttribute("OverhouseAll")-1);
			out.print("删除成功");
		}else
			out.print("删除失败");
	}
}
