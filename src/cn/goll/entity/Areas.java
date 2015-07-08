package cn.goll.entity;
/**
 * 区域
 * @author LJ
 *
 */
public class Areas {
	int a_id;//区域编号
	String a_name;//区域名
	String a_infos;//区域介绍
	String a_ischeck;//是否审核
	/**
	 * 区域不带参的构造方法
	 */
	public Areas() {
	}
	/**
	 * 区域带参的构造方法
	 * @param aName 区域名
	 * @param aInfos 区域介绍
	 * @param aIscheck 是否审核
	 */
	public Areas( String aName, String aInfos, String aIscheck) {
		a_name = aName;
		a_infos = aInfos;
		a_ischeck = aIscheck;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String aName) {
		a_name = aName;
	}
	public String getA_infos() {
		return a_infos;
	}
	public void setA_infos(String aInfos) {
		a_infos = aInfos;
	}
	public String getA_ischeck() {
		return a_ischeck;
	}
	public void setA_ischeck(String aIscheck) {
		a_ischeck = aIscheck;
	}
	
}
