package cn.goll.junit;

import java.util.List;

import cn.goll.entity.House_Equip_Types;
import cn.goll.service.IHouse_Equip_TypesService;
import cn.goll.service.impl.House_Equip_TypesServiceImpl;
import junit.framework.TestCase;

public class testHouse_Equip_Types extends TestCase {
	public void testinsert() throws Exception {
		IHouse_Equip_TypesService hetservice = new House_Equip_TypesServiceImpl();
		House_Equip_Types het = new House_Equip_Types("配置名称");
		for (int i = 0; i < 100; i++) {
			if(hetservice.insertHouse_Equip_Types(het))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IHouse_Equip_TypesService hetservice = new House_Equip_TypesServiceImpl();
		if(hetservice.deleteHouse_Equip_Types(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHouse_Equip_TypesService hetservice = new House_Equip_TypesServiceImpl();
		House_Equip_Types het = new House_Equip_Types("配置名称2");
		het.setHet_id(1);
		if(hetservice.updateHouse_Equip_Types(het) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHouse_Equip_TypesService hetservice = new House_Equip_TypesServiceImpl();
		List<House_Equip_Types> house_Equip_Types = hetservice.queryAllHouse_Equip_Types();
		for (House_Equip_Types houseEquipType : house_Equip_Types) {
			System.out.println(houseEquipType.getHet_id()+" "+houseEquipType.getHet_name());
		}
	}
	
}
