package cn.goll.entity;
/**
 * 年份表
 * @author LJ
 *
 */
public class House_Years {
	int hy_id;//年份编号
	String hy_years;//年份名称
	/**
	 * 年份不带参的方法
	 */
	public House_Years() {
	}
	/**
	 * 年份带参的方法
	 * @param hyYears 年份名称
	 */
	public House_Years(String hyYears) {
		hy_years = hyYears;
	}
	public int getHy_id() {
		return hy_id;
	}
	public void setHy_id(int hyId) {
		hy_id = hyId;
	}
	public String getHy_years() {
		return hy_years;
	}
	public void setHy_years(String hyYears) {
		hy_years = hyYears;
	}
	
}
