package cn.goll.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.goll.common.DBUtil;
import cn.goll.dao.IPay_TypesDao;
import cn.goll.entity.Pay_Types;

/**
 * 付款方式持久层实现类
 * @author LYC
 *
 */
public class Pay_TypesDaoImpl implements IPay_TypesDao{

	DBUtil db = DBUtil.getInstance();

	public int deletePay_Types(int ptId) {
		int count = 0;
		try {
			String deleteString = "delete from pay_types where pt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(deleteString);
			pstatement.setInt(1, ptId);
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public boolean insertPay_Types(Pay_Types pt) {
		try {
			String addString = "insert into pay_types values(null,?)";
			PreparedStatement pstatement = db.getPrepareStatement(addString);
			pstatement.setString(1, pt.getPt_name());
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

	public List<Pay_Types> queryAllPay_Types() {
		List<Pay_Types> pay_Types = new ArrayList<Pay_Types>();
		Pay_Types pay_Type;
		try {
			String queryString = "select * from pay_types";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			ResultSet rs = db.executeQuery(pstatement);
			while(rs.next()){
				pay_Type = new Pay_Types();
				pay_Type.setPt_id(rs.getInt("pt_id"));
				pay_Type.setPt_name(rs.getString("pt_name"));
				pay_Types.add(pay_Type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return pay_Types;
	}

	public Pay_Types queryPay_TypesById(int ptId) {
		Pay_Types pay_Type = null;
		try {
			String queryString = "select * from pay_types where pt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(queryString);
			pstatement.setInt(1, ptId);
			ResultSet rs = db.executeQuery(pstatement);
			if(rs.next()){
				pay_Type = new Pay_Types();
				pay_Type.setPt_id(rs.getInt("pt_id"));
				pay_Type.setPt_name(rs.getString("pt_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeRs();
			db.closePs();
			db.closeConn();
		}
		return pay_Type;
	}

	public int updatePay_Types(Pay_Types pt) {
		int count = 0;
		try {
			String updString = "update pay_types set pt_name=? where pt_id=?";
			PreparedStatement pstatement = db.getPrepareStatement(updString);
			pstatement.setString(1, pt.getPt_name());
			pstatement.setInt(2, pt.getPt_id());
			count = db.executeUpdate(pstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closePs();
			db.closeConn();
		}
		return count;
	}

	public int insertPay_Types() {
		String sql="insert into pay_types values(null,'无')";
		int id = 0;
		try{
			PreparedStatement ps=db.getPrepareStatementWithReturnId(sql);
			id=(int) db.executeUpdateReturnId(ps);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	
	
}
