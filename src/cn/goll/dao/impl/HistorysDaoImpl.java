package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IHistorysDao;
import cn.goll.entity.Historys;

/**
 * 历史记录持久层实现类
 * @author LYC
 *
 */
public class HistorysDaoImpl implements IHistorysDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteHistorys(int hisId) {
		int count = 0;
		try {
			String deleteString = "delete from historys where his_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, hisId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertHistorys(Historys his) {
		try {
			String addString = "insert into historys values(null,?,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setInt(1, his.getHis_b_id());
			pstatement.setInt(2, his.getHis_manager_id());
			pstatement.setString(3, his.getHis_do_name());
			pstatement.setString(4, his.getHis_do_actions());
			pstatement.setString(5, his.getHis_do_event());
			pstatement.setString(6, his.getHis_date());
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

	public List<Historys> queryAllHistorys() {
		List<Historys> historys = new ArrayList<Historys>();
		Historys history;
		try {
			String queryString = "select * from historys";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				history = new Historys();
				history.setHis_id(rs.getInt("his_id"));
				history.setHis_b_id(rs.getInt("his_b_id"));
				history.setHis_manager_id(rs.getInt("his_manager_id"));
				history.setHis_do_name(rs.getString("his_do_name"));
				history.setHis_do_actions(rs.getString("his_do_actions"));
				history.setHis_do_event(rs.getString("his_do_event"));
				history.setHis_date(rs.getString("his_date"));
				historys.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return historys;
	}

	public Historys queryHistorysById(int hisId) {
		Historys history = null;
		try {
			String queryString = "select * from historys where his_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, hisId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				history = new Historys();
				history.setHis_id(rs.getInt("his_id"));
				history.setHis_b_id(rs.getInt("his_b_id"));
				history.setHis_manager_id(rs.getInt("his_manager_id"));
				history.setHis_do_name(rs.getString("his_do_name"));
				history.setHis_do_actions(rs.getString("his_do_actions"));
				history.setHis_do_event(rs.getString("his_do_event"));
				history.setHis_date(rs.getString("his_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return history;
	}

	public int updateHistorys(Historys his) {
		int count = 0;
		try {
			String updString = "update historys set his_b_id=?,his_manager_id=?,his_do_name=?,his_do_actions=?,his_do_event=?,his_date=? where his_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setInt(1, his.getHis_b_id());
			pstatement.setInt(2, his.getHis_manager_id());
			pstatement.setString(3, his.getHis_do_name());
			pstatement.setString(4, his.getHis_do_actions());
			pstatement.setString(5, his.getHis_do_event());
			pstatement.setString(6, his.getHis_date());
			pstatement.setInt(7, his.getHis_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Historys> queryAllHistorys(DoPage doPage) {
		List<Historys> historys = new ArrayList<Historys>();
		Historys history;
		try {
			String queryString = "select * from historys order by his_id desc limit ?,?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, (doPage.getCurrentPage()-1)*doPage.getPageSize());
			pstatement.setInt(2, doPage.getPageSize());
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				history = new Historys();
				history.setHis_id(rs.getInt("his_id"));
				history.setHis_b_id(rs.getInt("his_b_id"));
				history.setHis_manager_id(rs.getInt("his_manager_id"));
				history.setHis_do_name(rs.getString("his_do_name"));
				history.setHis_do_actions(rs.getString("his_do_actions"));
				history.setHis_do_event(rs.getString("his_do_event"));
				history.setHis_date(rs.getString("his_date"));
				historys.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return historys;
	}

}
