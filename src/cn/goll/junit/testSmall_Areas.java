package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Small_Areas;
import cn.goll.service.ISmall_AreasService;
import cn.goll.service.impl.Small_AreasServiceImpl;
import junit.framework.TestCase;

public class testSmall_Areas extends TestCase {
	public void testinsert() throws Exception {
		ISmall_AreasService saservice = new Small_AreasServiceImpl();
		Small_Areas small_Areas = new Small_Areas("八宝小区", "八宝街", "豪华装修",
				"xx物业有限公司", "2010-1-15", "xx开发有限公司", "150", 
				"104.07223", "30.663469", "1", "1,2,3,4", 1);
		Small_Areas small_Areas2 = new Small_Areas("万和小区", "万和路", "精装",
				"xx物业有限公司", "2011-11-15", "xx开发有限公司", "230", 
				"104.07223", "30.663469", "0", "1,2,3,4", 1);
		for (int i = 0; i < 100; i++) {
			if(saservice.insertSmall_Areas(small_Areas))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(saservice.insertSmall_Areas(small_Areas2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		ISmall_AreasService saservice = new Small_AreasServiceImpl();
		if(saservice.deleteSmall_Areas(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		ISmall_AreasService saservice = new Small_AreasServiceImpl();
		Small_Areas small_Areas = new Small_Areas("小区名2", "小区地址2", "小区装修类型2",
				"小区物业公司2", "小区竣工时间2", "小区开发商2", "小区物业费2", 
				"小区地图X坐标2", "小区地图Y坐标2", "1", "小区图片集2", 1);
		small_Areas.setSa_id(1);
		if(saservice.updateSmall_Areas(small_Areas) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		ISmall_AreasService saservice = new Small_AreasServiceImpl();
		List<Small_Areas> Small_Areas = saservice.querySmall_Areas(null);
		for (Small_Areas smallArea : Small_Areas) {
			System.out.println(smallArea.getSa_id()+" "+smallArea.getSa_name()+" "+smallArea.getSa_address()
					+" "+smallArea.getSa_fishing_type()+" "+smallArea.getSa_real_company()+" "+smallArea.getSa_complete_time()
					+" "+smallArea.getSa_develops()+" "+smallArea.getSa_real_money()+" "+smallArea.getSa_xpoint()
					+" "+smallArea.getSa_ypoint()+" "+smallArea.getSa_ischeck()+" "+smallArea.getSai_ids()
					+" "+smallArea.getA_id());
		}
	}
	
}
