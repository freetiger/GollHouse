package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IPersonalsDao;
import cn.goll.dao.impl.PersonalsDaoImpl;
import cn.goll.entity.Personals;
import cn.goll.service.IPersonalsService;

/**
 * IPersonalsService 持久层实现类
 * @author LYC
 *
 */
public class PersonalsServiceImpl implements IPersonalsService {
	IPersonalsDao dao=new PersonalsDaoImpl();
	public int deletePersonals(int hId) {
		return dao.deletePersonals(hId);
	}

	public boolean insertPersonals(Personals personal) {
		return dao.insertPersonals(personal);
	}

	public List<Personals> queryAllPersonals(String per_ischeck) {
		return dao.queryAllPersonals(per_ischeck);
	}

	public Personals queryPersonalsById(int hId,String per_ischeck) {
		return dao.queryPersonalsById(hId, per_ischeck);
	}

	public int updatePersonals(Personals personal) {
		return dao.updatePersonals(personal);
	}

	public int addPersonals(Personals person) {
		return dao.addPersonals(person);
	}

}
