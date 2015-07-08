package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IOut_RentsDao;
import cn.goll.dao.impl.Out_RentsDaoImpl;
import cn.goll.entity.Out_Rents;
import cn.goll.service.IOut_RentsService;

public class Out_RentsServiceImpl implements IOut_RentsService{

	IOut_RentsDao Out_RentsDao = new Out_RentsDaoImpl();
	
	public int deleteOut_Rents(int id) {
		return Out_RentsDao.deleteOut_Rents(id);
	}

	public boolean insertOut_Rents(Out_Rents or) {
		int result = Out_RentsDao.insertOut_Rents(or);
		if(result > 0) return true;
		else return false;
	}

	public Out_Rents queruOut_RentsByid(int id,String or_ischeck) {
		
		return Out_RentsDao.queryOut_RentsById(id,or_ischeck);
	}

	public List<Out_Rents> queryAllOut_Rents(String or_ischeck) {
		return Out_RentsDao.queryAllOut_Rents(or_ischeck);
	}

	public int updateOut_Rents(Out_Rents or) {
		return Out_RentsDao.updateOut_Rents(or);
	}

	public Out_Rents selOut_RentsByid(int hid, String orIscheck) {
		return Out_RentsDao.selOut_RentsById(hid, orIscheck);
	}


}
