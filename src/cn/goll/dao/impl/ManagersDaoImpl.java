package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IManagersDao;
import cn.goll.entity.Managers;

/**
 * 管理员持久层实现类
 * @author LYC
 *
 */
public class ManagersDaoImpl implements IManagersDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteManagers(int id) {
		int count = 0;
		try {
			String deleteString = "delete from managers where id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, id);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertManagers(Managers manager) {
		try {
			String addString = "insert into managers values(null,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, manager.getUname());
			pstatement.setString(2, manager.getPwd());
			pstatement.setInt(3, manager.getP_id());
			pstatement.setString(4, manager.getIscheck());
			pstatement.setInt(5, manager.getIsonline());
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

	public List<Managers> queryAllManagers(String ischeck) {
		List<Managers> managers = new ArrayList<Managers>();  
		Managers manager;
		try {
			String sql = "select * from managers";
			if(ischeck!=null)
				sql+=" where ischeck="+ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(rs.getString("uname"));
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setIsonline(rs.getInt("isonline"));
				managers.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return managers;
	}

	public Managers queryManagersById(int id,String ischeck) {
		Managers manager = null;
		try {
			String sql = "select * from managers where id=?";
			if(ischeck!=null)
				sql+=" and ischeck="+ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, id);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(rs.getString("uname"));
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setIsonline(rs.getInt("isonline"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return manager;
	}

	public int updateManagers(Managers manager) {
		int count = 0;
		try {
			String updString = "update managers set uname=?,pwd=?,p_id=?,ischeck=?,isonline=? where id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, manager.getUname());
			pstatement.setString(2, manager.getPwd());
			pstatement.setInt(3, manager.getP_id());
			pstatement.setString(4, manager.getIscheck());
			pstatement.setInt(5, manager.getId());
			pstatement.setInt(6, manager.getIsonline());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public Managers queryManagersByName(String uname,String ischeck) {
		Managers manager = null;
		try {
			String sql = "select id,pwd,p_id,isonline,ischeck from managers where uname=?";
			if(ischeck!=null)
				sql+=" and ischeck="+ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setString(1, uname);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(uname);
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setIsonline(rs.getInt("isonline"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return manager;
	}

	public List<Managers> queryAllManagers() {
		List<Managers> managers = new ArrayList<Managers>();  
		Managers manager;
		try {
			String sql = "select * from managers";
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(rs.getString("uname"));
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setIsonline(rs.getInt("isonline"));
				managers.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return managers;
	}

	public List<Managers> queryAllManagers(DoPage pager) {
		List<Managers> managers = new ArrayList<Managers>();  
		Managers manager;
		try {
			String sql = "select * from managers m,powers p where m.p_id=p.p_id order by  id desc limit ?,?";
			
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1,(pager.getCurrentPage()-1)*pager.getPageSize());
			pstatement.setInt(2, pager.getPageSize());
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(rs.getString("uname"));
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setP_name(rs.getString("p_name"));
				manager.setIsonline(rs.getInt("isonline"));
				managers.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return managers;
	}

	public List<Managers> queryAllManagers(String ischeck, DoPage pager) {
		List<Managers> managers = new ArrayList<Managers>();  
		Managers manager;
		try {
			String sql = "select * from managers m,powers p where m.p_id=p.p_id and ischeck=? order by  id desc limit ?,?";
			
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setString(1, ischeck);
			pstatement.setInt(2,(pager.getCurrentPage()-1)*pager.getPageSize());
			pstatement.setInt(3, pager.getPageSize());
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				manager = new Managers();
				manager.setId(rs.getInt("id"));
				manager.setUname(rs.getString("uname"));
				manager.setPwd(rs.getString("pwd"));
				manager.setP_id(rs.getInt("p_id"));
				manager.setIscheck(rs.getString("ischeck"));
				manager.setP_name(rs.getString("p_name"));
				manager.setIsonline(rs.getInt("isonline"));
				managers.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return managers;
	}

	public int updateManagers(int id, String ischeck) {
		int count = 0;
		try {
			String updString = "update managers set ischeck=? where id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			
			pstatement.setString(1,ischeck);
			pstatement.setInt(2,id);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int setManagerIsonline() {
		String sql="update managers set isonline=0 where id>0";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			int result=ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}
}
