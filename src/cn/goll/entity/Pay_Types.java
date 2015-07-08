package cn.goll.entity;
/**
 * 付款方式表
 * @author LJ
 *
 */
public class Pay_Types {
	int pt_id;//付款方式编号
	String pt_name;//付款方式名称
	/**
	 * 付款方式表不带参的方法
	 */
	public Pay_Types() {
	}
	/**
	 * 付款方式表带参的方法
	 * @param ptName 付款方式名称
	 */
	public Pay_Types(String ptName) {
		pt_name = ptName;
	}
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int ptId) {
		pt_id = ptId;
	}
	public String getPt_name() {
		return pt_name;
	}
	public void setPt_name(String ptName) {
		pt_name = ptName;
	}
	
}
