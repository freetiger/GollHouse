package cn.goll.junit;

import java.util.List;

import cn.goll.entity.Historys;
import cn.goll.service.IHistorysService;
import cn.goll.service.impl.HistorysServiceImpl;
import junit.framework.TestCase;

public class testHistorys extends TestCase {
	public void testinsert() throws Exception {
		IHistorysService hservice = new HistorysServiceImpl();
		Historys historys = new Historys(1, 1, "c君", "查询", "用户", "2013-12-02 15:12:12");
		for (int i = 0; i < 100; i++) {
			if(hservice.insertHistorys(historys))
				System.out.println("成功");
			else
				System.out.println("失败");
		}
	}
	
	public void testdelete() throws Exception {
		IHistorysService hservice = new HistorysServiceImpl();
		if(hservice.deleteHistorys(1) > 0)
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testupdate() throws Exception {
		IHistorysService hservice = new HistorysServiceImpl();
		Historys historys = new Historys(2, 1, "操作员2", "操作动作2", "操作对象或事件2", "操作时间2");
		historys.setHis_id(1);
		if(hservice.insertHistorys(historys))
			System.out.println("成功");
		else
			System.out.println("失败");
	}
	
	public void testquery() throws Exception {
		IHistorysService hservice = new HistorysServiceImpl();
		List<Historys> historys = hservice.queryAllHistorys();
		for (Historys history : historys) {
			System.out.println(history.getHis_id()+" "+history.getHis_b_id()+" "+history.getHis_manager_id()+" "+history.getHis_do_name()
					+" "+history.getHis_do_actions()+" "+history.getHis_do_event()+" "+history.getHis_date());
		}
	}
	
}
