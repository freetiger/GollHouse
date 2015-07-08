package cn.goll.entity;
/**
 * 房源配置表
 * @author LJ
 *
 */
public class House_Equip_Types {
	int het_id;//配置编号
	String het_name;//配置名称
	/**
	 * 房源配置表不带参的方法
	 */
	public House_Equip_Types() {
	}
	/**
	 * 房源配置表带参的方法
	 * @param hetName 配置名称
	 */
	public House_Equip_Types(String hetName) {
		het_name = hetName;
	}
	public int getHet_id() {
		return het_id;
	}
	public void setHet_id(int hetId) {
		het_id = hetId;
	}
	public String getHet_name() {
		return het_name;
	}
	public void setHet_name(String hetName) {
		het_name = hetName;
	}
	
	
}
