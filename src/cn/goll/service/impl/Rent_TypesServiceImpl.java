package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IRent_TypesDao;
import cn.goll.dao.impl.Rent_TypesDaoImpl;
import cn.goll.entity.Rent_Types;
import cn.goll.service.IRent_TypesService;

/**
 * IRent_TypesService 持久层实现类
 * @author LYC
 *
 */
public class Rent_TypesServiceImpl implements IRent_TypesService {
	IRent_TypesDao dao=new Rent_TypesDaoImpl();
	public int deleteRent_Types(int hId) {
		return dao.deleteRent_Types(hId);
	}

	public boolean insertRent_Types(Rent_Types rt) {
		return dao.insertRent_Types(rt);
	}

	public List<Rent_Types> queryAllRent_Types() {
		return dao.queryAllRent_Types();
	}

	public Rent_Types queryRent_TypesById(int hId) {
		return dao.queryRent_TypesById(hId);
	}

	public int updateRent_Types(Rent_Types rt) {
		return dao.updateRent_Types(rt);
	}

	public int insertRent_Types() {
		return dao.insertRent_Types();
	}

}
