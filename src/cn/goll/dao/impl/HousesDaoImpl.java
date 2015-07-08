package cn.goll.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.common.DoPage;
import cn.goll.dao.IBrokersDao;
import cn.goll.dao.IHousesDao;
import cn.goll.dao.IPersonalsDao;
import cn.goll.entity.Brokers;
import cn.goll.entity.Houses;
import cn.goll.entity.Personals;
/**
 * 房源持久层实现类
 * @author LJ
 *
 */
public class HousesDaoImpl implements IHousesDao {
	DBUtil db=DBUtil.getInstance();
	public int deleteHouses(int hId) {
		String sql="delete from houses where h_id=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, hId);
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

	public long insertHouses(Houses house) {
		String sql="insert into houses values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setString(1, house.getH_number());
			ps.setString(2, house.getH_publictime());
			ps.setString(3, house.getH_name());
			ps.setString(4, house.getH_price());
			ps.setString(5, house.getH_proportion());
			ps.setString(6, house.getH_floor());
			ps.setString(7, house.getH_all_floor());
			ps.setString(8, house.getH_infos());
			ps.setInt(9, house.getH_ischarge());
			ps.setInt(10, house.getH_relevance_id());
			ps.setString(11, house.getH_hi_ids());
			ps.setString(12, house.getH_title());
			ps.setString(13, house.getH_tag());
			ps.setString(14, house.getH_ischeck());
			ps.setString(15, house.getH_xpoint());
			ps.setString(16, house.getH_ypoint());
			ps.setString(17, house.getH_isrent());
			ps.setString(18, house.getHet_ids());
			ps.setInt(19, house.getH_isup());
			ps.setString(20,house.getH_date());
			ps.setInt(21, house.getPt_id());
			ps.setInt(22, house.getHt_id());
			ps.setInt(23, house.getRt_id());
			long result=db.executeUpdateReturnId(ps);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}

	public int updateHouses(Houses house) {
		String sql="update houses set h_number=?,h_publictime=?,h_name=?,h_price=?,h_proportion=?,h_floor=?,h_all_floor=?,h_infos=?,h_ischarge=?,h_relevance_id=?,h_hi_ids=?,h_title=?,h_tag=?,h_ischeck=?,h_xpoint=?,h_ypoint=?,h_isrent=?,het_ids=?,h_isup=?,h_date=?,pt_id=?,ht_id=?,rt_id=? where h_id=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try{
			ps.setString(1, house.getH_number());
			ps.setString(2, house.getH_publictime());
			ps.setString(3, house.getH_name());
			ps.setString(4, house.getH_price());
			ps.setString(5, house.getH_proportion());
			ps.setString(6, house.getH_floor());
			ps.setString(7, house.getH_all_floor());
			ps.setString(8, house.getH_infos());
			ps.setInt(9, house.getH_ischarge());
			ps.setInt(10, house.getH_relevance_id());
			ps.setString(11, house.getH_hi_ids());
			ps.setString(12, house.getH_title());
			ps.setString(13, house.getH_tag());
			ps.setString(14, house.getH_ischeck());
			ps.setString(15, house.getH_xpoint());
			ps.setString(16, house.getH_ypoint());
			ps.setString(17, house.getH_isrent());
			ps.setString(18, house.getHet_ids());
			ps.setInt(19, house.getH_isup());
			ps.setString(20, house.getH_date());
			ps.setInt(21, house.getPt_id());
			ps.setInt(22, house.getHt_id());
			ps.setInt(23, house.getRt_id());
			ps.setInt(24, house.getH_id());
			int result=ps.executeUpdate();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}
	
	public List<Houses> queryAllHouses(String h_ischeck) {
		String sql="select * from houses";
		if(!h_ischeck.equals("null"))
			sql+=" where  h_ischeck="+h_ischeck;
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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
	public Houses queryHousesById(int hId,String h_ischeck) {
		String sql="select * from houses where h_id=?";
		if(h_ischeck!=null)
			sql+="  and h_ischeck="+h_ischeck;
		PreparedStatement ps=db.getPrepareStatement(sql);
		Houses house=null;
		try {
			ps.setInt(1, hId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(hId);
			}
			return house;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public List<Houses> queryAllHouses(DoPage pager) {
		String sql="select * from houses order by  h_id desc limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1,(pager.getCurrentPage()-1)*pager.getPageSize());
			ps.setInt(2, pager.getPageSize());
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryAllHouses(String h_ischeck, DoPage pager) {
		String sql="select * from houses";
		if(h_ischeck!=null)
			sql+=" where  h_ischeck="+h_ischeck;
		sql+=" order by  h_id desc limit ?,?";
		try {
		PreparedStatement ps=db.getPrepareStatement(sql);
		ps.setInt(1,(pager.getCurrentPage()-1)*pager.getPageSize());
		ps.setInt(2, pager.getPageSize());
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryAllHouses(int h_ischarge, DoPage pager) {
		String sql="select * from houses where h_ischarge=? and h_isrent=0 order by  h_id desc limit ?,?";
		try {
		PreparedStatement ps=db.getPrepareStatement(sql);
		ps.setInt(1,h_ischarge);
		ps.setInt(2,(pager.getCurrentPage()-1)*pager.getPageSize());
		ps.setInt(3, pager.getPageSize());
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryAllHouses(int h_ischarge) {
		String sql="select * from houses where h_ischarge=? and h_isrent=0";
		try {
		PreparedStatement ps=db.getPrepareStatement(sql);
		ps.setInt(1,h_ischarge);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryAllHouses() {
		String sql="select * from houses";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public Houses selectHousesById(int h_id) {
		String sql="select * from houses h,pay_types p,house_types ht,rent_types rt ";
		sql+="where h_id=? and h.pt_id=p.pt_id and h.ht_id=ht.ht_id and h.rt_id=rt.rt_id";
		
		PreparedStatement ps=db.getPrepareStatement(sql);
		Houses house=null;
		List<Object> list=null;
		try {
			ps.setInt(1, h_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(h_id);
				list=new ArrayList<Object>();
				list.add(rs.getString("ht_name"));//房源的类型‘如三室一厅’
				list.add(rs.getString("pt_name"));//付款方式
				list.add(rs.getString("rt_name"));//出租方式
				//查找发布人
				if(rs.getInt("h_ischarge")==0){//个人发布
					IPersonalsDao p=new PersonalsDaoImpl();
					Personals personal=p.queryPersonalsById(rs.getInt("h_relevance_id"), null);
					list.add(personal);
				}
				if(rs.getInt("h_ischarge")==1){
					IBrokersDao bdao=new BrokersDaoImpl();
					Brokers broker=bdao.queryBrokersById(rs.getInt("h_relevance_id"), null);
					list.add(broker);
				}
				house.setList(list);
			}
			return house;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return null;
	}

	public int updateHousesCheck(String check,int hId) {
		int lines=0;
		String sql="update houses set h_ischeck=? where h_id=?";
		try{
			PreparedStatement ps=db.getPrepareStatement(sql);
			ps.setString(1, check);
			ps.setInt(2, hId);
			lines=ps.executeUpdate();
		}catch(Exception e){
			
		}finally{
			db.closePs();
			db.closeConn();
		}
		return lines;
	}

	public List<Houses> selectHousesBySa_id(int saId,int isCharge,String ischeck) {
		String sql="select * from houses h,out_rents o,small_areas s " +
				"where h.h_ischarge=? and s.sa_id=o.sa_id and o.h_id=h.h_id and s.sa_id=?";
		if(ischeck!=null)
			sql+=" and h_ischeck="+ischeck;
		try {
			PreparedStatement ps=db.getPrepareStatement(sql);
			ps.setInt(1,isCharge);
			ps.setInt(2, saId);
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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
	
	public List<Houses> selectHousesBySa_idWithPages(int saId,int isCharge,DoPage page,String ischeck) {
		String sql="select * from houses h,out_rents o,small_areas s " +
				"where h.h_ischarge=? and s.sa_id=o.sa_id and o.h_id=h.h_id and s.sa_id=?";
		if(ischeck!=null)
			sql+=" and h_ischeck="+ischeck;
		sql+=" limit ?,?";
		try {
			PreparedStatement ps=db.getPrepareStatement(sql);
			ps.setInt(1,isCharge);
			ps.setInt(2, saId);
			ps.setInt(3, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(4, page.getPageSize());
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> selectHouses(int hIscharge, int hRelevanceId,	String ischeck) {
		String sql="select * from houses where h_ischarge=? and h_relevance_id=? and h_ischeck=? order by  h_id desc";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1,hIscharge);
			ps.setInt(2,hRelevanceId);
			ps.setString(3, ischeck);
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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
	
	public List<Houses> selectHouses(int hIscharge, int hRelevanceId,	String ischeck,DoPage page) {
		String sql="select * from houses where h_ischarge=? and h_relevance_id=? and h_ischeck=? order by  h_id desc limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1,hIscharge);
			ps.setInt(2,hRelevanceId);
			ps.setString(3, ischeck);
			ps.setInt(4, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(5, page.getPageSize());
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByIsup(int isup) {
		String sql="select * from houses where h_isup=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, isup);
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByIsupAndtime(int isup) {
		String sql="select * from houses where h_isup=? order by  h_date desc";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, isup);
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			int num=0;
			while(rs.next()&&num++<5){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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
	public int addHouses(Houses house) {
		String sql="insert into houses values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=db.getPrepareStatementWithReturnId(sql);
		try {
			ps.setString(1, house.getH_number());
			ps.setString(2, house.getH_publictime());
			ps.setString(3, house.getH_name());
			ps.setString(4, house.getH_price());
			ps.setString(5, house.getH_proportion());
			ps.setString(6, house.getH_floor());
			ps.setString(7, house.getH_all_floor());
			ps.setString(8, house.getH_infos());
			ps.setInt(9, house.getH_ischarge());
			ps.setInt(10, house.getH_relevance_id());
			ps.setString(11, house.getH_hi_ids());
			ps.setString(12, house.getH_title());
			ps.setString(13, house.getH_tag());
			ps.setString(14, house.getH_ischeck());
			ps.setString(15, house.getH_xpoint());
			ps.setString(16, house.getH_ypoint());
			ps.setString(17, house.getH_isrent());
			ps.setString(18, house.getHet_ids());
			ps.setInt(19, house.getH_isup());
			ps.setString(20,house.getH_date());
			ps.setInt(21, house.getPt_id());
			ps.setInt(22, house.getHt_id());
			ps.setInt(23, house.getRt_id());
			return (int) db.executeUpdateReturnId(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return 0;
	}

	public int updateHouses(int id, int hRelevanceId) {
		int lines=0;
		String sql="update houses set h_relevance_id=? where h_id=?";
		try{
			PreparedStatement ps=db.getPrepareStatement(sql);
			ps.setInt(1, hRelevanceId);
			ps.setInt(2, id);
			lines=ps.executeUpdate();
		}catch(Exception e){
			
		}finally{
			db.closePs();
			db.closeConn();
		}
		return lines;
	}

	public List<Houses> queryHousesBySql(String sql) {
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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
	
	public List<Houses> queryHousesBySqlWithPage(String sql,DoPage page) {
		sql+=" limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(2, page.getPageSize());
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public String queryHousesAllTag() {
		String sql="select distinct h_tag from houses";
		PreparedStatement ps=db.getPrepareStatement(sql);
		String tags="";
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				tags+=rs.getString("h_tag")+",";
			}
			return tags;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return tags;
	}

	public List<Houses> queryHousesByTag(String tag) {
		String sql="select * from houses where h.h_ischeck=1 and h_tag=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setString(1, tag);
			List<Houses> list=new ArrayList<Houses>();
			Houses house=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByC_id(int cId) {
		String sql="select distinct * from houses h,brokers b where h.h_ischeck=1 and b.b_id=h.h_relevance_id and h.h_ischarge=1 and c_id=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, cId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByC_idWithPage(int cId, DoPage page) {
		String sql="select distinct * from houses h,brokers b where b.b_id=h.h_relevance_id and h.h_ischeck=1 and h.h_ischarge=1 and c_id=? limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, cId);
			ps.setInt(2, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(3, page.getPageSize());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesBySa_id(int saId) {
		String sql="select distinct * from houses h,out_rents ors,small_areas sa where ors.h_id=h.h_id and ors.sa_id=sa.sa_id and h.h_ischeck=1 and ors.sa_id=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, saId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByB_id(int bId) {
		String sql="select distinct * from houses h,brokers b where h.h_ischeck=1 and b.b_id=h.h_relevance_id and h.h_ischarge=1 and b_id=?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, bId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesByB_idWithPage(int bId, DoPage page) {
		String sql="select distinct * from houses h,brokers b where h.h_ischeck=1 and b.b_id=h.h_relevance_id and h.h_ischarge=1 and b_id=? limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, bId);
			ps.setInt(2, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(3, page.getPageSize());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHousesBySa_idWithPage(int saId, DoPage page) {
		String sql="select distinct * from houses h,out_rents ors,small_areas sa where ors.h_id=h.h_id and ors.sa_id=sa.sa_id and h.h_ischeck=1 and ors.sa_id=? limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		List<Houses> list=new ArrayList<Houses>();
		Houses house=null;
		try {
			ps.setInt(1, saId);
			ps.setInt(2, (page.getCurrentPage()-1)*page.getPageSize());
			ps.setInt(3, page.getPageSize());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				list.add(house);
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

	public List<Houses> queryHouseBybid(int hRelevanceId, String ischeck,DoPage pager) {
		String sql="select * from houses h,rent_types rt where h_relevance_id=? and h_ischeck=? and h.rt_id=rt.rt_id limit ?,?";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, hRelevanceId);
			ps.setString(2, ischeck);
			ps.setInt(3,(pager.getCurrentPage()-1)*pager.getPageSize());
			ps.setInt(4, pager.getPageSize());
			ResultSet rs=ps.executeQuery();
			List<Houses> list=new ArrayList<Houses>();
			List<Object> olist=null;
			Houses house=null;
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				olist=new ArrayList<Object>();
				olist.add(rs.getString("rt_name"));//出租方式
				house.setList(olist);
				list.add(house);
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

	public List<Houses> queryHouseBybid(int hRelevanceId, String ischeck) {
		String sql="select * from houses h,rent_types rt where h_relevance_id=? and h_ischeck=? and h.rt_id=rt.rt_id ";
		PreparedStatement ps=db.getPrepareStatement(sql);
		try {
			ps.setInt(1, hRelevanceId);
			ps.setString(2, ischeck);
			ResultSet rs=ps.executeQuery();
			List<Houses> list=new ArrayList<Houses>();
			List<Object> olist=null;
			Houses house=null;
			while(rs.next()){
				house=new Houses();
				house.setH_number(rs.getString("h_number"));
				house.setH_publictime(rs.getString("h_publictime"));
				house.setH_name(rs.getString("h_name"));
				house.setH_price(rs.getString("h_price"));
				house.setH_proportion(rs.getString("h_proportion"));
				house.setH_floor(rs.getString("h_floor"));
				house.setH_all_floor(rs.getString("h_all_floor"));
				house.setH_infos(rs.getString("h_infos"));
				house.setH_ischarge(rs.getInt("h_ischarge"));
				house.setH_relevance_id(rs.getInt("h_relevance_id"));
				house.setH_hi_ids(rs.getString("h_hi_ids"));
				house.setH_title(rs.getString("h_title"));
				house.setH_tag(rs.getString("h_tag"));
				house.setH_ischeck(rs.getString("h_ischeck"));
				house.setH_xpoint(rs.getString("h_xpoint"));
				house.setH_ypoint(rs.getString("h_ypoint"));
				house.setH_isrent(rs.getString("h_isrent"));
				house.setHet_ids(rs.getString("het_ids"));
				house.setH_isup(rs.getInt("h_isup"));
				house.setH_date(rs.getString("h_date"));
				house.setPt_id(rs.getInt("pt_id"));
				house.setHt_id(rs.getInt("ht_id"));
				house.setRt_id(rs.getInt("rt_id"));
				house.setH_id(rs.getInt("h_id"));
				olist=new ArrayList<Object>();
				olist.add(rs.getString("rt_name"));//出租方式
				house.setList(olist);
				list.add(house);
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
