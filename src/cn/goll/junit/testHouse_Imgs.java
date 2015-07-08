package cn.goll.junit;

import java.util.List;

import cn.goll.entity.House_Imgs;
import cn.goll.service.IHouse_ImgsService;
import cn.goll.service.impl.House_ImgsServiceImpl;
import junit.framework.TestCase;

public class testHouse_Imgs extends TestCase {
	public void testinsert() throws Exception {
		IHouse_ImgsService hiservice = new House_ImgsServiceImpl();
		House_Imgs house_Imgs = new House_Imgs("8.jpg", "1");
		House_Imgs house_Imgs2 = new House_Imgs("9.jpg", "0");
		for (int i = 0; i < 100; i++) {
			if(hiservice.insertHouse_Imgs(house_Imgs)>0)
				System.out.println("成功");
			else
				System.out.println("失败");
			if(hiservice.insertHouse_Imgs(house_Imgs2)>0)
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		IHouse_ImgsService hiservice = new House_ImgsServiceImpl();
		if(hiservice.deleteHouse_Imgs(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHouse_ImgsService hiservice = new House_ImgsServiceImpl();
		House_Imgs house_Imgs = new House_Imgs("图片路径2", "0");
		house_Imgs.setHi_id(1);
		if(hiservice.updateHouse_Imgs(house_Imgs) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHouse_ImgsService hiservice = new House_ImgsServiceImpl();
		List<House_Imgs> house_Imgs = hiservice.queryAllHouse_Imgs(null);
		for (House_Imgs houseImg : house_Imgs) {
			System.out.println(houseImg.getHi_id()+" "+houseImg.getHi_url()+" "+houseImg.getHi_ischeck());
		}
	}
	
}
