package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.ISystemsDao;
import cn.goll.dao.impl.SystemsDaoImpl;
import cn.goll.entity.Systems;
import cn.goll.service.ISystemsService;

/**
 * ISystemsService 持久层实现类
 * @author LYC
 *
 */
public class SystemsServiceImpl implements ISystemsService {
	ISystemsDao dao=new SystemsDaoImpl();
	public int deleteSystems(int hId) {
		return dao.deleteSystems(hId);
	}

	public boolean insertSystems(Systems systems) {
		return dao.insertSystems(systems);
	}

	public List<Systems> queryAllSystems() {
		return dao.queryAllSystems();
	}

	public Systems querySystemsById(int hId) {
		return dao.querySystemsById(hId);
	}

	public int updateSystems(Systems systems) {
		return dao.updateSystems(systems);
	}

}
