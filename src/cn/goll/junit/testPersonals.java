package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Personals;
import cn.goll.service.IPersonalsService;
import cn.goll.service.impl.PersonalsServiceImpl;
import junit.framework.TestCase;

public class testPersonals extends TestCase {
	public void testinsert() throws Exception {
		IPersonalsService pservice = new PersonalsServiceImpl();
		Personals personals = new Personals("张三", "13655498165", "1", 1);
		Personals personals2 = new Personals("李四", "15311188636", "0", 1);
		for (int i = 0; i < 100; i++) {
			if(pservice.insertPersonals(personals))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(pservice.insertPersonals(personals2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		IPersonalsService pservice = new PersonalsServiceImpl();
		if(pservice.deletePersonals(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IPersonalsService pservice = new PersonalsServiceImpl();
		Personals personals = new Personals("个人名字2", "个人电话2", "1", 1);
		personals.setPer_id(1);
		if(pservice.updatePersonals(personals) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IPersonalsService pservice = new PersonalsServiceImpl();
		List<Personals> Personals = pservice.queryAllPersonals(null);
		for (Personals personal : Personals) {
			System.out.println(personal.getPer_id()+" "+personal.getPer_name()+" "+personal.getPer_tel()+" "+personal.getPer_ischeck()+" "+personal.getH_id());
		}
	}
	
}
