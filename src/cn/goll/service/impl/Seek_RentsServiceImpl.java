package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.ISeek_RentsDao;
import cn.goll.dao.impl.Seek_RentsDaoImpl;
import cn.goll.entity.Seek_Rents;
import cn.goll.service.ISeek_RentsService;

public class Seek_RentsServiceImpl implements ISeek_RentsService{

	ISeek_RentsDao Seek_RentsDao = new Seek_RentsDaoImpl();
	
	public int deleteSeek_Rents(int id) {
		return Seek_RentsDao.deleteSeek_Rents(id);
	}

	public boolean insertSeek_Rents(Seek_Rents sr) {
		int result = Seek_RentsDao.insertSeek_Rents(sr);
		if(result > 0) return true;
		else return false;
	}

	public Seek_Rents queruSeek_RentsByid(int id,String sr_ischeck) {
		
		return Seek_RentsDao.querySeek_RentsById(id,sr_ischeck);
	}

	public List<Seek_Rents> queryAllSeek_Rents(String sr_ischeck) {
		return Seek_RentsDao.queryAllSeek_Rents(sr_ischeck);
	}

	public int updateSeek_Rents(Seek_Rents sr) {
		return Seek_RentsDao.updateSeek_Rents(sr);
	}

	public List<Seek_Rents> queryAllSeek_Rents(String srIscheck, DoPage pager) {
		return Seek_RentsDao.queryAllSeek_Rents(srIscheck, pager);
	}

	public int updateSeek_Rents(int id, String ischeck) {
		return Seek_RentsDao.updateSeek_Rents(id, ischeck);
	}


}
