package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IHousesDao;
import cn.goll.dao.impl.HousesDaoImpl;
import cn.goll.entity.Houses;
import cn.goll.service.IHousesService;

public class HousesServiceImpl implements IHousesService {
	IHousesDao dao=new HousesDaoImpl();
	public int deleteHouses(int hId) {
		return dao.deleteHouses(hId);
	}

	public long insertHouses(Houses house) {
		return dao.insertHouses(house);
	}

	public List<Houses> queryAllHouses(String h_ischeck) {
		return dao.queryAllHouses(h_ischeck);
	}

	public Houses queryHousesById(int hId,String h_ischeck) {
		return dao.queryHousesById(hId,h_ischeck);
	}

	public int updateHouses(Houses house) {
		return dao.updateHouses(house);
	}

	public List<Houses> queryAllHouses(DoPage pager) {
		return dao.queryAllHouses(pager);
	}

	public List<Houses> queryAllHouses(String h_ischeck, DoPage pager) {
		return dao.queryAllHouses(h_ischeck, pager);
	}

	public List<Houses> queryAllHouses(int h_ischarge, DoPage pager) {
		return dao.queryAllHouses(h_ischarge, pager);
	}

	public List<Houses> queryAllHouses(int h_ischarge) {
		return dao.queryAllHouses(h_ischarge);
	}

	public List<Houses> queryAllHouses() {
		return dao.queryAllHouses();
	}

	public Houses queryHouseById(int h_id) {
		return dao.selectHousesById(h_id);
	}

	public int updateHousesCheck(String check, int hId) {
		return dao.updateHousesCheck(check, hId);
	}

	public List<Houses> queryAllHousesBySa_id(int saId, int ischarge,
			String ischeck) {
		return dao.selectHousesBySa_id(saId, ischarge, ischeck);
	}

	public List<Houses> queryAllHousesBySa_idWithPages(int saId, int ischarge,
			DoPage page, String ischeck) {
		return dao.selectHousesBySa_idWithPages(saId, ischarge, page, ischeck);
	}

	public List<Houses> selectHouses(int hIscharge, int hRelevanceId,	String ischeck) {
		return dao.selectHouses(hIscharge, hRelevanceId, ischeck);
	}

	public List<Houses> queryHousesByIsup(int isup) {
		return dao.queryHousesByIsup(isup);
	}

	public List<Houses> queryHousesBySql(String sql) {
		return dao.queryHousesBySql(sql);
	}

	public String queryHousesAllTag() {
		return dao.queryHousesAllTag();
	}

	public List<Houses> queryHousesByTag(String tag) {
		return dao.queryHousesByTag(tag);
	}

	public int addHouses(Houses house) {
		return dao.addHouses(house);
	}

	public int updateHouses(int id, int relevance) {
		return dao.updateHouses(id, relevance);
	}

	public List<Houses> queryHousesBySqlWithPage(String sql, DoPage page) {
		return dao.queryHousesBySqlWithPage(sql, page);
	}

	public List<Houses> queryHousesByC_id(int cId) {
		return dao.queryHousesByC_id(cId);
	}

	public List<Houses> queryHousesByC_idWithPage(int cId, DoPage page) {
		return dao.queryHousesByC_idWithPage(cId, page);
	}

	public List<Houses> queryHousesByIsupAndtime(int isup) {
		return dao.queryHousesByIsupAndtime(isup);
	}

	public List<Houses> queryHousesByB_id(int bId) {
		return dao.queryHousesByB_id(bId);
	}

	public List<Houses> queryHousesBySa_id(int saId) {
		return dao.queryHousesBySa_id(saId);
	}

	public List<Houses> queryHousesByB_idWithPage(int bId, DoPage page) {
		return dao.queryHousesByB_idWithPage(bId, page);
	}

	public List<Houses> queryHousesBySa_idWithPage(int saId, DoPage page) {
		return dao.queryHousesBySa_idWithPage(saId, page);
	}

	public List<Houses> queryHouseBybid(int hRelevanceId, String ischeck,
			DoPage pager) {
		return dao.queryHouseBybid(hRelevanceId, ischeck, pager);
	}
	public List<Houses> queryHouses(int hIscharge, int hRelevanceId,
			String ischeck, DoPage page) {
		return dao.selectHouses(hIscharge, hRelevanceId, ischeck,page);
	}

	public List<Houses> queryHouseBybid(int hRelevanceId, String ischeck) {
		return dao.queryHouseBybid(hRelevanceId, ischeck);
	}




}
