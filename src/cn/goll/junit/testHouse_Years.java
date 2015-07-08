package cn.goll.junit;

import java.util.List;

import cn.goll.entity.House_Years;
import cn.goll.service.IHouse_YearsService;
import cn.goll.service.impl.House_YearsServiceImpl;
import junit.framework.TestCase;

public class testHouse_Years extends TestCase {
	public void testinsert() throws Exception {
		IHouse_YearsService hyservice = new House_YearsServiceImpl();
		House_Years house_Years = new House_Years("2013-12-15");
		for (int i = 0; i < 100; i++) {
			if(hyservice.insertHouse_Years(house_Years))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IHouse_YearsService hyservice = new House_YearsServiceImpl();
		if(hyservice.deleteHouse_Years(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHouse_YearsService hyservice = new House_YearsServiceImpl();
		House_Years house_Years = new House_Years("年份名称");
		house_Years.setHy_id(1);
		if(hyservice.updateHouse_Years(house_Years) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHouse_YearsService hyservice = new House_YearsServiceImpl();
		List<House_Years> house_Years = hyservice.queryAllHouse_Years();
		for (House_Years houseYear : house_Years) {
			System.out.println(houseYear.getHy_id()+" "+houseYear.getHy_years());
		}
	}
	
}
