package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IHouse_TypesDao;
import cn.goll.entity.House_Types;

/**
 * 房源类型持久层实现类
 * @author LYC
 *
 */
public class House_TypesDaoImpl implements IHouse_TypesDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteHouse_Types(int htId) {
		int count = 0;
		try {
			String deleteString = "delete from house_types where ht_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, htId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertHouse_Types(House_Types ht) {
		try {
			String addString = "insert into house_types values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, ht.getHt_name());
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

	public List<House_Types> queryAllHouse_Types() {
		List<House_Types> house_Types = new ArrayList<House_Types>();
		House_Types house_Type;
		try {
			String queryString = "select * from house_types";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				house_Type = new House_Types();
				house_Type.setHt_id(rs.getInt("ht_id"));
				house_Type.setHt_name(rs.getString("ht_name"));
				house_Types.add(house_Type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Types;
	}

	public House_Types queryHouse_TypesById(int htId) {
		House_Types house_Type = null;
		try {
			String queryString = "select * from house_types where ht_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, htId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				house_Type = new House_Types();
				house_Type.setHt_id(rs.getInt("ht_id"));
				house_Type.setHt_name(rs.getString("ht_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Type;
	}

	public int updateHouse_Types(House_Types ht) {
		int count = 0;
		try {
			String updString = "update house_types set ht_name=? where ht_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, ht.getHt_name());
			pstatement.setInt(2, ht.getHt_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertHouse_Types() {
		int id=0;
		try {
			String addString = "insert into house_types values(null,'无')";
			PreparedStatement pstatement = db.getPrepareStatementWithReturnId(addString);
			id=(int) db.executeUpdateReturnId(pstatement);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return id;
	}

	
	
}
