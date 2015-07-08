package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IRent_TypesDao;
import cn.goll.entity.Rent_Types;

/**
 * 出租类型持久层实现类
 * @author LYC
 *
 */
public class Rent_TypesDaoImpl implements IRent_TypesDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteRent_Types(int rtId) {
		int count = 0;
		try {
			String deleteString = "delete from rent_types where rt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, rtId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertRent_Types(Rent_Types rt) {
		try {
			String addString = "insert into rent_types values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, rt.getRt_name());
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

	public List<Rent_Types> queryAllRent_Types() {
		List<Rent_Types> rent_Types = new ArrayList<Rent_Types>();
		Rent_Types rent_Type;
		try {
			String queryString = "select * from rent_types";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				rent_Type = new Rent_Types();
				rent_Type.setRt_id(rs.getInt("rt_id"));
				rent_Type.setRt_name(rs.getString("rt_name"));
				rent_Types.add(rent_Type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return rent_Types;
	}

	public Rent_Types queryRent_TypesById(int rtId) {
		Rent_Types rent_Type = null;
		try {
			String queryString = "select * from rent_types where rt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, rtId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				rent_Type = new Rent_Types();
				rent_Type.setRt_id(rs.getInt("rt_id"));
				rent_Type.setRt_name(rs.getString("rt_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return rent_Type;
	}

	public int updateRent_Types(Rent_Types rt) {
		int count = 0;
		try {
			String updString = "update rent_types set rt_name=? where rt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, rt.getRt_name());
			pstatement.setInt(2, rt.getRt_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertRent_Types() {
		int id=0;
		try {
			String addString = "insert into rent_types values(null,'无')";
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
