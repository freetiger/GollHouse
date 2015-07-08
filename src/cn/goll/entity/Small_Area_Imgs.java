package cn.goll.entity;
/**
 * 小区图片表
 * @author LJ
 *
 */
public class Small_Area_Imgs {
	int sai_id;//小区图片编号
	String sai_url;//小区图片路径
	String sai_ischeck;//是否审核
	/**
	 * 小区图片表的不带参的方法
	 */
	public Small_Area_Imgs() {
	}
	/**
	 * 小区图片表的带参的方法
	 * @param saiUrl 小区图片路径
	 * @param saiIscheck 是否审核
	 */
	public Small_Area_Imgs(String saiUrl, String saiIscheck) {
		sai_url = saiUrl;
		sai_ischeck = saiIscheck;
	}

	public int getSai_id() {
		return sai_id;
	}
	public void setSai_id(int saiId) {
		sai_id = saiId;
	}
	public String getSai_url() {
		return sai_url;
	}
	public void setSai_url(String saiUrl) {
		sai_url = saiUrl;
	}
	public String getSai_ischeck() {
		return sai_ischeck;
	}
	public void setSai_ischeck(String saiIscheck) {
		sai_ischeck = saiIscheck;
	}
	
}
