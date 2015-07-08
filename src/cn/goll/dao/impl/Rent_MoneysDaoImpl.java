package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IRent_MoneysDao;
import cn.goll.entity.Rent_Moneys;

/**
 * 租金持久层实现类
 * @author LYC
 *
 */
public class Rent_MoneysDaoImpl implements IRent_MoneysDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteRent_Moneys(int rmId) {
		int count = 0;
		try {
			String deleteString = "delete from rent_moneys where rm_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, rmId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertRent_Moneys(Rent_Moneys rm) {
		try {
			String addString = "insert into rent_moneys values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, rm.getRm_count());
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

	public List<Rent_Moneys> queryAllRent_Moneys() {
		List<Rent_Moneys> rent_Moneys = new ArrayList<Rent_Moneys>();
		Rent_Moneys rent_Money;
		try {
			String queryString = "select * from rent_moneys";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				rent_Money = new Rent_Moneys();
				rent_Money.setRm_id(rs.getInt("rm_id"));
				rent_Money.setRm_count(rs.getString("rm_count"));
				rent_Moneys.add(rent_Money);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return rent_Moneys;
	}

	public Rent_Moneys queryRent_MoneysById(int rmId) {
		Rent_Moneys rent_Money = null;
		try {
			String queryString = "select * from rent_moneys where rm_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, rmId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				rent_Money = new Rent_Moneys();
				rent_Money.setRm_id(rs.getInt("rm_id"));
				rent_Money.setRm_count(rs.getString("rm_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return rent_Money;
	}

	public int updateRent_Moneys(Rent_Moneys rm) {
		int count = 0;
		try {
			String updString = "update rent_moneys set rm_count=? where rm_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, rm.getRm_count());
			pstatement.setInt(2, rm.getRm_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertRent_Moneys() {
		int id=0;
		try {
			String addString = "insert into rent_moneys values(null,'无')";
			PreparedStatement pstatement = db.getPrepareStatementWithReturnId(addString);
			id=(int)db.executeUpdateReturnId(pstatement);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return id;
	}

	

}
