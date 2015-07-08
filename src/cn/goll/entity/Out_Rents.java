package cn.goll.entity;
/**
 * 出租表
 * @author LJ
 *
 */
public class Out_Rents {
	int or_id;//出租编号
	String or_ischeck;//是否审核
	int rt_id;//出租方式
	int h_id;//房源编号
	int sa_id;//小区编号
	int a_id;//区域编号
	/**
	 * 出租表不带参的构造方法
	 */
	public Out_Rents(){
		
	}
	/**
	 * 出租表的带参构造方法
	 * @param orIscheck 是否审核
	 * @param rtId 出租方式
	 * @param hId 房源编号
	 * @param saId 小区编号
	 */
	public Out_Rents(String orIscheck, int rtId, int hId, int saId,int a_id) {
		or_ischeck = orIscheck;
		rt_id = rtId;
		h_id = hId;
		sa_id = saId;
		this.a_id=a_id;
	}
	public int getOr_id() {
		return or_id;
	}
	public void setOr_id(int orId) {
		or_id = orId;
	}
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rtId) {
		rt_id = rtId;
	}
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int hId) {
		h_id = hId;
	}
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int saId) {
		sa_id = saId;
	}
	public String getOr_ischeck() {
		return or_ischeck;
	}
	public void setOr_ischeck(String orIscheck) {
		or_ischeck = orIscheck;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	
}
