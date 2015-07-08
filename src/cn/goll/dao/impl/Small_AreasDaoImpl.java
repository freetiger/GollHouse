package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.ISmall_AreasDao;
import cn.goll.entity.Small_Areas;
/**
 * 小区持久层实现类
 * @author LJ
 *
 */
public class Small_AreasDaoImpl implements ISmall_AreasDao {
	DBUtil db = DBUtil.getInstance();

	public int deleteSmall_Areas(int saId) {
		String sql = "delete from small_areas where sa_id=?";
		PreparedStatement ps = db.getPrepareStatement(sql);
		try {
			ps.setInt(1, saId);
			int result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePs();
			db.closeConn();
		}
		return 0;
	}

	public boolean insertSmall_Areas(Small_Areas sa) {
		String sql = "insert into small_areas values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = db.getPrepareStatement(sql);
		try {
			ps.setString(1, sa.getSa_name());
			ps.setString(2, sa.getSa_address());
			ps.setString(3, sa.getSa_fishing_type());
			ps.setString(4, sa.getSa_real_company());
			ps.setString(5, sa.getSa_complete_time());
			ps.setString(6, sa.getSa_develops());
			ps.setString(7, sa.getSa_real_money());
			ps.setString(8, sa.getSa_xpoint());
			ps.setString(9, sa.getSa_ypoint());
			ps.setString(10, sa.getSa_ischeck());
			ps.setString(11, sa.getSai_ids());
			ps.setInt(12, sa.getA_id());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePs();
			db.closeConn();
		}
		return false;
	}

