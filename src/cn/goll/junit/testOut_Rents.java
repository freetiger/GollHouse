package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Out_Rents;
import cn.goll.service.IOut_RentsService;
import cn.goll.service.impl.Out_RentsServiceImpl;
import junit.framework.TestCase;

public class testOut_Rents extends TestCase {
	public void testinsert() throws Exception {
		IOut_RentsService orservice = new Out_RentsServiceImpl();
		Out_Rents out_Rents = new Out_Rents("1", 1, 1, 1,1);
		Out_Rents out_Rents2 = new Out_Rents("0", 1, 1, 1,1);
		for (int i = 0; i < 100; i++) {
			if(orservice.insertOut_Rents(out_Rents))
				System.out.println("成功");
			else
				System.out.println("失败");
			if(orservice.insertOut_Rents(out_Rents2))
				System.out.println("成功2");
			else
				System.out.println("失败2");
		}
	}
	
	public void testdelete() throws Exception {
		IOut_RentsService orservice = new Out_RentsServiceImpl();
		if(orservice.deleteOut_Rents(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IOut_RentsService orservice = new Out_RentsServiceImpl();
		Out_Rents out_Rents = new Out_Rents("1", 1, 1, 1,1);
		out_Rents.setOr_id(1);
		if(orservice.updateOut_Rents(out_Rents) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IOut_RentsService orservice = new Out_RentsServiceImpl();
		List<Out_Rents> out_Rents = orservice.queryAllOut_Rents(null);
		for (Out_Rents outRent : out_Rents) {
			System.out.println(outRent.getOr_id()+" "+outRent.getOr_ischeck()+" "+outRent.getRt_id()+" "+outRent.getH_id()+" "+outRent.getSa_id()+" "+outRent.getA_id());
		}
	}
	
}
