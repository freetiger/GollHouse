package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IHouse_YearsDao;
import cn.goll.dao.impl.House_YearsDaoImpl;
import cn.goll.entity.House_Years;
import cn.goll.service.IHouse_YearsService;

/**
 * IHouse_YearsService 持久层实现类
 * @author LYC
 *
 */
public class House_YearsServiceImpl implements IHouse_YearsService {
	IHouse_YearsDao dao=new House_YearsDaoImpl();
	public int deleteHouse_Years(int hId) {
		return dao.deleteHouse_Years(hId);
	}

	public boolean insertHouse_Years(House_Years hy) {
		return dao.insertHouse_Years(hy);
	}

	public List<House_Years> queryAllHouse_Years() {
		return dao.queryAllHouse_Years();
	}

	public House_Years queryHouse_YearsById(int hId) {
		return dao.queryHouse_YearsById(hId);
	}

	public int updateHouse_Years(House_Years hy) {
		return dao.updateHouse_Years(hy);
	}

	public int insertHouse_Years() {
		return dao.insertHouse_Years();
	}

}
