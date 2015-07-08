package cn.goll.entity;
/**
 * 权限表
 * @author LJ
 *
 */
public class Powers {
	int p_id;//权限编号
	String p_name;//权限名称
	String p_menus;//菜单集
	/**
	 * 权限表不带参的方法
	 */
	public Powers() {
	}
	/**
	 * 权限表带参的方法
	 * @param pName 权限名称
	 * @param pMenus 菜单集
	 */
	public Powers(String pName, String pMenus) {
		p_name = pName;
		p_menus = pMenus;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String pName) {
		p_name = pName;
	}
	public String getP_menus() {
		return p_menus;
	}
	public void setP_menus(String pMenus) {
		p_menus = pMenus;
	}
	
}
