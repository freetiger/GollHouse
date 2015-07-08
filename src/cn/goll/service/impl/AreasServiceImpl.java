package cn.goll.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IAreasDao;
import cn.goll.dao.impl.AreasDaoImpl;
import cn.goll.entity.Areas;
import cn.goll.service.IAreasService;

public class AreasServiceImpl implements IAreasService{

	IAreasDao areasDao = new AreasDaoImpl();
	
	public int deleteAreas(int id) {
		return areasDao.deleteAreas(id);
	}

	public boolean insertAreas(Areas area) {
		int result = areasDao.insertAreas(area);
		if(result > 0) return true;
		else return false;
	}

	public Areas queruAreasByid(int id,String a_ischeck) {
		
		return areasDao.queryAreasById(id,a_ischeck);
	}

	public List<Areas> queryAllAreas(String a_ischeck) {
		return areasDao.queryAllAreas(a_ischeck);
	}

	public int updateAreas(Areas area) {
		return areasDao.updateAreas(area);
	}

	public List<Areas> queryAllAreasByPage(DoPage page, String isCheck) {
		return areasDao.selectAllAreasByPage(page, isCheck);
	}

	public int deleteAreasByIds(int[] ids) {
		for (int i = 0; i < ids.length; i++) {
			if(areasDao.deleteAreas(ids[i])<=0)return 0;
		}
		return 1;
	}

	public List<Areas> queruAreasByids(int[] ids, String aIscheck) {
		List<Areas> areaList=new ArrayList<Areas>();
		Areas area;
		for (int i = 0; i < ids.length; i++) {
			area=areasDao.queryAreasById(ids[i], null);
			areaList.add(area);
		}
		return areaList;
	}

	public int updateAreasList(List<Areas> areaList) {
		for (Areas areas : areaList) {
			if(areasDao.updateAreas(areas)<=0)return 0;
		}
		return 1;
	}

}
