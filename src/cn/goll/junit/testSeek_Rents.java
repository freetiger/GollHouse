package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Seek_Rents;
import cn.goll.service.ISeek_RentsService;
import cn.goll.service.impl.Seek_RentsServiceImpl;
import junit.framework.TestCase;

public class testSeek_Rents extends TestCase {
	public void testinsert() throws Exception {
		ISeek_RentsService srservice = new Seek_RentsServiceImpl();
		Seek_Rents seek_Rents = new Seek_Rents("600-800", "13598495462", "1", 1,"600-800",1);
		Seek_Rents seek_Rents2 = new Seek_Rents("300-600", "求租电话", "0", 1,"300-600",1);
		for (int i = 0; i < 100; i++) {
			if(srservice.insertSeek_Rents(seek_Rents))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(srservice.insertSeek_Rents(seek_Rents2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		ISeek_RentsService srservice = new Seek_RentsServiceImpl();
		if(srservice.deleteSeek_Rents(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		ISeek_RentsService srservice = new Seek_RentsServiceImpl();
		Seek_Rents seek_Rents = new Seek_Rents("求租价格2", "求租电话2", "1", 1,"231",1);
		seek_Rents.setSr_id(1);
		if(srservice.updateSeek_Rents(seek_Rents) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		ISeek_RentsService srservice = new Seek_RentsServiceImpl();
		List<Seek_Rents> Seek_Rents = srservice.queryAllSeek_Rents(null);
		for (Seek_Rents seekRent : Seek_Rents) {
			System.out.println(seekRent.getSr_id()+" "+seekRent.getSr_price()+" "+seekRent.getSr_tel()+" "+seekRent.getSr_ischeck()+" "+seekRent.getA_id());
		}
	}
	
}