	public int updateSmall_Areas(Small_Areas sa) {
		String sql = "update small_areas set sa_name=?,sa_address=?, sa_fishing_type=?,sa_real_company=?,sa_complete_time=?,	sa_develops=?,sa_real_money=?,sa_xpoint=?,sa_ypoint=?,sa_ischeck=?,sai_ids=?,a_id=? where sa_id=? ";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setString(1, sa.getSa_name());
			ps.setString(2, sa.getSa_address());
			ps.setString(3, sa.getSa_fishing_type());
			ps.setString(4, sa.getSa_real_company());
			ps.setString(5, sa.getSa_complete_time());
			ps.setString(6, sa.getSa_develops());
			ps.setString(7, sa.getSa_real_money());
			ps.setString(8, sa.getSa_xpoint());
			ps.setString(9, sa.getSa_ypoint());
			ps.setString(10, sa.getSa_ischeck());
			ps.setString(11, sa.getSai_ids());
			ps.setInt(12, sa.getA_id());
			ps.setInt(13, sa.getSa_id());
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

	public List<Small_Areas> querySmall_Areas(String sa_ischeck) {
		String sql="select * from small_areas";
		if(sa_ischeck!=null)
			sql+="  where  sa_ischeck="+sa_ischeck;
		PreparedStatement ps=db.getPrepareStatement(sql);
		ResultSet rs;
		try {
			List<Small_Areas> list=new ArrayList<Small_Areas>();
			Small_Areas sa=null;
			rs = ps.executeQuery();
			while(rs.next()){
				sa=new Small_Areas();
				sa.setSa_id(rs.getInt("sa_id"));
				sa.setSa_name(rs.getString("sa_name"));
				sa.setSa_address(rs.getString("sa_address"));
				sa.setSa_fishing_type(rs.getString("sa_fishing_type"));
				sa.setSa_real_company(rs.getString("sa_real_company"));
				sa.setSa_complete_time(rs.getString("sa_complete_time"));
				sa.setSa_develops(rs.getString("sa_develops"));
				sa.setSa_real_money(rs.getString("sa_real_money"));
				sa.setSa_xpoint(rs.getString("sa_xpoint"));
				sa.setSa_ypoint(rs.getString("sa_ypoint"));
				sa.setSa_ischeck(rs.getString("sa_ischeck"));
				sa.setSai_ids(rs.getString("sai_ids"));
				sa.setA_id(rs.getInt("a_id"));
				list.add(sa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public List<Small_Areas> querySmall_AreasByA_id(int aId,String sa_ischeck) {
		String sql="select * from small_areas where a_id=? ";
		if(sa_ischeck!=null)
			sql+=" and  sa_ischeck="+sa_ischeck;
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1,aId);
			List<Small_Areas> list=new ArrayList<Small_Areas>();
			Small_Areas sa=null;
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				sa=new Small_Areas();
				sa.setSa_id(rs.getInt("sa_id"));
				sa.setSa_name(rs.getString("sa_name"));
				sa.setSa_address(rs.getString("sa_address"));
				sa.setSa_fishing_type(rs.getString("sa_fishing_type"));
				sa.setSa_real_company(rs.getString("sa_real_company"));
				sa.setSa_complete_time(rs.getString("sa_complete_time"));
				sa.setSa_develops(rs.getString("sa_develops"));
				sa.setSa_real_money(rs.getString("sa_real_money"));
				sa.setSa_xpoint(rs.getString("sa_xpoint"));
				sa.setSa_ypoint(rs.getString("sa_ypoint"));
				sa.setSa_ischeck(rs.getString("sa_ischeck"));
				sa.setSai_ids(rs.getString("sai_ids"));
				sa.setA_id(rs.getInt("a_id"));
				list.add(sa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public Small_Areas querySmall_AreasById(int saId,String sa_ischeck) {
		String sql="select * from small_areas where sa_id=?";
		if(sa_ischeck!=null)
			sql+="  and  sa_ischeck="+sa_ischeck;
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, saId);
			ResultSet rs=ps.executeQuery();
			Small_Areas sa=null;
			if(rs.next()){
				sa=new Small_Areas();
				sa.setSa_id(rs.getInt("sa_id"));
				sa.setSa_name(rs.getString("sa_name"));
				sa.setSa_address(rs.getString("sa_address"));
				sa.setSa_fishing_type(rs.getString("sa_fishing_type"));
				sa.setSa_real_company(rs.getString("sa_real_company"));
				sa.setSa_complete_time(rs.getString("sa_complete_time"));
				sa.setSa_develops(rs.getString("sa_develops"));
				sa.setSa_real_money(rs.getString("sa_real_money"));
				sa.setSa_xpoint(rs.getString("sa_xpoint"));
				sa.setSa_ypoint(rs.getString("sa_ypoint"));
				sa.setSa_ischeck(rs.getString("sa_ischeck"));
				sa.setSai_ids(rs.getString("sai_ids"));
				sa.setA_id(rs.getInt("a_id"));
			}
			return sa;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public List<Small_Areas> querySmall_AreasByPages(DoPage page,
			String saIscheck) {
		String sql="select * from small_areas";
		if(saIscheck!=null)
			sql+="  where  sa_ischeck="+saIscheck;
		sql+=" order by sa_id desc   limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		ResultSet rs;
		try {
			ps.setInt(1, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(2, page.getPageSize());
			List<Small_Areas> list=new ArrayList<Small_Areas>();
			Small_Areas sa=null;
			rs = ps.executeQuery();
			while(rs.next()){
				sa=new Small_Areas();
				sa.setSa_id(rs.getInt("sa_id"));
				sa.setSa_name(rs.getString("sa_name"));
				sa.setSa_address(rs.getString("sa_address"));
				sa.setSa_fishing_type(rs.getString("sa_fishing_type"));
				sa.setSa_real_company(rs.getString("sa_real_company"));
				sa.setSa_complete_time(rs.getString("sa_complete_time"));
				sa.setSa_develops(rs.getString("sa_develops"));
				sa.setSa_real_money(rs.getString("sa_real_money"));
				sa.setSa_xpoint(rs.getString("sa_xpoint"));
				sa.setSa_ypoint(rs.getString("sa_ypoint"));
				sa.setSa_ischeck(rs.getString("sa_ischeck"));
				sa.setSai_ids(rs.getString("sai_ids"));
				sa.setA_id(rs.getInt("a_id"));
				list.add(sa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public List<Small_Areas> querySmall_AreasByPagesWithA_id(int aId, DoPage page,
			String saIscheck) {
		String sql="select * from small_areas where a_id=? ";
		if(saIscheck!=null)
			sql+=" and  sa_ischeck="+saIscheck;
		sql+=" order by sa_id desc   limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1,aId);
			ps.setInt(2, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(3, page.getPageSize());
			List<Small_Areas> list=new ArrayList<Small_Areas>();
			Small_Areas sa=null;
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				sa=new Small_Areas();
				sa.setSa_id(rs.getInt("sa_id"));
				sa.setSa_name(rs.getString("sa_name"));
				sa.setSa_address(rs.getString("sa_address"));
				sa.setSa_fishing_type(rs.getString("sa_fishing_type"));
				sa.setSa_real_company(rs.getString("sa_real_company"));
				sa.setSa_complete_time(rs.getString("sa_complete_time"));
				sa.setSa_develops(rs.getString("sa_develops"));
				sa.setSa_real_money(rs.getString("sa_real_money"));
				sa.setSa_xpoint(rs.getString("sa_xpoint"));
				sa.setSa_ypoint(rs.getString("sa_ypoint"));
				sa.setSa_ischeck(rs.getString("sa_ischeck"));
				sa.setSai_ids(rs.getString("sai_ids"));
				sa.setA_id(rs.getInt("a_id"));
				list.add(sa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}
}
