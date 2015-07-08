package cn.goll.entity;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 经纪人表
 * @author LJ
 *
 */
public class Brokers {
	int b_id;//经纪人编号
	String  b_name;//经纪人名称
	String b_pwd;//经纪人密码
	String b_realname;//经纪人真实姓名
	String b_email;//经纪人邮箱
	String b_card;//经纪人身份证
	String b_head_img;//经纪人头像 
	String b_card_img;//身份证图片
	String b_business_img;//营业执照
	String b_tel;//电话
	String b_h_ids;//房源集
	String b_company;//所在公司
	String b_infos;//经纪人介绍
	String b_grade;//经纪人积分
	String b_level;//积分等级
	String b_ischeck;//是否审核
	int c_id;//中介公司
	int b_isonline;//是否在线
	/**
	 * 经纪人不带参的方法
	 */
	 public Brokers() {
	}
	/**
	  * 经纪人带参的方法
	  * @param bName 经纪人名称
	  * @param bPwd 经纪人密码
	  * @param bRealname 经纪人真实姓名
	  * @param bEmail 经纪人邮箱
	  * @param bCard 经纪人身份证
	  * @param bHeadImg 经纪人头像 
	  * @param bCardImg 身份证图片
	  * @param bBusinessImg 营业执照
	  * @param bTel  电话
	  * @param bHIds 房源集
	  * @param bCompany 所在公司
	  * @param bInfos 经纪人介绍
	  * @param bGrade 经纪人积分
	  * @param bLevel 积分等级
	  * @param bIscheck 是否审核
	  * @param cId 中介公司
	  * @param isonline 是否在线
	  */
	public Brokers(String bName, String bPwd,String bRealname ,String bEmail, String bCard,
			String bHeadImg, String bCardImg, String bBusinessImg, String bTel,
			String bHIds, String bCompany, String bInfos, String bGrade,
			String bLevel, String bIscheck, int cId,int isonline) {
		b_name = bName;
		b_pwd = bPwd;
		b_realname=bRealname;
		b_email = bEmail;
		b_card = bCard;
		b_head_img = bHeadImg;
		b_card_img = bCardImg;
		b_business_img = bBusinessImg;
		b_tel = bTel;
		b_h_ids = bHIds;
		b_company = bCompany;
		b_infos = bInfos;
		b_grade = bGrade;
		b_level = bLevel;
		b_ischeck = bIscheck;
		c_id = cId;
		this.b_isonline=isonline;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int bId) {
		b_id = bId;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String bName) {
		b_name = bName;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String bPwd) {
		b_pwd = bPwd;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String bEmail) {
		b_email = bEmail;
	}
	public String getB_card() {
		return b_card;
	}
	public void setB_card(String bCard) {
		b_card = bCard;
	}
	public String getB_head_img() {
		return b_head_img;
	}
	public void setB_head_img(String bHeadImg) {
		b_head_img = bHeadImg;
	}
	public String getB_card_img() {
		return b_card_img;
	}
	public void setB_card_img(String bCardImg) {
		b_card_img = bCardImg;
	}
	public String getB_business_img() {
		return b_business_img;
	}
	public void setB_business_img(String bBusinessImg) {
		b_business_img = bBusinessImg;
	}
	public String getB_tel() {
		return b_tel;
	}
	public void setB_tel(String bTel) {
		b_tel = bTel;
	}
	public String getB_h_ids() {
		return b_h_ids;
	}
	public void setB_h_ids(String bHIds) {
		b_h_ids = bHIds;
	}
	public String getB_company() {
		return b_company;
	}
	public void setB_company(String bCompany) {
		b_company = bCompany;
	}
	public String getB_infos() {
		return b_infos;
	}
	public void setB_infos(String bInfos) {
		b_infos = bInfos;
	}
	public String getB_grade() {
		return b_grade;
	}
	public void setB_grade(String bGrade) {
		b_grade = bGrade;
	}
	public String getB_level() {
		return b_level;
	}
	public void setB_level(String bLevel) {
		b_level = bLevel;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public String getB_realname() {
		return b_realname;
	}
	public void setB_realname(String bRealname) {
		b_realname = bRealname;
	}
	public String getB_ischeck() {
		return b_ischeck;
	}
	public void setB_ischeck(String bIscheck) {
		b_ischeck = bIscheck;
	}
	public int getB_isonline() {
		return b_isonline;
	}
	public void setB_isonline(int bIsonline) {
		b_isonline = bIsonline;
	}

	public static void main(String[] args) {
		String pwd=DigestUtils.md5Hex((DigestUtils.md5Hex(String.valueOf("111111"))+"773924231@qq.com"));
		System.out.println(pwd);
	}
}
