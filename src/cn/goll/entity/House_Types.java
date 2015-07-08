package cn.goll.entity;
/**
 * 房型表
 * @author LJ
 *
 */
public class House_Types {
	int ht_id;//房型编号
	String ht_name;//房型名称
	/**
	 * 房型不带参的构造方法
	 */
	public House_Types() {
	}
	/**
	 * 房型带参的构造方法
	 * @param htName 房型名称
	 */
	public House_Types(String htName) {
		ht_name = htName;
	}
	public int getHt_id() {
		return ht_id;
	}
	public void setHt_id(int htId) {
		ht_id = htId;
	}
	public String getHt_name() {
		return ht_name;
	}
	public void setHt_name(String htName) {
		ht_name = htName;
	}
	
}
