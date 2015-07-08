package cn.goll.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.dao.ICompanysDao;
import cn.goll.dao.impl.CompanysDaoImpl;
import cn.goll.entity.Companys;
import cn.goll.service.ICompanysService;

/**
 * ICompanysService 持久层实现类
 * @author LYC
 *
 */
public class CompanysServiceImpl implements ICompanysService {
	ICompanysDao dao=new CompanysDaoImpl();
	public int deleteCompanys(int hId) {
		return dao.deleteCompanys(hId);
	}

	public boolean insertCompanys(Companys company) {
		return dao.insertCompanys(company);
	}

	public List<Companys> queryAllCompanys(String c_ischeck) {
		return dao.queryAllCompanys(c_ischeck);
	}

	public Companys queryCompanysById(int hId,String  c_ischeck) {
		return dao.queryCompanysById(hId,c_ischeck);
	}

	public int updateCompanys(Companys company) {
		return dao.updateCompanys(company);
	}

	public List<Companys> queryAllCompanysByPages(DoPage page, String cIscheck) {
		return dao.queryAllCompanysByPages(page, cIscheck);
	}

	public int deleteCompanys(int[] cIds) {
		for (int i = 0; i < cIds.length; i++) {
			if(dao.deleteCompanys(cIds[i])<=0)return 0;
		}
		return 1;
	}

	public List<Companys> queryCompanysById(int[] cIds, String cIscheck) {
		List<Companys> companyList=new ArrayList<Companys>();
		Companys company;
		for (int i = 0; i < cIds.length; i++) {
			company=dao.queryCompanysById(cIds[i], null);
			companyList.add(company);
		}
		return companyList;
	}

	public int updateCompanys(List<Companys> comList) {
		for (Companys companys : comList) {
			if(dao.updateCompanys(companys)<=0)return 0;
		}
		return 1;
	}

}
