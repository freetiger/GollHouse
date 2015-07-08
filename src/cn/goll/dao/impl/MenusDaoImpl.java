package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IMenusDao;
import cn.goll.entity.Menus;

/**
 * IMenusDao持久层实现类
 * @author LYC
 *
 */
public class MenusDaoImpl implements IMenusDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteMenus(int mId) {
		int count = 0;
		try {
			String deleteString = "delete from menus where m_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, mId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Menus> queryAllMenus(String m_ischeck) {
		List<Menus> menus = new ArrayList<Menus>();
		Menus menu;
		try {
			String sql = "select * from menus";
			if(m_ischeck!=null){
				sql+=" where m_ischeck="+m_ischeck;
			}
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				menu = new Menus();
				menu.setM_id(rs.getInt("m_id"));
				menu.setM_name(rs.getString("m_name"));
				menu.setM_url(rs.getString("m_url"));
				menu.setF_id(rs.getInt("f_id"));
				menu.setM_isckeck(rs.getString("m_ischeck"));
				menu.setM_isckeck(rs.getString(5));
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return menus;
	}

	public Menus queryMenusById(int mId,String m_ischeck) {
		Menus menu = null;
		try {
			String sql = "select * from menus where m_id=?";
			if(m_ischeck!=null)
				sql+=" and m_ischeck="+m_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, mId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				menu = new Menus();
				menu.setM_id(rs.getInt("m_id"));
				menu.setM_name(rs.getString("m_name"));
				menu.setM_url(rs.getString("m_url"));
				menu.setF_id(rs.getInt("f_id"));
				menu.setM_isckeck(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return menu;
	}

	public int updateMenus(Menus menu) {
		int count = 0;
		try {
			String updString = "update menus set m_name=?,m_url=?,f_id=?,m_ischeck=? where m_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, menu.getM_name());
			pstatement.setString(2, menu.getM_url());
			pstatement.setInt(3, menu.getF_id());
			pstatement.setString(4, menu.getM_isckeck());
			pstatement.setInt(5, menu.getM_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Menus> queryMenusByFid(int mId, String m_ischeck) {
		List<Menus> menulist=new ArrayList<Menus>();
		Menus menu = null;
		try {
			String sql = "select * from menus where f_id=?";
			if(m_ischeck!=null)
				sql+=" and m_ischeck="+m_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, mId);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				menu = new Menus();
				menu.setM_id(rs.getInt("m_id"));
				menu.setM_name(rs.getString("m_name"));
				menu.setM_url(rs.getString("m_url"));
				menu.setF_id(mId);
				menu.setM_isckeck(rs.getString(5));
				menulist.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return menulist;
	}

	public Long insertMenus(Menus menu) {
		String sql="insert into menus values(null,?,?,?,?)";
		PreparedStatement ps=db.getPrepareStatementWithReturnId(sql);
		try {
			ps.setString(1, menu.getM_name());
			ps.setString(2, menu.getM_url());
			ps.setInt(3, menu.getF_id());
			ps.setString(4, menu.getM_isckeck());
			long id=db.executeUpdateReturnId(ps);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return null;
	}
}
