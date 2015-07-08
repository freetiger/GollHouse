package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.ICompanysDao;
import cn.goll.entity.Companys;

/**
 * 中介公司持久层实现类
 * @author LYC
 *
 */
public class CompanysDaoImpl implements ICompanysDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteCompanys(int cId) {
		int count = 0;
		try {
			String deleteString = "delete from companys where c_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, cId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertCompanys(Companys com) {
		try {
			String addString = "insert into companys values(null,?,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, com.getC_name());
			pstatement.setString(2, com.getC_complete_year());
			pstatement.setString(3, com.getC_address());
			pstatement.setString(4, com.getC_img());
			pstatement.setString(5, com.getC_ischeck());
			pstatement.setString(6, com.getC_infos());
			db.executeUpdate(pstatement);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return false;
	}

	public List<Companys> queryAllCompanys(String c_ischeck) {
		List<Companys> companys = new ArrayList<Companys>();
		Companys company;
		try {
			String sql = "select * from companys";
			if(c_ischeck!=null)
				sql+="  where c_ischeck="+c_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				company = new Companys();
				company.setC_id(rs.getInt("c_id"));
				company.setC_name(rs.getString("c_name"));
				company.setC_complete_year(rs.getString("c_complete_year"));
				company.setC_address(rs.getString("c_address"));
				company.setC_img(rs.getString("c_img"));
				company.setC_ischeck(rs.getString("c_ischeck"));
				company.setC_infos(rs.getString("c_infos"));
				companys.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return companys;
	}

	public Companys queryCompanysById(int cId,String c_ischeck) {
		Companys company = null;
		try {
			String sql = "select * from companys where c_id=?";
			if(c_ischeck!=null)
				sql+=" and c_ischeck="+c_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, cId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				company = new Companys();
				company.setC_id(rs.getInt("c_id"));
				company.setC_name(rs.getString("c_name"));
				company.setC_complete_year(rs.getString("c_complete_year"));
				company.setC_address(rs.getString("c_address"));
				company.setC_img(rs.getString("c_img"));
				company.setC_ischeck(rs.getString("c_ischeck"));
				company.setC_ischeck(rs.getString("c_ischeck"));
				company.setC_infos(rs.getString("c_infos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return company;
	}

	public int updateCompanys(Companys com) {
		int count = 0;
		try {
			String updString = "update companys set c_name=?,c_complete_year=?,c_address=?,c_img=?,c_ischeck=?,c_infos=? where c_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, com.getC_name());
			pstatement.setString(2, com.getC_complete_year());
			pstatement.setString(3, com.getC_address());
			pstatement.setString(4, com.getC_img());
			pstatement.setString(5, com.getC_ischeck());
			pstatement.setString(6, com.getC_infos());
			pstatement.setInt(7, com.getC_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Companys> queryAllCompanysByPages(DoPage page, String cIscheck) {
		List<Companys> companys = new ArrayList<Companys>();
		Companys company;
		try {
			String sql = "select * from companys";
			if(cIscheck!=null)
				sql+="  where c_ischeck="+cIscheck;
			sql+=" limit ?,?";
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, (page.getCurrentPage()-1)*page.getPageSize());
			pstatement.setInt(2, page.getPageSize());
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				company = new Companys();
				company.setC_id(rs.getInt("c_id"));
				company.setC_name(rs.getString("c_name"));
				company.setC_complete_year(rs.getString("c_complete_year"));
				company.setC_address(rs.getString("c_address"));
				company.setC_img(rs.getString("c_img"));
				company.setC_ischeck(rs.getString("c_ischeck"));
				company.setC_infos(rs.getString("c_infos"));
				companys.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return companys;
	}
	
	

}
