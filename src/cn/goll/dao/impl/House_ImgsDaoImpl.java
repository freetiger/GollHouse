package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IHouse_ImgsDao;
import cn.goll.entity.House_Imgs;

/**
 * 房源图片持久层实现类
 * @author LYC
 *
 */
public class House_ImgsDaoImpl implements IHouse_ImgsDao{

	DBUtil db = DBUtil.getInstance();

	public int deleteHouse_Imgs(int hiId) {
		int count = 0;
		try {
			String deleteString = "delete from house_imgs where hi_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, hiId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public long insertHouse_Imgs(House_Imgs hi) {
		try {
			String addString = "insert into house_imgs values(null,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, hi.getHi_url());
			pstatement.setString(2, hi.getHi_ischeck());
			long id=db.executeUpdateReturnId(pstatement);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}

	public List<House_Imgs> queryAllHouse_Imgs(String  hi_ischeck) {
		List<House_Imgs> house_Imgs = new ArrayList<House_Imgs>();
		House_Imgs house_Img;
		try {
			String sql = "select * from house_imgs";
			if(hi_ischeck!=null)
				sql+=" where hi_ischeck="+hi_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				house_Img = new House_Imgs();
				house_Img.setHi_id(rs.getInt("hi_id"));
				house_Img.setHi_url(rs.getString("hi_url"));
				house_Img.setHi_ischeck(rs.getString("hi_ischeck"));
				house_Imgs.add(house_Img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Imgs;
	}

	public House_Imgs queryHouse_ImgsById(int hiId,String hi_ischeck) {
		House_Imgs house_Img = null;
		try {
			String sql = "select * from house_imgs where hi_id=?";
			if(hi_ischeck!=null)
				sql+="  and hi_ischeck="+hi_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, hiId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				house_Img = new House_Imgs();
				house_Img.setHi_id(rs.getInt("hi_id"));
				house_Img.setHi_url(rs.getString("hi_url"));
				house_Img.setHi_ischeck(rs.getString("hi_ischeck"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return house_Img;
	}

	public int updateHouse_Imgs(House_Imgs hi) {
		int count = 0;
		try {
			String updString = "update house_imgs set hi_url=?,hi_ischeck=? where rm_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, hi.getHi_url());
			pstatement.setString(2, hi.getHi_ischeck());
			pstatement.setInt(3, hi.getHi_id());
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
