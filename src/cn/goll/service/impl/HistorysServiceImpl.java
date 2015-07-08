package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IHistorysDao;
import cn.goll.dao.impl.HistorysDaoImpl;
import cn.goll.entity.Historys;
import cn.goll.service.IHistorysService;

/**
 * IHistorysService 持久层实现类
 * @author LYC
 *
 */
public class HistorysServiceImpl implements IHistorysService {
	IHistorysDao dao=new HistorysDaoImpl();
	public int deleteHistorys(int hId) {
		return dao.deleteHistorys(hId);
	}

	public boolean insertHistorys(Historys history) {
		return dao.insertHistorys(history);
	}

	public List<Historys> queryAllHistorys() {
		return dao.queryAllHistorys();
	}

	public Historys queryHistorysById(int hId) {
		return dao.queryHistorysById(hId);
	}

	public int updateHistorys(Historys history) {
		return dao.updateHistorys(history);
	}

	public List<Historys> queryAllHistorys(DoPage doPage) {
		return dao.queryAllHistorys(doPage);
	}

}
