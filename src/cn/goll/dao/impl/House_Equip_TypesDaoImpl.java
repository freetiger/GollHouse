package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IHouse_Equip_TypesDao;
import cn.goll.entity.House_Equip_Types;

/**
 * 房源配置持久层实现类
 * @author LYC
 *
 */
public class House_Equip_TypesDaoImpl implements IHouse_Equip_TypesDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteHouse_Equip_Types(int hetId) {
		int count = 0;
		try {
			String deleteString = "delete from house_equip_types where het_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, hetId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertHouse_Equip_Types(House_Equip_Types het) {
		try {
			String addString = "insert into house_equip_types values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, het.getHet_name());
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

	public List<House_Equip_Types> queryAllHouse_Equip_Types() {
		List<House_Equip_Types> house_Equip_Types = new ArrayList<House_Equip_Types>();
		House_Equip_Types house_Equip_Type;
		try {
			String queryString = "select * from house_equip_types";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				house_Equip_Type = new House_Equip_Types();
				house_Equip_Type.setHet_id(rs.getInt("het_id"));
				house_Equip_Type.setHet_name(rs.getString("het_name"));
				house_Equip_Types.add(house_Equip_Type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Equip_Types;
	}

	public House_Equip_Types queryHouse_Equip_TypesById(int hetId) {
		House_Equip_Types house_Equip_Type = null;
		try {
			String queryString = "select * from house_equip_types where het_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, hetId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				house_Equip_Type = new House_Equip_Types();
				house_Equip_Type.setHet_id(rs.getInt("het_id"));
				house_Equip_Type.setHet_name(rs.getString("het_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Equip_Type;
	}

	public int updateHouse_Equip_Types(House_Equip_Types het) {
		int count = 0;
		try {
			String updString = "update house_equip_types set het_name=? where het_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, het.getHet_name());
			pstatement.setInt(2, het.getHet_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertHouse_Equip_Types() {
		int i=0;
		try {
			String addString = "insert into house_equip_types values(null,'无')";
			PreparedStatement pstatement = db.getPrepareStatementWithReturnId(addString);
			i=(int) db.executeUpdateReturnId(pstatement);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return i;
	}

	

	

}
