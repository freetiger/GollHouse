package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IAreasDao;
import cn.goll.dao.ISeek_RentsDao;
import cn.goll.dao.ISmall_AreasDao;
import cn.goll.entity.Areas;
import cn.goll.entity.Seek_Rents;
import cn.goll.entity.Small_Areas;
/**
 * 求租持久层实现类
 * @author LJ
 *
 */
public class Seek_RentsDaoImpl implements ISeek_RentsDao{

	DBUtil db = DBUtil.getInstance();
	
	public int deleteSeek_Rents(int id) {
		int count = 0;
		try {
			String delString = "delete from seek_rents where sr_id=?";
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

	public int insertSeek_Rents(Seek_Rents sr) {
		int count = 0;
		try {
			String addString = "insert into seek_rents values(null,?,?,?,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, sr.getSr_price());
			pstatement.setString(2, sr.getSr_tel());
			pstatement.setString(3, sr.getSr_ischeck());
			pstatement.setInt(4, sr.getA_id());
			pstatement.setString(5, sr.getSr_infos());
			pstatement.setInt(6, sr.getSa_id());
			count = db.executeUpdate(pstatement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Seek_Rents> queryAllSeek_Rents(String sr_ischeck) {
		List<Seek_Rents> srs = new ArrayList<Seek_Rents>();
		Seek_Rents sr;
		try {
			String sql = "select * from seek_rents";
			if(sr_ischeck!=null)
				sql+="  where sr_ischeck="+sr_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet set = db.executeQuery(pstatement);
			while(set.next()){
				sr = new Seek_Rents();
				sr.setSr_id(set.getInt("sr_id"));
				sr.setSr_price(set.getString("sr_price"));
				sr.setSr_tel(set.getString("sr_tel"));
				sr.setSr_ischeck(set.getString("sr_ischeck"));
				sr.setA_id(set.getInt("a_id"));
				sr.setSr_infos(set.getString("sr_infos"));
				sr.setSa_id(set.getInt("sa_id"));
				srs.add(sr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return srs;
	}

	public Seek_Rents querySeek_RentsById(int id,String sr_ischeck) {
		Seek_Rents sr = null;
		try {
			String sql = "select * from seek_rents where sr_id=?";
			if(sr_ischeck!=null)
				sql+="  and sr_ischeck="+sr_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, id);
			ResultSet set = db.executeQuery(pstatement);
			if(set.next()){
				sr = new Seek_Rents();
				sr.setSr_id(set.getInt("sr_id"));
				sr.setSr_price(set.getString("sr_price"));
				sr.setSr_tel(set.getString("sr_tel"));
				sr.setSr_ischeck(set.getString("sr_ischeck"));
				sr.setA_id(set.getInt("a_id"));
				sr.setSr_infos(set.getString("sr_infos"));
				sr.setSa_id(set.getInt("sa_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return sr;
	}

	public int updateSeek_Rents(Seek_Rents sr) {
		int count = 0;
		try {
			String updString = "update seek_rents set sr_price=?,sr_tel=?,sr_ischeck=?,a_id=?,sr_infos=?,a_id=? where sr_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, sr.getSr_price());
			pstatement.setString(2, sr.getSr_tel());
			pstatement.setString(3, sr.getSr_ischeck());
			pstatement.setInt(4, sr.getA_id());
			pstatement.setString(5, sr.getSr_infos());
			pstatement.setInt(6, sr.getSa_id());
			pstatement.setInt(7, sr.getSr_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Seek_Rents> queryAllSeek_Rents(String sr_ischeck, DoPage pager) {
		List<Seek_Rents> srs = new ArrayList<Seek_Rents>();
		List<Object> list=new ArrayList<Object>();
		Seek_Rents sr;
		try {
			String sql = "select * from seek_rents";
			if(sr_ischeck!=null)
				sql+="  where sr_ischeck="+sr_ischeck;
			sql+=" order by sr_id desc limit ?,?";
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, (pager.getCurrentPage()-1)*pager.getPageSize());
			pstatement.setInt(2, pager.getPageSize());
			ResultSet set = db.executeQuery(pstatement);
			while(set.next()){
				sr = new Seek_Rents();
				sr.setSr_id(set.getInt("sr_id"));
				sr.setSr_price(set.getString("sr_price"));
				sr.setSr_tel(set.getString("sr_tel"));
				sr.setSr_ischeck(set.getString("sr_ischeck"));
				sr.setA_id(set.getInt("a_id"));
				sr.setSr_infos(set.getString("sr_infos"));
				sr.setSa_id(set.getInt("sa_id"));
				IAreasDao areaDao=new AreasDaoImpl();
				ISmall_AreasDao saDao=new Small_AreasDaoImpl();
				Areas area=areaDao.queryAreasById(set.getInt("a_id"), null);
				list.add(area);
				Small_Areas sa=saDao.querySmall_AreasById(set.getInt("sa_id"), null);
				list.add(sa);
				sr.setList(list);
				srs.add(sr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return srs;
	}

	public int updateSeek_Rents(int id, String ischeck) {
		int count = 0;
		try {
			String updString = "update seek_rents set sr_ischeck=? where sr_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, ischeck);
			pstatement.setInt(2, id);
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
