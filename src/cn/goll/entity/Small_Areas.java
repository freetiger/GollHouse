package cn.goll.entity;

import java.util.List;

/**
 * 小区表
 * @author LJ
 *
 */
public class Small_Areas {
	int sa_id;//小区编号
	String sa_name;//小区名
	String sa_address;//小区地址
	String sa_fishing_type;//小区装修类型
	String sa_real_company;//小区物业公司
	String sa_complete_time;//小区竣工时间
	String sa_develops;//小区开发商
	String sa_real_money;//小区物业费
	String sa_xpoint;//小区地图X坐标
	String sa_ypoint;//小区地图Y坐标
	String sa_ischeck;//小区是否被审核
	String sai_ids;//小区图片集
	int a_id;//所在区域
	List<Small_Area_Imgs> list;
	public List<Small_Area_Imgs> getList() {
		return list;
	}
	public void setList(List<Small_Area_Imgs> list) {
		this.list = list;
	}
	/**
	 * 不带参的构造方法
	 */
	public Small_Areas() {
	}
	/**
	 * 
	 * @param saName 小区名
	 * @param saAddress 小区地址
	 * @param saFishingType 小区装修类型
	 * @param saRealCompany 小区物业公司
	 * @param saCompleteTime 小区竣工时间
	 * @param saDevelops 小区开发商
	 * @param saRealMoney 小区物业费
	 * @param saXpoint 小区地图X坐标
	 * @param saYpoint 小区地图Y坐标
	 * @param saIscheck 小区是否被审核
	 * @param saiIds 小区图片集
	 * @param aId 所在区域
	 */
	public Small_Areas( String saName, String saAddress,
			String saFishingType, String saRealCompany, String saCompleteTime,
			String saDevelops, String saRealMoney, String saXpoint,
			String saYpoint, String saIscheck, String saiIds, int aId) {
		sa_name = saName;
		sa_address = saAddress;
		sa_fishing_type = saFishingType;
		sa_real_company = saRealCompany;
		sa_complete_time = saCompleteTime;
		sa_develops = saDevelops;
		sa_real_money = saRealMoney;
		sa_xpoint = saXpoint;
		sa_ypoint = saYpoint;
		sa_ischeck = saIscheck;
		sai_ids = saiIds;
		a_id = aId;
	}
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int saId) {
		sa_id = saId;
	}
	public String getSa_name() {
		return sa_name;
	}
	public void setSa_name(String saName) {
		sa_name = saName;
	}
	public String getSa_address() {
		return sa_address;
	}
	public void setSa_address(String saAddress) {
		sa_address = saAddress;
	}
	public String getSa_fishing_type() {
		return sa_fishing_type;
	}
	public void setSa_fishing_type(String saFishingType) {
		sa_fishing_type = saFishingType;
	}
	public String getSa_real_company() {
		return sa_real_company;
	}
	public void setSa_real_company(String saRealCompany) {
		sa_real_company = saRealCompany;
	}
	public String getSa_complete_time() {
		return sa_complete_time;
	}
	public void setSa_complete_time(String saCompleteTime) {
		sa_complete_time = saCompleteTime;
	}
	public String getSa_develops() {
		return sa_develops;
	}
	public void setSa_develops(String saDevelops) {
		sa_develops = saDevelops;
	}
	public String getSa_real_money() {
		return sa_real_money;
	}
	public void setSa_real_money(String saRealMoney) {
		sa_real_money = saRealMoney;
	}
	public String getSa_xpoint() {
		return sa_xpoint;
	}
	public void setSa_xpoint(String saXpoint) {
		sa_xpoint = saXpoint;
	}
	public String getSa_ypoint() {
		return sa_ypoint;
	}
	public void setSa_ypoint(String saYpoint) {
		sa_ypoint = saYpoint;
	}
	 
	public String getSa_ischeck() {
		return sa_ischeck;
	}
	public void setSa_ischeck(String saIscheck) {
		sa_ischeck = saIscheck;
	}
	public String getSai_ids() {
		return sai_ids;
	}
	public void setSai_ids(String saiIds) {
		sai_ids = saiIds;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	
}
