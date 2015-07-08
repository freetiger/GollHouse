package cn.goll.service.impl;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.IBrokersDao;
import cn.goll.dao.impl.BrokersDaoImpl;
import cn.goll.entity.Brokers;
import cn.goll.service.IBrokersService;

/**
 * IBrokersService 持久层实现类
 * @author LYC
 *
 */
public class BrokersServiceImpl implements IBrokersService {
	IBrokersDao dao=new BrokersDaoImpl();
	public int deleteBrokers(int hId) {
		return dao.deleteBrokers(hId);
	}

	public boolean insertBrokers(Brokers broker) {
		return dao.insertBrokers(broker);
	}

	public List<Brokers> queryAllBrokers(String b_ischeck) {
		return dao.queryAllBrokers(b_ischeck);
	}

	public Brokers queryBrokersById(int hId,String b_ischeck) {
		return dao.queryBrokersById(hId,b_ischeck);
	}

	public int updateBrokers(Brokers broker) {
		return dao.updateBrokers(broker);
	}

	public Brokers queryBrokersByEmail(String bEmail) {
		return dao.queryBrokersByEmail(bEmail);
	}

	public Brokers queryBrokersByName(String bName) {
		return dao.queryBrokersByName(bName);
	}

	public List<Brokers> queryByBrokerAndCompany(DoPage doPage,String ischeck) {
		return dao.queryByBrokerAndCompany(doPage,ischeck);
	}

	public List<Brokers> queryByBrokerAndCompany(String ischeck) {
		return dao.queryByBrokerAndCompany(ischeck);
	}

	public int setBrokersIsonline() {
		return dao.setBrokersIsonline();
	}

	public List<Brokers> queryBrokersByC_id(int cId, String bIscheck) {
		return dao.queryBrokersByC_id(cId, bIscheck);
	}

}
