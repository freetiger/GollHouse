package cn.goll.junit;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import cn.goll.entity.Managers;
import cn.goll.service.IManagersService;
import cn.goll.service.impl.ManagersServiceImpl;
import junit.framework.TestCase;

public class testManagers extends TestCase {
	public void testinsert() throws Exception {
		IManagersService mservice = new ManagersServiceImpl();
		String strpwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf("test02"))+"test02"));
		Managers managers = new Managers("test02", strpwd, 1, "1",0);
		Managers managers2 = new Managers("test02", strpwd, 1, "0",0);
		for (int i = 0; i < 100; i++) {
			if(mservice.insertManagers(managers))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(mservice.insertManagers(managers2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		IManagersService mservice = new ManagersServiceImpl();
		if(mservice.deleteManagers(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IManagersService mservice = new ManagersServiceImpl();
		Managers managers = new Managers("用户名2", "密码2", 1,"1",0);
		managers.setId(1);
		if(mservice.updateManagers(managers) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IManagersService mservice = new ManagersServiceImpl();
		List<Managers> Managers = mservice.queryAllManagers("");
		for (Managers manager : Managers) {
			System.out.println(manager.getId()+" "+manager.getUname()+" "+manager.getPwd()+" "+manager.getP_id()+" "+manager.getIscheck());
		}
	}
	
}
