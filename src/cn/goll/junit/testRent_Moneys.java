package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Rent_Moneys;
import cn.goll.service.IRent_MoneysService;
import cn.goll.service.impl.Rent_MoneysServiceImpl;
import junit.framework.TestCase;

public class testRent_Moneys extends TestCase {
	public void testinsert() throws Exception {
		IRent_MoneysService rmservice = new Rent_MoneysServiceImpl();
		Rent_Moneys rent_Moneys = new Rent_Moneys("2000+");
		for (int i = 0; i < 100; i++) {
			if(rmservice.insertRent_Moneys(rent_Moneys))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IRent_MoneysService rmservice = new Rent_MoneysServiceImpl();
		if(rmservice.deleteRent_Moneys(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IRent_MoneysService rmservice = new Rent_MoneysServiceImpl();
		Rent_Moneys rent_Moneys = new Rent_Moneys("租金数目");
		rent_Moneys.setRm_id(1);
		if(rmservice.updateRent_Moneys(rent_Moneys) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IRent_MoneysService rmservice = new Rent_MoneysServiceImpl();
		List<Rent_Moneys> Rent_Moneys = rmservice.queryAllRent_Moneys();
		for (Rent_Moneys rentMoney : Rent_Moneys) {
			System.out.println(rentMoney.getRm_id()+" "+rentMoney.getRm_count());
		}
	}
	
}
