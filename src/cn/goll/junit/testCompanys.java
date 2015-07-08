package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Companys;
import cn.goll.service.ICompanysService;
import cn.goll.service.impl.CompanysServiceImpl;
import junit.framework.TestCase;

public class testCompanys extends TestCase {
	public void testinsert() throws Exception {
		ICompanysService cservice = new CompanysServiceImpl();
		Companys companys = new Companys("高人房产有限公司", "2013-10", "锦江区大慈寺路北顺城街38号 ", "b.png", "1", "该公司不是一般的有钱");
		Companys companys2 = new Companys("飞翔房产有限公司", "2013-10", "青羊区灯笼街38号", "c.png", "0", "该公司一般一般");
		for (int i = 0; i < 100; i++) {
			if(cservice.insertCompanys(companys))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(cservice.insertCompanys(companys2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		ICompanysService cservice = new CompanysServiceImpl();
		if(cservice.deleteCompanys(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		ICompanysService cservice = new CompanysServiceImpl();
		Companys companys = new Companys("公司名2", "成立年份2", "公司地址2", "公司图片2", "0", "公司介绍2");
		companys.setC_id(1);
		if(cservice.updateCompanys(companys) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		ICompanysService cservice = new CompanysServiceImpl();
		List<Companys> companys = cservice.queryAllCompanys(null);
		for (Companys company : companys) {
			System.out.println(company.getC_id()+" "+company.getC_name()+" "+company.getC_complete_year()+
					" "+company.getC_address()+" "+company.getC_img()+" "+company.getC_ischeck()+" "+company.getC_infos());
		}
	}
}
