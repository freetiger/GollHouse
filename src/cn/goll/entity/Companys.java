package cn.goll.entity;
/**
 * 中介公司
 * @author LJ
 *
 */
public class Companys {
	int c_id;//中介公司编号
	String c_name;//公司名
	String c_complete_year;//成立年份
	String c_address;//公司地址
	String c_img;//公司图片
	String c_ischeck;//公司是否被审核
	String c_infos;//公司介绍
	/**
	 * 中介公司不带参方法
	 */
	public Companys(){
		
	}
	/**
	 * 中介公司的带参方法
	 * @param cName 公司名
	 * @param cCompleteYear 成立年份
	 * @param cAddress 公司地址
	 * @param cImg 公司图片
	 * @param cIscheck 公司是否被审核
	 * @param cInfos 公司介绍
	 */
	public Companys(String cName, String cCompleteYear, String cAddress,
			String cImg, String cIscheck, String cInfos) {
		c_name = cName;
		c_complete_year = cCompleteYear;
		c_address = cAddress;
		c_img = cImg;
		c_ischeck = cIscheck;
		c_infos = cInfos;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String cName) {
		c_name = cName;
	}
	public String getC_complete_year() {
		return c_complete_year;
	}
	public void setC_complete_year(String cCompleteYear) {
		c_complete_year = cCompleteYear;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String cAddress) {
		c_address = cAddress;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String cImg) {
		c_img = cImg;
	}
	public String getC_infos() {
		return c_infos;
	}
	public void setC_infos(String cInfos) {
		c_infos = cInfos;
	}
	public String getC_ischeck() {
		return c_ischeck;
	}
	public void setC_ischeck(String cIscheck) {
		c_ischeck = cIscheck;
	}
	
}
