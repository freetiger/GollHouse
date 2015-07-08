package cn.goll.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IAreasDao;
import cn.goll.entity.Areas;
/**
 * 区域持久层实现类
 * @author LJ
 *
 */
public class AreasDaoImpl implements IAreasDao{

	DBUtil db = DBUtil.getInstance();
	
	public int deleteAreas(int id) {
		int count = 0;
		try {
			String delString = "delete from areas where a_id=?";
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

	public int insertAreas(Areas area) {
		int count = 0;
		try {
			String addString = "insert into areas values(null,?,?,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, area.getA_name());
			pstatement.setString(2, area.getA_infos());
			pstatement.setString(3, area.getA_ischeck());
			count = db.executeUpdate(pstatement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Areas> queryAllAreas(String a_ischeck) {
		List<Areas> areas = new ArrayList<Areas>();
		Areas area;
		try {
			String sql = "select * from areas";
			if(a_ischeck!=null)
				sql+="  where a_ischeck="+a_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			ResultSet set = db.executeQuery(pstatement);
			while(set.next()){
				area = new Areas();
				area.setA_id(set.getInt("a_id"));
				area.setA_name(set.getString("a_name"));
				area.setA_infos(set.getString("a_infos"));
				area.setA_ischeck(set.getString("a_ischeck"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return areas;
	}

	public Areas queryAreasById(int id,String a_ischeck) {
		Areas area = null;
		try {
			String sql = "select * from areas where a_id=?";
			if(a_ischeck!=null)
				sql+="  and a_ischeck="+a_ischeck;
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, id);
			ResultSet set = db.executeQuery(pstatement);
			if(set.next()){
				area = new Areas();
				area.setA_id(set.getInt("a_id"));
				area.setA_name(set.getString("a_name"));
				area.setA_infos(set.getString("a_infos"));
				area.setA_ischeck(set.getString("a_ischeck"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return area;
	}

	public int updateAreas(Areas area) {
		int count = 0;
		try {
			String updString = "update areas set a_name=?,a_infos=?,a_ischeck=? where a_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, area.getA_name());
			pstatement.setString(2, area.getA_infos());
			pstatement.setString(3, area.getA_ischeck());
			pstatement.setInt(4, area.getA_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public List<Areas> selectAllAreasByPage(DoPage page, String isCheck) {
		List<Areas> areas = new ArrayList<Areas>();
		Areas area;
		try {
			String sql = "select * from areas ";
			if(isCheck!=null)
				sql+="  where a_ischeck="+isCheck;
			sql+=" limit ?,?";
			PreparedStatement pstatement = db.getPrepareStatement(sql);
			pstatement.setInt(1, (page.getCurrentPage()-1)*page.getPageSize());
			pstatement.setInt(2, page.getPageSize());
			ResultSet set = db.executeQuery(pstatement);
			while(set.next()){
				area = new Areas();
				area.setA_id(set.getInt("a_id"));
				area.setA_name(set.getString("a_name"));
				area.setA_infos(set.getString("a_infos"));
				area.setA_ischeck(set.getString("a_ischeck"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return areas;
	}

}
