package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Houses;
import cn.goll.service.IHousesService;
import cn.goll.service.impl.HousesServiceImpl;
import junit.framework.TestCase;

public class testHouse extends TestCase {
	public void testinsert() throws Exception {
		IHousesService hservice = new HousesServiceImpl();
		Houses houses = new Houses("1002", "2013-2-13", "八宝房源", "750",
				"180", "5", "15", "靠山面水", 0, 1, "1,2,3",
				"goll房源", "出租", "1", "104.07223", "30.663469", "0", "1,2,3",0,"" ,1, 1, 1 );
		Houses houses2 = new Houses("1002", "2013-2-13", "万和路房源", "600",
				"150", "5", "15", "没介绍", 0, 1, "1,2,3",
				"goll房源", "出租", "0", "104.07223", "30.663469", "0", "1,2,3",0,"", 1, 1, 1 );
		for (int i = 0; i < 100; i++) {
			if(hservice.insertHouses(houses)>0)
				System.out.println("成功");
			else
				System.out.println("失败");
			if(hservice.insertHouses(houses2)>0)
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		IHousesService hservice = new HousesServiceImpl();
			if(hservice.deleteHouses(1) > 0)
				System.out.println("成功");
			else
				System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHousesService hservice = new HousesServiceImpl();
		Houses houses = new Houses("房源编号2", "发布日期2", "房源名2", "房源租金2",
				"房源面积2", "6", "11", "房源介绍2", 0, 1, "房源图片集2",
				"房源标题2", "房源标签2", "1", "房源x坐标2", "房源y坐标2", "是2", "房源配置2",0,"", 1, 1, 1 );
		houses.setH_id(1);
		if(hservice.updateHouses(houses) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHousesService hservice = new HousesServiceImpl();
		List<Houses> houses = hservice.queryAllHouses("");
		for (Houses house : houses) {
			System.out.println(house.getH_id()+" "+house.getH_number()+" "+house.getH_publictime()+" "+house.getH_name()
					+" "+house.getH_price()+" "+house.getH_proportion()+" "+house.getH_floor()+" "+house.getH_all_floor()
					+" "+house.getH_infos()+" "+house.getH_ischarge()+" "+house.getH_relevance_id()+" "+house.getH_hi_ids()
					+" "+house.getH_title()+" "+house.getH_tag()+" "+house.getH_ischeck()+" "+house.getH_xpoint()+" "+house.getH_ypoint()
					+" "+house.getH_isrent()+" "+house.getHet_ids()+" "+house.getPt_id()+" "+house.getHt_id()+" "+house.getRt_id());
		}
	}
	
}
