package cn.goll.entity;
/**
 * 用户表
 * @author LJ
 *
 */
public class Managers {
	int id;//用户编号
	String uname;//用户名
	String pwd;//密码
	int p_id;//权限
	String ischeck;//是否审核 
	String p_name;//权限名
	int isonline;//是否在线
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String pName) {
		p_name = pName;
	}
	/**
	 * 用户的不带参方法
	 */
	public Managers() {
	}
	/**
	 * 用户的带参方法
	 * @param uname 用户名
	 * @param pwd 密码
	 * @param pId 权限
	 * @param ischeck 是否审核
	 */
	public Managers(String uname, String pwd, int pId, String ischeck,int isonline) {
		this.uname = uname;
		this.pwd = pwd;
		p_id = pId;
		this.ischeck = ischeck;
		this.isonline=isonline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public int getIsonline() {
		return isonline;
	}
	public void setIsonline(int isonline) {
		this.isonline = isonline;
	}
	
}
