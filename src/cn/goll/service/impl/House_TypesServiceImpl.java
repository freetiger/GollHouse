package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IHouse_TypesDao;
import cn.goll.dao.impl.House_TypesDaoImpl;
import cn.goll.entity.House_Types;
import cn.goll.service.IHouse_TypesService;

/**
 * IHouse_TypesService 持久层实现类
 * @author LYC
 *
 */
public class House_TypesServiceImpl implements IHouse_TypesService {
	IHouse_TypesDao dao=new House_TypesDaoImpl();
	public int deleteHouse_Types(int hId) {
		return dao.deleteHouse_Types(hId);
	}

	public boolean insertHouse_Types(House_Types ht) {
		return dao.insertHouse_Types(ht);
	}

	public List<House_Types> queryAllHouse_Types() {
		return dao.queryAllHouse_Types();
	}

	public House_Types queryHouse_TypesById(int hId) {
		return dao.queryHouse_TypesById(hId);
	}

	public int updateHouse_Types(House_Types ht) {
		return dao.updateHouse_Types(ht);
	}

	public int insertHouse_Types() {
		return dao.insertHouse_Types();
	}

}
