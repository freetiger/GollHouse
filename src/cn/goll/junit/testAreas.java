package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Areas;
import cn.goll.service.IAreasService;
import cn.goll.service.impl.AreasServiceImpl;
import junit.framework.TestCase;

public class testAreas extends TestCase {
	public void testinsert() throws Exception {
		IAreasService aservice = new AreasServiceImpl();
		Areas area = new Areas("温江区", "不知道", "1");
		Areas area2 = new Areas("温江区", "还是不知道", "0");
		for (int i = 0; i < 100; i++) {
			if(aservice.insertAreas(area)){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}		
		}
		for (int i = 0; i < 100; i++) {
			if(aservice.insertAreas(area2)){
				System.out.println("成功2");
			}else{
				System.out.println("失败2");
			}		
		}
	}
	
	public void testdelete() throws Exception {
		IAreasService aservice = new AreasServiceImpl();
		if(aservice.deleteAreas(5) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IAreasService aservice = new AreasServiceImpl();
		Areas area = new Areas();
		area.setA_infos("aa");
		area.setA_name("aaa");
		area.setA_ischeck("2");
		area.setA_id(6);
		if(aservice.updateAreas(area) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IAreasService aservice = new AreasServiceImpl();
		List<Areas> areas = aservice.queryAllAreas(null);
		for (Areas area : areas) {
			System.out.println(area.getA_id()+" "+area.getA_name()+" "+area.getA_infos()+" "+area.getA_ischeck());
		}
	}
	
}
