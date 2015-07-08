package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IHouse_YearsDao;
import cn.goll.entity.House_Years;

/**
 * 房源年份持久层实现类
 * @author LYC
 *
 */
public class House_YearsDaoImpl implements IHouse_YearsDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteHouse_Years(int hyId) {
		int count = 0;
		try {
			String deleteString = "delete from house_years where hy_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, hyId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertHouse_Years(House_Years hy) {
		try {
			String addString = "insert into house_years values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, hy.getHy_years());
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

	public List<House_Years> queryAllHouse_Years() {
		List<House_Years> house_Years = new ArrayList<House_Years>();
		House_Years house_Year;
		try {
			String queryString = "select * from house_years";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				house_Year = new House_Years();
				house_Year.setHy_id(rs.getInt("hy_id"));
				house_Year.setHy_years(rs.getString("hy_years"));
				house_Years.add(house_Year);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Years;
	}

	public House_Years queryHouse_YearsById(int hyId) {
		House_Years house_Year = null;
		try {
			String queryString = "select * from house_years where hy_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, hyId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				house_Year = new House_Years();
				house_Year.setHy_id(rs.getInt("hy_id"));
				house_Year.setHy_years(rs.getString("hy_years"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Year;
	}

	public int updateHouse_Years(House_Years hy) {
		int count = 0;
		try {
			String updString = "update house_years set hy_years=? where hy_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, hy.getHy_years());
			pstatement.setInt(2, hy.getHy_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertHouse_Years() {
		int id=0;
		try {
			String addString = "insert into house_years values(null,'无')";
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
