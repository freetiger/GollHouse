package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IRent_MoneysDao;
import cn.goll.dao.impl.Rent_MoneysDaoImpl;
import cn.goll.entity.Rent_Moneys;
import cn.goll.service.IRent_MoneysService;

/**
 * IRent_MoneysService 持久层实现类
 * @author LYC
 *
 */
public class Rent_MoneysServiceImpl implements IRent_MoneysService {
	IRent_MoneysDao dao=new Rent_MoneysDaoImpl();
	public int deleteRent_Moneys(int hId) {
		return dao.deleteRent_Moneys(hId);
	}

	public boolean insertRent_Moneys(Rent_Moneys rent_Money) {
		return dao.insertRent_Moneys(rent_Money);
	}

	public List<Rent_Moneys> queryAllRent_Moneys() {
		return dao.queryAllRent_Moneys();
	}

	public Rent_Moneys queryRent_MoneysById(int hId) {
		return dao.queryRent_MoneysById(hId);
	}

	public int updateRent_Moneys(Rent_Moneys rent_Money) {
		return dao.updateRent_Moneys(rent_Money);
	}

	public int insertRent_Moneys() {
		return dao.insertRent_Moneys();
	}

}
