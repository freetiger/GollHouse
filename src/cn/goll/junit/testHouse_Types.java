package cn.goll.junit;

import java.util.List;

import cn.goll.entity.House_Types;
import cn.goll.service.IHouse_TypesService;
import cn.goll.service.impl.House_TypesServiceImpl;
import junit.framework.TestCase;

public class testHouse_Types extends TestCase {
	public void testinsert() throws Exception {
		IHouse_TypesService htservice = new House_TypesServiceImpl();
		House_Types house_Types = new House_Types("房型名称");
		for (int i = 0; i < 100; i++) {
			if(htservice.insertHouse_Types(house_Types))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IHouse_TypesService htservice = new House_TypesServiceImpl();
		if(htservice.deleteHouse_Types(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHouse_TypesService htservice = new House_TypesServiceImpl();
		House_Types house_Types = new House_Types("房型名称");
		house_Types.setHt_id(1);
		if(htservice.updateHouse_Types(house_Types) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHouse_TypesService htservice = new House_TypesServiceImpl();
		List<House_Types> house_Types = htservice.queryAllHouse_Types();
		for (House_Types houseType : house_Types) {
			System.out.println(houseType.getHt_id()+" "+houseType.getHt_name());
		}
	}
	
}
