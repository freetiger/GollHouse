package cn.goll.listener;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.goll.entity.Brokers;
import cn.goll.entity.Companys;
import cn.goll.entity.Houses;
import cn.goll.entity.Managers;
import cn.goll.entity.Out_Rents;
import cn.goll.entity.Seek_Rents;
import cn.goll.entity.Systems;
import cn.goll.service.IBrokersService;
import cn.goll.service.ICompanysService;
import cn.goll.service.IHousesService;
import cn.goll.service.IManagersService;
import cn.goll.service.IOut_RentsService;
import cn.goll.service.ISeek_RentsService;
import cn.goll.service.ISystemsService;
import cn.goll.service.impl.BrokersServiceImpl;
import cn.goll.service.impl.CompanysServiceImpl;
import cn.goll.service.impl.HousesServiceImpl;
import cn.goll.service.impl.ManagersServiceImpl;
import cn.goll.service.impl.Out_RentsServiceImpl;
import cn.goll.service.impl.Seek_RentsServiceImpl;
import cn.goll.service.impl.SystemsServiceImpl;
public class listener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		application.setAttribute("online", 0);
		
		ISystemsService service=new SystemsServiceImpl();
		Systems s=service.queryAllSystems().get(0);
		application.setAttribute("Oversystems", s);
		IHousesService houseService=new HousesServiceImpl();
		//查询未审核的房源
		List<Houses> houseList=houseService.queryAllHouses("0");
		//查询所有房源
		List<Houses> houseAllList=houseService.queryAllHouses("null");
		application.setAttribute("Overhouse", houseList.size());
		application.setAttribute("OverhouseAll", houseAllList.size());
		IBrokersService brokerService=new BrokersServiceImpl();
		//查询未审核的经纪人
		List<Brokers> brokerList=brokerService.queryAllBrokers("0");
		//查询所有经纪人
		List<Brokers> brokerAllList=brokerService.queryAllBrokers("null");
		application.setAttribute("Overbroker", brokerList.size());
		application.setAttribute("OverbrokerAll", brokerAllList.size());
		ICompanysService companysService=new CompanysServiceImpl();
		//查询未审核公司
		List<Companys> companysList=companysService.queryAllCompanys("0");
		//查询所有公司
		List<Companys> companysAllList=companysService.queryAllCompanys(null);
		application.setAttribute("Overcompanys", companysList.size());
		application.setAttribute("OvercompanysAll", companysAllList.size());
		ISeek_RentsService srService=new Seek_RentsServiceImpl();
		//查询未审核的求租
		List<Seek_Rents> srList=srService.queryAllSeek_Rents("0");
		//查询所有的求租 
		List<Seek_Rents> srAllList=srService.queryAllSeek_Rents(null);
		application.setAttribute("OverSr", srList.size());
		application.setAttribute("OverSrAll", srAllList.size());
		IManagersService managerService=new ManagersServiceImpl();
		List<Managers> managerList= managerService.queryAllManagers("0");
		application.setAttribute("OverManager", managerList.size());
		//初始化设置所以人员的状态为不在线
		brokerService.setBrokersIsonline();
		managerService.setManagerIsonline();
		
	}
}
