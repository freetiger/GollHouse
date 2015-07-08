package cn.goll.entity;
/**
 * 历史记录表
 * @author LJ
 *
 */
public class Historys {
	int his_id;//记录编号
	int his_b_id;//经纪人编号,为null则表示不是经纪人操作
	int his_manager_id;//管理员编号,为null则表示不是管理员操作
	String his_do_name;//操作员
	String his_do_actions;//操作动作
	String his_do_event;//操作对象或事件
	String his_date;//操作时间
	/**
	 * 历史记录表不带参的构造方法
	 */
	public Historys() {
	}
	/**
	 * 历史记录表带参的构造方法
	 * @param hisBId 经纪人编号,为null则表示不是经纪人操作
	 * @param hisManagerId 管理员编号,为null则表示不是管理员操作
	 * @param hisDoName 操作员
	 * @param hisDoActions 操作动作
	 * @param hisDoEvent 操作对象或事件
	 * @param hisDate 操作时间
	 */
	public Historys(int hisBId, int hisManagerId, String hisDoName,
			String hisDoActions, String hisDoEvent, String hisDate) {
		his_b_id = hisBId;
		his_manager_id = hisManagerId;
		his_do_name = hisDoName;
		his_do_actions = hisDoActions;
		his_do_event = hisDoEvent;
		his_date = hisDate;
	}
	public int getHis_id() {
		return his_id;
	}
	public void setHis_id(int hisId) {
		his_id = hisId;
	}
	public int getHis_b_id() {
		return his_b_id;
	}
	public void setHis_b_id(int hisBId) {
		his_b_id = hisBId;
	}
	public int getHis_manager_id() {
		return his_manager_id;
	}
	public void setHis_manager_id(int hisManagerId) {
		his_manager_id = hisManagerId;
	}
	public String getHis_do_name() {
		return his_do_name;
	}
	public void setHis_do_name(String hisDoName) {
		his_do_name = hisDoName;
	}
	public String getHis_do_actions() {
		return his_do_actions;
	}
	public void setHis_do_actions(String hisDoActions) {
		his_do_actions = hisDoActions;
	}
	public String getHis_do_event() {
		return his_do_event;
	}
	public void setHis_do_event(String hisDoEvent) {
		his_do_event = hisDoEvent;
	}
	public String getHis_date() {
		return his_date;
	}
	public void setHis_date(String hisDate) {
		his_date = hisDate;
	}
	
	
}
