package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IOut_RentsDao;
import cn.goll.entity.Out_Rents;
/**
 * 出租持久层实现类
 * @author LJ
 *
 */
public class Out_RentsDaoImpl implements IOut_RentsDao{

	DBUtil db = DBUtil.getInstance();
	
	public int deleteOut_Rents(int id) {
		int count = 0;
		try {
			String delString = "delete from out_rents where or_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(delString);
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

	public int insertOut_Rents(Out_Rents or) {
		int count = 0;
		try {
			String addString = "insert into out_rents values(null,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, or.getOr_ischeck());
			pstatement.setInt(2, or.getRt_id());
			pstatement.setInt(3, or.getH_id());
			pstatement.setInt(4, or.getSa_id());
			pstatement.setInt(5, or.getA_id());
			count = db.executeUpdate(pstatement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Out_Rents> queryAllOut_Rents(String or_ischeck) {
		List<Out_Rents> ors = new ArrayList<Out_Rents>();
		Out_Rents or;
		try {
			String sql = "select * from out_rents";
			if(!or_ischeck.equals("null"))
				sql+=" where or_ischeck="+or_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet set = db.executeQuery(pstatement);
			while(set.next()){
				or = new Out_Rents();
				or.setOr_id(set.getInt("or_id"));
				or.setOr_ischeck(set.getString("or_ischeck"));
				or.setH_id(set.getInt("h_id"));
				or.setSa_id(set.getInt("sa_id"));
				or.setA_id(set.getInt("a_id"));
				ors.add(or);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return ors;
	}

	public Out_Rents queryOut_RentsById(int id,String or_ischeck) {
		Out_Rents or = null;
		try {
			String sql = "select * from out_rents where or_id=?";
			if(or_ischeck!=null)
				sql+="  and or_ischeck="+or_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, id);
			ResultSet set = db.executeQuery(pstatement);
			if(set.next()){
				or = new Out_Rents();
				or.setOr_id(set.getInt("or_id"));
				or.setOr_ischeck(set.getString("or_ischeck"));
				or.setRt_id(set.getInt("or_type"));
				or.setH_id(set.getInt("h_id"));
				or.setSa_id(set.getInt("sa_id"));
				or.setA_id(set.getInt("a_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return or;
	}

	public int updateOut_Rents(Out_Rents or) {
		int count = 0;
		try {
			String updString = "update out_rents set or_ischeck=?,or_type=?,h_id=?,sa_id=?,a_id=? where or_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, or.getOr_ischeck());
			pstatement.setInt(2, or.getRt_id());
			pstatement.setInt(3, or.getH_id());
			pstatement.setInt(4, or.getSa_id());
			pstatement.setInt(5, or.getA_id());
			pstatement.setInt(6, or.getOr_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public Out_Rents selOut_RentsById(int hid, String or_ischeck) {
		Out_Rents or = null;
		try {
			String sql = "select * from out_rents where h_id=?";
			if(or_ischeck!=null)
				sql+="  and or_ischeck="+or_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, hid);
			ResultSet set = db.executeQuery(pstatement);
			if(set.next()){
				or = new Out_Rents();
				or.setOr_id(set.getInt("or_id"));
				or.setOr_ischeck(set.getString("or_ischeck"));
				or.setRt_id(set.getInt("rt_id"));
				or.setH_id(set.getInt("h_id"));
				or.setSa_id(set.getInt("sa_id"));
				or.setA_id(set.getInt("a_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return or;
	}

}
