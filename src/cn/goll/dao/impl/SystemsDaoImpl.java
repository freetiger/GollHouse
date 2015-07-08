package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.ISystemsDao;
import cn.goll.entity.Systems;

/**
 * ISystemsDao持久层实现类
 * @author LYC
 *
 */
public class SystemsDaoImpl implements ISystemsDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteSystems(int sysId) {
		int count = 0;
		try {
			String deleteString = "delete from systems where sys_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, sysId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertSystems(Systems sys) {
		try {
			String addString = "insert into systems values(null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, sys.getSys_name());
			pstatement.setString(2, sys.getSys_dns());
			pstatement.setString(3, sys.getSys_counts());
			pstatement.setString(4, sys.getSys_tag());
			pstatement.setString(5, sys.getSys_logo());
			pstatement.setString(6, sys.getSys_infos());
			pstatement.setString(7, sys.getSys_tel());
			pstatement.setString(8, sys.getSys_date());
			pstatement.setString(9, sys.getSys_qq());
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

	public List<Systems> queryAllSystems() {
		List<Systems> systems = new ArrayList<Systems>();
		Systems system;
		try {
			String queryString = "select * from systems";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				system = new Systems();
				system.setSys_id(rs.getInt("sys_id"));
				system.setSys_name(rs.getString("sys_name"));
				system.setSys_dns(rs.getString("sys_dns"));
				system.setSys_counts(rs.getString("sys_counts"));
				system.setSys_tag(rs.getString("sys_tag"));
				system.setSys_logo(rs.getString("sys_logo"));
				system.setSys_infos(rs.getString("sys_infos"));
				system.setSys_tel(rs.getString("sys_tel"));
				system.setSys_date(rs.getString("sys_date"));
				system.setSys_qq(rs.getString("sys_qq"));
				systems.add(system);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return systems;
	}

	public Systems querySystemsById(int sysId) {
		Systems system = null;
		try {
			String queryString = "select * from systems where sys_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, sysId);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				system = new Systems();
				system.setSys_id(rs.getInt("sys_id"));
				system.setSys_name(rs.getString("sys_name"));
				system.setSys_dns(rs.getString("sys_dns"));
				system.setSys_counts(rs.getString("sys_counts"));
				system.setSys_tag(rs.getString("sys_tag"));
				system.setSys_logo(rs.getString("sys_logo"));
				system.setSys_infos(rs.getString("sys_infos"));
				system.setSys_tel(rs.getString("sys_tel"));
				system.setSys_date(rs.getString("sys_date"));
				system.setSys_qq(rs.getString("sys_qq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return system;
	}

	public int updateSystems(Systems sys) {
		int count = 0;
		try {
			String updString = "update systems set sys_name=?,sys_dns=?,sys_counts=?,sys_tag=?,sys_logo=?,sys_infos=?,sys_tel=?,sys_date=?,sys_qq=? where sys_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, sys.getSys_name());
			pstatement.setString(2, sys.getSys_dns());
			pstatement.setString(3, sys.getSys_counts());
			pstatement.setString(4, sys.getSys_tag());
			pstatement.setString(5, sys.getSys_logo());
			pstatement.setString(6, sys.getSys_infos());
			pstatement.setString(7, sys.getSys_tel());
			pstatement.setString(8, sys.getSys_date());
			pstatement.setString(9, sys.getSys_qq());
			pstatement.setInt(10, sys.getSys_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	

}
