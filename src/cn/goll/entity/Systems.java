package cn.goll.entity;
/**
 * 系统表
 * @author LJ
 *
 */
public class Systems {
	int sys_id;//系统编号
	String sys_name;//系统名
	String sys_dns;//系统域名
	String sys_counts;//系统交易量
	String sys_tag;//系统关键字
	String sys_logo;//系统logo
	String sys_infos;//系统介绍
	String sys_tel;//网站联系电话
	String sys_date;//网站建成时间
	String sys_qq;//网站联系QQ 
	/**
	 * 系统表不带参的构造方法
	 */
	public Systems() {
	}
	/**
	 * 系统表带参的构造方法
	 * @param sysName 系统名
	 * @param sysDns 系统域名
	 * @param sysCounts 系统交易量
	 * @param sysTag 系统关键字
	 * @param sysLogo 系统logo
	 * @param sysInfos 系统介绍
	 * @param sysTel 网站联系电话
	 * @param sysDate 网站建成时间
	 * @param sysQq 网站联系QQ 
	 */
	public Systems(String sysName, String sysDns, String sysCounts,
			String sysTag, String sysLogo, String sysInfos, String sysTel,
			String sysDate, String sysQq) {
		sys_name = sysName;
		sys_dns = sysDns;
		sys_counts = sysCounts;
		sys_tag = sysTag;
		sys_logo = sysLogo;
		sys_infos = sysInfos;
		sys_tel = sysTel;
		sys_date = sysDate;
		sys_qq = sysQq;
	}
	public int getSys_id() {
		return sys_id;
	}
	public void setSys_id(int sysId) {
		sys_id = sysId;
	}
	public String getSys_name() {
		return sys_name;
	}
	public void setSys_name(String sysName) {
		sys_name = sysName;
	}
	public String getSys_dns() {
		return sys_dns;
	}
	public void setSys_dns(String sysDns) {
		sys_dns = sysDns;
	}
	public String getSys_counts() {
		return sys_counts;
	}
	public void setSys_counts(String sysCounts) {
		sys_counts = sysCounts;
	}
	public String getSys_tag() {
		return sys_tag;
	}
	public void setSys_tag(String sysTag) {
		sys_tag = sysTag;
	}
	public String getSys_logo() {
		return sys_logo;
	}
	public void setSys_logo(String sysLogo) {
		sys_logo = sysLogo;
	}
	public String getSys_infos() {
		return sys_infos;
	}
	public void setSys_infos(String sysInfos) {
		sys_infos = sysInfos;
	}
	public String getSys_tel() {
		return sys_tel;
	}
	public void setSys_tel(String sysTel) {
		sys_tel = sysTel;
	}
	public String getSys_date() {
		return sys_date;
	}
	public void setSys_date(String sysDate) {
		sys_date = sysDate;
	}
	public String getSys_qq() {
		return sys_qq;
	}
	public void setSys_qq(String sysQq) {
		sys_qq = sysQq;
	}
	
}
