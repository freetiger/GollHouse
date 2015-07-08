package cn.goll.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.ISmall_AreasDao;
import cn.goll.dao.impl.Small_AreasDaoImpl;
import cn.goll.entity.Small_Areas;
import cn.goll.service.ISmall_AreasService;

public class Small_AreasServiceImpl implements ISmall_AreasService {
	ISmall_AreasDao dao = new Small_AreasDaoImpl();
	public int deleteSmall_Areas(int saId) {
		return dao.deleteSmall_Areas(saId);
	}

	public boolean insertSmall_Areas(Small_Areas sa) {
		return dao.insertSmall_Areas(sa);
	}

	public List<Small_Areas> querySmall_Areas(String saIscheck) {
		return dao.querySmall_Areas(saIscheck);
	}

	public List<Small_Areas> querySmall_AreasByA_id(int aId, String saIscheck) {
		return dao.querySmall_AreasByA_id(aId, saIscheck);
	}

	public Small_Areas querySmall_AreasById(int saId, String saIscheck) {
		return dao.querySmall_AreasById(saId, saIscheck);
	}

	public int updateSmall_Areas(Small_Areas sa) {
		return dao.updateSmall_Areas(sa);
	}

	public int deleteSmall_AreasByIds(int[] saIds) {
		for (int i = 0; i < saIds.length; i++) {
			if(dao.deleteSmall_Areas(saIds[i])<=0)return 0;
		}
		return 1;
	}

	public List<Small_Areas> querySmall_AreasByPages(DoPage page,
			String saIscheck) {
		return dao.querySmall_AreasByPages(page, saIscheck);
	}

	public List<Small_Areas> querySmall_AreasByIds(int[] saIds, String saIscheck) {
		List<Small_Areas> smallAreaList=new ArrayList<Small_Areas>();
		Small_Areas smallArea;
		for (int i = 0; i < saIds.length; i++) {
			smallArea=dao.querySmall_AreasById(saIds[i], null);
			smallAreaList.add(smallArea);
		}
		return smallAreaList;
	}

	public int updateSmall_AreasList(List<Small_Areas> saList) {
		for (Small_Areas smallAreas : saList) {
			if(dao.updateSmall_Areas(smallAreas)<=0)return 0;
		}
		return 1;
	}

	public List<Small_Areas> querySmall_AreasByPagesWithA_id(int aId,
			DoPage page, String saIscheck) {
		return dao.querySmall_AreasByPagesWithA_id(aId, page, saIscheck);
	}
	


}
