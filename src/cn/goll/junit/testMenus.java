package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Menus;
import cn.goll.service.IMenusService;
import cn.goll.service.impl.MenusServiceImpl;
import junit.framework.TestCase;

public class testMenus extends TestCase {
	
	public void testinsert() throws Exception {
		IMenusService mservice = new MenusServiceImpl();
		Menus menus = new Menus("菜单名称", "菜单路径", 1, "1");
		Menus menus2 = new Menus("菜单名称", "菜单路径", 1, "0");
		for (int i = 0; i < 10; i++) {
			Long result = mservice.insertMenus(menus);
			System.out.println(result);
			Long result2 = mservice.insertMenus(menus2);
			System.out.println(result2+"---");
		}
	}
	
	public void testdelete() throws Exception {
		IMenusService mservice = new MenusServiceImpl();
		for (int i = 53; i < 72; i++) {
			if(mservice.deleteMenus(i) > 0)
				System.out.println("成功");
			else
				System.out.println("失败");
		}
		
	}
	
	public void testupdate() throws Exception {
		IMenusService mservice = new MenusServiceImpl();
		Menus menus = new Menus("菜单名称2", "菜单路径2", 1, "1");
		menus.setM_id(58);
		if(mservice.updateMenus(menus) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IMenusService mservice = new MenusServiceImpl();
		List<Menus> Menus = mservice.queryAllMenus("1");
		for (Menus menu : Menus) {
			System.out.println(menu.getM_id()+" "+menu.getM_name()+" "+menu.getM_url()+" "+menu.getF_id()+" "+menu.getM_isckeck());
		}
	}
	
	
}
