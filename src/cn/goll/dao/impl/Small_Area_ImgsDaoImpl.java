package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.ISmall_Area_ImgsDao;
import cn.goll.entity.Small_Area_Imgs;

/**
 * 小区图片持久层实现类
 * @author LYC
 *
 */
public class Small_Area_ImgsDaoImpl implements ISmall_Area_ImgsDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteSmall_Area_Imgs(int saiId) {
		int count = 0;
		try {
			String deleteString = "delete from small_area_imgs where sai_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, saiId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertSmall_Area_Imgs(Small_Area_Imgs sai) {
		try {
			String addString = "insert into small_area_imgs values(null,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, sai.getSai_url());
			pstatement.setString(2, sai.getSai_ischeck());
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

	public List<Small_Area_Imgs> queryAllSmall_Area_Imgs(String sai_ischeck) {
		List<Small_Area_Imgs> small_Area_Imgs = new ArrayList<Small_Area_Imgs>();
		Small_Area_Imgs small_Area_Img;
		try {
			String sql = "select * from small_area_imgs";
			if(sai_ischeck!=null)
				sql+="  where sai_ischeck="+sai_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				small_Area_Img = new Small_Area_Imgs();
				small_Area_Img.setSai_id(rs.getInt("sai_id"));
				small_Area_Img.setSai_url(rs.getString("sai_url"));
				small_Area_Img.setSai_ischeck(rs.getString("sai_ischeck"));
				small_Area_Imgs.add(small_Area_Img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return small_Area_Imgs;
	}

	public Small_Area_Imgs querySmall_Area_ImgsById(int saiId,String sai_ischeck) {
		Small_Area_Imgs small_Area_Img = null; 
		try {
			String sql = "select * from small_area_imgs where sai_id=?";
			if(sai_ischeck!=null)
				sql+=" and sai_ischeck="+sai_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, saiId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				small_Area_Img = new Small_Area_Imgs();
				small_Area_Img.setSai_id(rs.getInt("sai_id"));
				small_Area_Img.setSai_url(rs.getString("sai_url"));
				small_Area_Img.setSai_ischeck(rs.getString("sai_ischeck"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return small_Area_Img;
	}

	public int updateSmall_Area_Imgs(Small_Area_Imgs sai) {
		int count = 0;
		try {
			String updString = "update small_area_imgs set sai_url=?,sai_ischeck=? where sai_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, sai.getSai_url());
			pstatement.setString(2, sai.getSai_ischeck());
			pstatement.setInt(3, sai.getSai_id());
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
