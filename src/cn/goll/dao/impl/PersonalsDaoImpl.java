package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IPersonalsDao;
import cn.goll.entity.Personals;

/**
 * 个人持久层实现类
 * @author LYC
 *
 */
public class PersonalsDaoImpl implements IPersonalsDao{

	DBUtil db = DBUtil.getInstance();

	public int deletePersonals(int perId) {
		int count = 0;
		try {
			String deleteString = "delete from personals where per_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, perId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertPersonals(Personals person) {
		try {
			String addString = "insert into personals values(null,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, person.getPer_name());
			pstatement.setString(2, person.getPer_tel());
			pstatement.setString(3, person.getPer_ischeck());
			pstatement.setInt(4, person.getH_id());
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

	public List<Personals> queryAllPersonals(String per_ischeck) {
		List<Personals> personals = new ArrayList<Personals>();
		Personals personal;
		try {
			String sql = "select * from personals";
			if(per_ischeck!=null)
				sql+=" where per_ischeck="+per_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				personal = new Personals();
				personal.setPer_id(rs.getInt("per_id"));
				personal.setPer_name(rs.getString("per_name"));
				personal.setPer_tel(rs.getString("per_tel"));
				personal.setPer_ischeck(rs.getString("per_ischeck"));
				personal.setH_id(rs.getInt("h_id"));
				personals.add(personal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return personals;
	}

	public Personals queryPersonalsById(int perId,String per_ischeck) {
		Personals personal = null;
		try {
			String sql = "select * from personals where per_id=?";
			if(per_ischeck!=null)
				sql+=" and per_ischeck="+per_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, perId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				personal = new Personals();
				personal.setPer_id(rs.getInt("per_id"));
				personal.setPer_name(rs.getString("per_name"));
				personal.setPer_tel(rs.getString("per_tel"));
				personal.setPer_ischeck(rs.getString("per_ischeck"));
				personal.setH_id(rs.getInt("h_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return personal;
	}

	public int updatePersonals(Personals person) {
		int count = 0;
		try {
			String updString = "update companys set per_name=?,per_tel=?,per_ischeck=?,h_id=? where per_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, person.getPer_name());
			pstatement.setString(2, person.getPer_tel());
			pstatement.setString(3, person.getPer_ischeck());
			pstatement.setInt(4, person.getH_id());
			pstatement.setInt(5, person.getPer_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int addPersonals(Personals person) {
		try {
			String addString = "insert into personals values(null,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatementWithReturnId(addString);
			pstatement.setString(1, person.getPer_name());
			pstatement.setString(2, person.getPer_tel());
			pstatement.setString(3, person.getPer_ischeck());
			pstatement.setInt(4, person.getH_id());
			return (int) db.executeUpdateReturnId(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}
	

}
