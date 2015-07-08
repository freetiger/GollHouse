package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IPowersDao;
import cn.goll.entity.Powers;

/**
 * IPowersDao持久层实现类
 * @author LYC
 *
 */
public class PowersDaoImpl implements IPowersDao{

	DBUtil db = DBUtil.getInstance();

	public int deletePowers(int pId) {
		int count = 0;
		try {
			String deleteString = "delete from powers where p_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, pId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertPowers(Powers power) {
		try {
			String addString = "insert into powers values(null,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, power.getP_name());
			pstatement.setString(2, power.getP_menus());
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

	public List<Powers> queryAllPowers() {
		List<Powers> powers = new ArrayList<Powers>();
		Powers power;
		try {
			String queryString = "select * from powers";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				power = new Powers();
				power.setP_id(rs.getInt("p_id"));
				power.setP_name(rs.getString("p_name"));
				power.setP_menus(rs.getString("p_menus"));
				powers.add(power);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return powers;
	}

	public Powers queryPowersById(int pId) {
		Powers power = null;
		try {
			String queryString = "select * from powers where p_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, pId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				power = new Powers();
				power.setP_id(rs.getInt("p_id"));
				power.setP_name(rs.getString("p_name"));
				power.setP_menus(rs.getString("p_menus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return power;
	}

	public int updatePowers(Powers power) {
		int count = 0;
		try {
			String updString = "update powers set p_name=?,p_menus=? where p_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, power.getP_name());
			pstatement.setString(2, power.getP_menus());
			pstatement.setInt(3, power.getP_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Powers> queryAllPowers(DoPage doPage) {
		List<Powers> powers = new ArrayList<Powers>();
		Powers power;
		try {
			String queryString = "select * from powers limit  ?,?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, (doPage.getCurrentPage()-1)*doPage.getPageSize());
			pstatement.setInt(2, doPage.getPageSize());
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				power = new Powers();
				power.setP_id(rs.getInt("p_id"));
				power.setP_name(rs.getString("p_name"));
				power.setP_menus(rs.getString("p_menus"));
				powers.add(power);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return powers;
	}
	

}
