package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.ISmall_Area_ImgsDao;
import cn.goll.dao.impl.Small_Area_ImgsDaoImpl;
import cn.goll.entity.Small_Area_Imgs;
import cn.goll.service.ISmall_Area_ImgsService;

/**
 * ISmall_Area_ImgsService 持久层实现类
 * @author LYC
 *
 */
public class Small_Area_ImgsServiceImpl implements ISmall_Area_ImgsService {
	ISmall_Area_ImgsDao dao=new Small_Area_ImgsDaoImpl();
	public int deleteSmall_Area_Imgs(int hId) {
		return dao.deleteSmall_Area_Imgs(hId);
	}

	public boolean insertSmall_Area_Imgs(Small_Area_Imgs sai) {
		return dao.insertSmall_Area_Imgs(sai);
	}

	public List<Small_Area_Imgs> queryAllSmall_Area_Imgs(String sai_ischeck) {
		return dao.queryAllSmall_Area_Imgs(sai_ischeck);
	}

	public Small_Area_Imgs querySmall_Area_ImgsById(int hId,String sai_ischeck) {
		return dao.querySmall_Area_ImgsById(hId,sai_ischeck);
	}

	public int updateSmall_Area_Imgs(Small_Area_Imgs sai) {
		return dao.updateSmall_Area_Imgs(sai);
	}

}
