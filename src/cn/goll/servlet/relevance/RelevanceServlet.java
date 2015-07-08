package cn.goll.servlet.relevance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.goll.entity.Areas;
import cn.goll.entity.House_Equip_Types;
import cn.goll.entity.House_Types;
import cn.goll.entity.House_Years;
import cn.goll.entity.Pay_Types;
import cn.goll.entity.Rent_Moneys;
import cn.goll.entity.Rent_Types;
import cn.goll.entity.Small_Areas;
import cn.goll.entity.Systems;
import cn.goll.service.IAreasService;
import cn.goll.service.IHouse_Equip_TypesService;
import cn.goll.service.IHouse_TypesService;
import cn.goll.service.IHouse_YearsService;
import cn.goll.service.IPay_TypesService;
import cn.goll.service.IRent_MoneysService;
import cn.goll.service.IRent_TypesService;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.ISystemsService;
import cn.goll.service.impl.AreasServiceImpl;
import cn.goll.service.impl.House_Equip_TypesServiceImpl;
import cn.goll.service.impl.House_TypesServiceImpl;
import cn.goll.service.impl.House_YearsServiceImpl;
import cn.goll.service.impl.Pay_TypesServiceImpl;
import cn.goll.service.impl.Rent_MoneysServiceImpl;
import cn.goll.service.impl.Rent_TypesServiceImpl;
import cn.goll.service.impl.Small_AreasServiceImpl;
import cn.goll.service.impl.SystemsServiceImpl;

public class RelevanceServlet extends HttpServlet{

	IPay_TypesService py=new Pay_TypesServiceImpl();//付款方式
	IHouse_YearsService hy=new House_YearsServiceImpl();//房源年限
	IHouse_TypesService ht=new House_TypesServiceImpl();//房源类型
	IRent_TypesService rt=new Rent_TypesServiceImpl();//出租方式
	IRent_MoneysService rm=new Rent_MoneysServiceImpl();//租金范围
	IHouse_Equip_TypesService het=new House_Equip_TypesServiceImpl();//房源配置
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String method=request.getParameter("method");
			if(method.equals("select"))selectAll(request,response);
			if(method.equals("del"))deleteById(request,response);
			if(method.equals("insert"))insertVolum(request,response);
			if(method.equals("update"))updateVolum(request,response);
			if(method.equals("selForFront")) selectForFront(request,response);
	}
	//查询
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<Pay_Types> py_list=py.queryAllPay_Types();
		List<House_Years> hy_list=hy.queryAllHouse_Years();
		List<House_Types> ht_list=ht.queryAllHouse_Types();
		List<Rent_Types> rt_list=rt.queryAllRent_Types();
		List<Rent_Moneys> rm_list=rm.queryAllRent_Moneys();
		List<House_Equip_Types> het_list=het.queryAllHouse_Equip_Types();
		
		request.setAttribute("pyList", py_list);
		request.setAttribute("hyList", hy_list);
		request.setAttribute("htList", ht_list);
		request.setAttribute("rtList", rt_list);
		request.setAttribute("rmList", rm_list);
		request.setAttribute("hetList", het_list);
		request.getRequestDispatcher("backstage/relevanceList/relevance.jsp").forward(request, response);
		
	}
	//删除
	public void deleteById(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String flag=request.getParameter("flag");
		String r_id=request.getParameter("id");
		int id=Integer.parseInt(r_id);
		int count=0;
		if(flag.equals("pt"))count=py.deletePay_Types(id);
		if(flag.equals("hy"))count=hy.deleteHouse_Years(id);
		if(flag.equals("rt"))count=rt.deleteRent_Types(id);
		if(flag.equals("ht"))count=ht.deleteHouse_Types(id);
		if(flag.equals("het"))count=het.deleteHouse_Equip_Types(id);
		if(flag.equals("rm"))count=rm.deleteRent_Moneys(id);
	
		PrintWriter pw=response.getWriter();
		pw.print(count);
		pw.flush();
		pw.close();
	}
	//添加数据
	public void insertVolum(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String flag=request.getParameter("flag").trim();
		String str=flag+",";
		if(flag.equals("pt")){
			int ids=py.insertPay_Types();
			str+=ids;
		}
		if(flag.equals("hy")){
			int ids=hy.insertHouse_Years();
			str+=ids;
		}
		if(flag.equals("rt")){
			int ids=rt.insertRent_Types();
			str+=ids;
		}
		if(flag.equals("ht")){
			int ids=ht.insertHouse_Types();
			str+=ids;
		}
		if(flag.equals("het")){
			int ids=het.insertHouse_Equip_Types();
			str+=ids;
		}
		if(flag.equals("rm")){
			int ids=rm.insertRent_Moneys();
			str+=ids;
		}
		PrintWriter pw=response.getWriter();
		pw.write(str);
		pw.flush();
		pw.close();
	}
