package cn.goll.entity;
/**
 * 房源图片
 * @author LJ
 *
 */
public class House_Imgs {
	int hi_id;//图片编号
	String hi_url;//图片路径
	String hi_ischeck;//是否审核
	/**
	 * 房源图片的不带参的方法
	 */
	public House_Imgs() {
	}
	/**
	 * 房源图片的带参的方法
	 * @param hiUrl 图片路径
	 * @param hiIscheck 是否审核
	 */
	public House_Imgs(String hiUrl, String hiIscheck) {
		hi_url = hiUrl;
		hi_ischeck = hiIscheck;
	}
	public int getHi_id() {
		return hi_id;
	}
	public void setHi_id(int hiId) {
		hi_id = hiId;
	}
	public String getHi_url() {
		return hi_url;
	}
	public void setHi_url(String hiUrl) {
		hi_url = hiUrl;
	}
	public String getHi_ischeck() {
		return hi_ischeck;
	}
	public void setHi_ischeck(String hiIscheck) {
		hi_ischeck = hiIscheck;
	}
	
}
