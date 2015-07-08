package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Systems;
import cn.goll.service.ISystemsService;
import cn.goll.service.impl.SystemsServiceImpl;
import junit.framework.TestCase;

public class testSystems extends TestCase {
	public void testinsert() throws Exception {
		ISystemsService sservice = new SystemsServiceImpl();
		Systems systems = new Systems("Goll租房平台", "www.goll.cn", "500", "Goll,租房，出租房，求租房", "Goll",
				"此网站是用作于出租，求租房源的网站，此网站价格公道，童叟无欺，今天不看，终身遗憾", "15384968355", "2013—12-15", "838014177");
		for (int i = 0; i < 100; i++) {
			if(sservice.insertSystems(systems))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		ISystemsService sservice = new SystemsServiceImpl();
		if(sservice.deleteSystems(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		ISystemsService sservice = new SystemsServiceImpl();
		Systems systems = new Systems("系统名2", "系统域名2", "系统交易量2", "系统关键字2", "系统logo2",
				"系统介绍2", "网站联系电话2", "网站建成时间2", "网站联系QQ2");
		systems.setSys_id(1);
		if(sservice.updateSystems(systems) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		ISystemsService sservice = new SystemsServiceImpl();
		List<Systems> Systems = sservice.queryAllSystems();
		for (Systems system : Systems) {
			System.out.println(system.getSys_id()+" "+system.getSys_name()+" "+system.getSys_dns()
					+" "+system.getSys_counts()+" "+system.getSys_tag()+" "+system.getSys_logo()
					+" "+system.getSys_infos()+" "+system.getSys_tel()+" "+system.getSys_date()+" "+system.getSys_qq());
		}
	}
	
}
