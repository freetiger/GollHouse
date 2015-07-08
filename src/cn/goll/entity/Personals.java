package cn.goll.entity;
/**
 * 个人表
 * @author LJ
 *
 */
public class Personals {
	int per_id;//个人编号
	String per_name;//个人名字
	String per_tel;//个人电话
	String per_ischeck;//是否审核
	int h_id;//关联房源
	
	public Personals() {
	}
	/**
	 * 个人表的带参的方法
	 * @param perName 个人名称
	 * @param perTel 个人电话
	 * @param perIscheck 是否审核
	 * @param hId 关联房源
	 */
	public Personals(String perName, String perTel, String perIscheck, int hId) {
		per_name = perName;
		per_tel = perTel;
		per_ischeck = perIscheck;
		h_id = hId;
	}
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int perId) {
		per_id = perId;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String perName) {
		per_name = perName;
	}
	public String getPer_tel() {
		return per_tel;
	}
	public void setPer_tel(String perTel) {
		per_tel = perTel;
	}
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int hId) {
		h_id = hId;
	}
	public String getPer_ischeck() {
		return per_ischeck;
	}
	public void setPer_ischeck(String perIscheck) {
		per_ischeck = perIscheck;
	}
	
	
}
