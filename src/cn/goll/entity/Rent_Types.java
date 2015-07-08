package cn.goll.entity;
/**
 * 出租类型表
 * @author LJ
 *
 */
public class Rent_Types {
	int rt_id;//出租类型编号
	String rt_name;//出租类型名称
	/**
	 * 出租类型表不带参的方法
	 */
	public Rent_Types() {
	}
	/**
	 * 出租类型表带参的方法
	 * @param rtName 出租类型名称
	 */
	public Rent_Types(String rtName) {
		rt_name = rtName;
	}
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rtId) {
		rt_id = rtId;
	}
	public String getRt_name() {
		return rt_name;
	}
	public void setRt_name(String rtName) {
		rt_name = rtName;
	}
	
}
