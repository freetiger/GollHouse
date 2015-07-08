package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Small_Area_Imgs;
import cn.goll.service.ISmall_Area_ImgsService;
import cn.goll.service.impl.Small_Area_ImgsServiceImpl;
import junit.framework.TestCase;

public class testSmall_Area_Imgs extends TestCase {
	public void testinsert() throws Exception {
		ISmall_Area_ImgsService saiservice = new Small_Area_ImgsServiceImpl();
		Small_Area_Imgs small_Area_Imgs = new Small_Area_Imgs("14.jpg", "1");
		Small_Area_Imgs small_Area_Imgs2 = new Small_Area_Imgs("15.jpg", "0");
		for (int i = 0; i < 100; i++) {
			if(saiservice.insertSmall_Area_Imgs(small_Area_Imgs))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(saiservice.insertSmall_Area_Imgs(small_Area_Imgs2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		ISmall_Area_ImgsService saiservice = new Small_Area_ImgsServiceImpl();
		if(saiservice.deleteSmall_Area_Imgs(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		ISmall_Area_ImgsService saiservice = new Small_Area_ImgsServiceImpl();
		Small_Area_Imgs small_Area_Imgs = new Small_Area_Imgs("小区图片路径2", "1");
		small_Area_Imgs.setSai_id(1);
		if(saiservice.updateSmall_Area_Imgs(small_Area_Imgs) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		ISmall_Area_ImgsService saiservice = new Small_Area_ImgsServiceImpl();
		List<Small_Area_Imgs> Small_Area_Imgs = saiservice.queryAllSmall_Area_Imgs(null);
		for (Small_Area_Imgs smallAreaImg : Small_Area_Imgs) {
			System.out.println(smallAreaImg.getSai_id()+" "+smallAreaImg.getSai_url()+" "+smallAreaImg.getSai_ischeck());
		}
	}
	
}
