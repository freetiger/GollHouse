package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IPowersDao;
import cn.goll.dao.impl.PowersDaoImpl;
import cn.goll.entity.Powers;
import cn.goll.service.IPowersService;

/**
 * IPowersService 持久层实现类
 * @author LYC
 *
 */
public class PowersServiceImpl implements IPowersService {
	IPowersDao dao=new PowersDaoImpl();
	public int deletePowers(int hId) {
		return dao.deletePowers(hId);
	}

	public boolean insertPowers(Powers powers) {
		return dao.insertPowers(powers);
	}

	public List<Powers> queryAllPowers() {
		return dao.queryAllPowers();
	}

	public Powers queryPowersById(int hId) {
		return dao.queryPowersById(hId);
	}

	public int updatePowers(Powers powers) {
		return dao.updatePowers(powers);
	}

	public List<Powers> queryAllPowers(DoPage doPage) {
		return dao.queryAllPowers(doPage);
	}

}
