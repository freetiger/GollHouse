package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IHouse_ImgsDao;
import cn.goll.dao.impl.House_ImgsDaoImpl;
import cn.goll.entity.House_Imgs;
import cn.goll.service.IHouse_ImgsService;

/**
 * IHouse_ImgsService 持久层实现类
 * @author LYC
 *
 */
public class House_ImgsServiceImpl implements IHouse_ImgsService {
	IHouse_ImgsDao dao=new House_ImgsDaoImpl();
	public int deleteHouse_Imgs(int hId) {
		return dao.deleteHouse_Imgs(hId);
	}

	public long insertHouse_Imgs(House_Imgs hi) {
		return dao.insertHouse_Imgs(hi);
	}

	public List<House_Imgs> queryAllHouse_Imgs(String hi_ischeck) {
		return dao.queryAllHouse_Imgs(hi_ischeck);
	}

	public House_Imgs queryHouse_ImgsById(int hId,String hi_ischeck) {
		return dao.queryHouse_ImgsById(hId,hi_ischeck);
	}

	public int updateHouse_Imgs(House_Imgs hi) {
		return dao.updateHouse_Imgs(hi);
	}

}
