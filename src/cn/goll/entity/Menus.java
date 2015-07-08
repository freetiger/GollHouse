package cn.goll.entity;

import java.io.Serializable;

/**
 * 菜单表
 * @author LJ
 *
 */
public class Menus implements Serializable{//类定义的时候没有implements Serializable,会报IOException while loading persisted sessions: java.io.WriteAbortedException:
	int m_id;//菜单编号
	String m_name;//菜单名称
	String m_url;//菜单路径
	int f_id;//父级编号
	String m_isckeck;//是否审核
	/**
	 * 菜单表的不带参的方法
	 */
	public Menus() {
	}
	/**
	 * 菜单表的带参的方法
	 * @param mName 菜单名称
	 * @param mUrl 菜单路径
	 * @param fId 父级编号
	 * @param mIsckeck 是否审核
	 */
	public Menus(String mName, String mUrl, int fId, String mIsckeck) {
		m_name = mName;
		m_url = mUrl;
		f_id = fId;
		m_isckeck = mIsckeck;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int mId) {
		m_id = mId;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String mName) {
		m_name = mName;
	}
	public String getM_url() {
		return m_url;
	}
	public void setM_url(String mUrl) {
		m_url = mUrl;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int fId) {
		f_id = fId;
	}
	public String getM_isckeck() {
		return m_isckeck;
	}
	public void setM_isckeck(String mIsckeck) {
		m_isckeck = mIsckeck;
	}
	 
	
}
