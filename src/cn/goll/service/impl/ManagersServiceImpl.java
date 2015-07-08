package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IManagersDao;
import cn.goll.dao.impl.ManagersDaoImpl;
import cn.goll.entity.Managers;
import cn.goll.service.IManagersService;

/**
 * IManagersService 持久层实现类
 * @author LYC
 *
 */
public class ManagersServiceImpl implements IManagersService {
	IManagersDao dao=new ManagersDaoImpl();
	public int deleteManagers(int hId) {
		return dao.deleteManagers(hId);
	}

	public boolean insertManagers(Managers manager) {
		return dao.insertManagers(manager);
	}

	public List<Managers> queryAllManagers(String ischeck) {
		return dao.queryAllManagers(ischeck);
	}

	public Managers queryManagersById(int hId,String  ischeck) {
		return dao.queryManagersById(hId,ischeck);
	}

	public int updateManagers(Managers manager) {
		return dao.updateManagers(manager);
	}

	public Managers queryManagersByName(String uname, String ischeck) {
		return dao.queryManagersByName(uname, ischeck);
	}

	public List<Managers> queryAllManagers() {
		return dao.queryAllManagers();
	}

	public List<Managers> queryAllManagers(DoPage pager) {
		return dao.queryAllManagers(pager);
	}

	public List<Managers> queryAllManagers(String ischeck, DoPage pager) {
		return dao.queryAllManagers(ischeck, pager);
	}

	public int updateManagers(int id, String ischeck) {
		return dao.updateManagers(id, ischeck);
	}

	public int setManagerIsonline() {
		return dao.setManagerIsonline();
	}

}
