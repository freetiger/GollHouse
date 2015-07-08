package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Powers;
import cn.goll.service.IPowersService;
import cn.goll.service.impl.PowersServiceImpl;
import junit.framework.TestCase;

public class testPowers extends TestCase {
	public void testinsert() throws Exception {
		IPowersService pservice = new PowersServiceImpl();
		Powers powers = new Powers("普通管理员", "1,2,3,4");
		for (int i = 0; i < 100; i++) {
			if(pservice.insertPowers(powers))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IPowersService pservice = new PowersServiceImpl();
		if(pservice.deletePowers(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IPowersService pservice = new PowersServiceImpl();
		Powers powers = new Powers("权限名称2", "菜单集2");
		powers.setP_id(1);
		if(pservice.updatePowers(powers) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IPowersService pservice = new PowersServiceImpl();
		List<Powers> Powers = pservice.queryAllPowers();
		for (Powers power : Powers) {
			System.out.println(power.getP_id()+" "+power.getP_name()+" "+power.getP_menus());
		}
	}
	
}
