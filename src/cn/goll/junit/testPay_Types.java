package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Pay_Types;
import cn.goll.service.IPay_TypesService;
import cn.goll.service.impl.Pay_TypesServiceImpl;
import junit.framework.TestCase;

public class testPay_Types extends TestCase {
	public void testinsert() throws Exception {
		IPay_TypesService ptservice = new Pay_TypesServiceImpl();
		Pay_Types pay_Types = new Pay_Types("刷卡");
		for (int i = 0; i < 100; i++) {
			if(ptservice.insertPay_Types(pay_Types))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IPay_TypesService ptservice = new Pay_TypesServiceImpl();
		if(ptservice.deletePay_Types(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IPay_TypesService ptservice = new Pay_TypesServiceImpl();
		Pay_Types pay_Types = new Pay_Types("付款方式名称");
		pay_Types.setPt_id(1);
		if(ptservice.updatePay_Types(pay_Types) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IPay_TypesService ptservice = new Pay_TypesServiceImpl();
		List<Pay_Types> Pay_Types = ptservice.queryAllPay_Types();
		for (Pay_Types payType : Pay_Types) {
			System.out.println(payType.getPt_id()+" "+payType.getPt_name());
		}
	}
	
}
