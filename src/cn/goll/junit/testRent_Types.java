package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Rent_Types;
import cn.goll.service.IRent_TypesService;
import cn.goll.service.impl.Rent_TypesServiceImpl;
import junit.framework.TestCase;

public class testRent_Types extends TestCase {
	public void testinsert() throws Exception {
		IRent_TypesService rtservice = new Rent_TypesServiceImpl();
		Rent_Types rent_Types = new Rent_Types("合租");
		for (int i = 0; i < 100; i++) {
			if(rtservice.insertRent_Types(rent_Types))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IRent_TypesService rtservice = new Rent_TypesServiceImpl();
		if(rtservice.deleteRent_Types(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IRent_TypesService rtservice = new Rent_TypesServiceImpl();
		Rent_Types rent_Types = new Rent_Types("出租类型名称2");
		rent_Types.setRt_id(1);
		if(rtservice.updateRent_Types(rent_Types) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IRent_TypesService rtservice = new Rent_TypesServiceImpl();
		List<Rent_Types> Rent_Types = rtservice.queryAllRent_Types();
		for (Rent_Types rentType : Rent_Types) {
			System.out.println(rentType.getRt_id()+" "+rentType.getRt_name());
		}
	}
	
}
