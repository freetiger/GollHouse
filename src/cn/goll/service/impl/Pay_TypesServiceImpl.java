package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IPay_TypesDao;
import cn.goll.dao.impl.Pay_TypesDaoImpl;
import cn.goll.entity.Pay_Types;
import cn.goll.service.IPay_TypesService;

/**
 * IPay_TypesService 持久层实现类
 * @author LYC
 *
 */
public class Pay_TypesServiceImpl implements IPay_TypesService {
	IPay_TypesDao dao=new Pay_TypesDaoImpl();
	public int deletePay_Types(int hId) {
		return dao.deletePay_Types(hId);
	}

	public boolean insertPay_Types(Pay_Types py) {
		return dao.insertPay_Types(py);
	}

	public List<Pay_Types> queryAllPay_Types() {
		return dao.queryAllPay_Types();
	}

	public Pay_Types queryPay_TypesById(int hId) {
		return dao.queryPay_TypesById(hId);
	}

	public int updatePay_Types(Pay_Types py) {
		return dao.updatePay_Types(py);
	}

	public int insertPay_Types() {
		return dao.insertPay_Types();
	}

}
