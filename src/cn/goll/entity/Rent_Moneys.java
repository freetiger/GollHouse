package cn.goll.entity;
/**
 * 租金表
 * @author LJ
 *
 */
public class Rent_Moneys {
	int rm_id;//租金编号
	String rm_count;//租金数目
	/**
	 * 租金不带参的方法
	 */
	public Rent_Moneys() {
	}
	/**
	 * 租金带参的方法
	 * @param rmCount 租金数目
	 */
	public Rent_Moneys(String rmCount) {
		rm_count = rmCount;
	}
	public int getRm_id() {
		return rm_id;
	}
	public void setRm_id(int rmId) {
		rm_id = rmId;
	}
	public String getRm_count() {
		return rm_count;
	}
	public void setRm_count(String rmCount) {
		rm_count = rmCount;
	}
	
}
