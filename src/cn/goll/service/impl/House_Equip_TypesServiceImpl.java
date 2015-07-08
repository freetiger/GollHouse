package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IHouse_Equip_TypesDao;
import cn.goll.dao.impl.House_Equip_TypesDaoImpl;
import cn.goll.entity.House_Equip_Types;
import cn.goll.service.IHouse_Equip_TypesService;

/**
 * IHouse_Equip_TypesService 持久层实现类
 * @author LYC
 *
 */
public class House_Equip_TypesServiceImpl implements IHouse_Equip_TypesService {
	IHouse_Equip_TypesDao dao=new House_Equip_TypesDaoImpl();
	public int deleteHouse_Equip_Types(int hId) {
		return dao.deleteHouse_Equip_Types(hId);
	}

	public boolean insertHouse_Equip_Types(House_Equip_Types het) {
		return dao.insertHouse_Equip_Types(het);
	}

	public List<House_Equip_Types> queryAllHouse_Equip_Types() {
		return dao.queryAllHouse_Equip_Types();
	}

	public House_Equip_Types queryHouse_Equip_TypesById(int hId) {
		return dao.queryHouse_Equip_TypesById(hId);
	}

	public int updateHouse_Equip_Types(House_Equip_Types het) {
		return dao.updateHouse_Equip_Types(het);
	}

	public int insertHouse_Equip_Types() {
		return dao.insertHouse_Equip_Types();
	}

}