//修改字段值
	public void updateVolum(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String flag=request.getParameter("flag").trim();
		String id=request.getParameter("id");
		String context=request.getParameter("text");
		int ids=Integer.parseInt(id);
		int count=0;
		if(flag.equals("pt")){
			Pay_Types pay=new Pay_Types();
			pay.setPt_id(ids);
			pay.setPt_name(context);
			count=py.updatePay_Types(pay);
		}
		if(flag.equals("hy")){
			House_Years house_year=new House_Years();
			house_year.setHy_id(ids);
			house_year.setHy_years(context);
			count=hy.updateHouse_Years(house_year);
		}
		if(flag.equals("rt")){
			Rent_Types Rtype=new Rent_Types();
			Rtype.setRt_id(ids);
			Rtype.setRt_name(context);
			count=rt.updateRent_Types(Rtype);
		}
		if(flag.equals("ht")){
			House_Types Htype=new House_Types();
			Htype.setHt_id(ids);
			Htype.setHt_name(context);
			count=ht.updateHouse_Types(Htype);
		}
		if(flag.equals("het")){
			House_Equip_Types HeT=new House_Equip_Types();
			HeT.setHet_id(ids);
			HeT.setHet_name(context);
			count=het.updateHouse_Equip_Types(HeT);
		}
		if(flag.equals("rm")){
			Rent_Moneys Rm=new Rent_Moneys();
			Rm.setRm_id(ids);
			Rm.setRm_count(context);
			count=rm.updateRent_Moneys(Rm);
		}	
		PrintWriter pw=response.getWriter();
		pw.print(count);
		pw.flush();
		pw.close();
	}
	//前端查询
	public void selectForFront(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String state=request.getParameter("state");
		
		ISystemsService systemService=new SystemsServiceImpl();
		List<Systems> list=systemService.queryAllSystems();
		request.setAttribute("systems", list.get(0));
		
		List<Pay_Types> py_list=py.queryAllPay_Types();
		List<House_Years> hy_list=hy.queryAllHouse_Years();
		List<House_Types> ht_list=ht.queryAllHouse_Types();
		List<Rent_Types> rt_list=rt.queryAllRent_Types();
		List<Rent_Moneys> rm_list=rm.queryAllRent_Moneys();
		List<House_Equip_Types> het_list=het.queryAllHouse_Equip_Types();
		
		IAreasService areaService=new AreasServiceImpl();
		ISmall_AreasService saService=new Small_AreasServiceImpl();
		List<Areas> alist=areaService.queryAllAreas("1");
		List<Small_Areas> salist=saService.querySmall_Areas("1");
		request.setAttribute("pyList", py_list);
		request.setAttribute("hyList", hy_list);
		request.setAttribute("htList", ht_list);
		request.setAttribute("rtList", rt_list);
		request.setAttribute("rmList", rm_list);
		request.setAttribute("hetList", het_list);
		request.setAttribute("alist", alist);
		request.setAttribute("salist", salist);
		if(state.equals("publish"))
			request.getRequestDispatcher("front/person/web_page/person_publish.jsp").forward(request, response);
	}
}
