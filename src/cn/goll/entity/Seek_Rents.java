package cn.goll.entity;

import java.util.List;

/**
 * 求租表
 * @author LJ
 *
 */
public class Seek_Rents {
	int sr_id;//求租编号
	String sr_price;//求租价格
	String sr_tel;//求租电话
	String sr_ischeck;//是否审核
	int a_id;//区域编号
	String sr_infos;//求租简介
	int sa_id;//小区编号
	List<Object> list;//相关联的数据的集合
	
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	/**
	 * 求租表不带参的构造方法 
	 */
	public Seek_Rents(){
	}
	/**
	 * 求租表的带参构造方法
	 * @param srPrice 求租价格
	 * @param srTel 求租电话
	 * @param srIscheck 是否审核
	 * @param aId 区域编号 
	 */
	public Seek_Rents(String srPrice, String srTel, String srIscheck, int aId,String infos,int sa_id) {
		sr_price = srPrice;
		sr_tel = srTel;
		sr_ischeck = srIscheck;
		a_id = aId;
		this.sr_infos=infos;
		this.sa_id=sa_id;
	}
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int srId) {
		sr_id = srId;
	}
	public String getSr_price() {
		return sr_price;
	}
	public void setSr_price(String srPrice) {
		sr_price = srPrice;
	}
	public String getSr_tel() {
		return sr_tel;
	}
	public void setSr_tel(String srTel) {
		sr_tel = srTel;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	public String getSr_ischeck() {
		return sr_ischeck;
	}
	public void setSr_ischeck(String srIscheck) {
		sr_ischeck = srIscheck;
	}
	public String getSr_infos() {
		return sr_infos;
	}
	public void setSr_infos(String srInfos) {
		sr_infos = srInfos;
	}
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int saId) {
		sa_id = saId;
	}
	
}
