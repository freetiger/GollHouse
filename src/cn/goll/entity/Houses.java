package cn.goll.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 房源表
 * @author LJ
 *
 */
public class Houses {
	int h_id;//房源id
	String h_number;//房源编号
	String h_publictime;//发布日期
	String h_name;//房源名
	String h_price;//房源租金
	String h_proportion;//房源面积
	String h_floor;//当前楼层
	String h_all_floor;//总共楼层
	String h_infos;//房源介绍
	int h_ischarge;//是否是个人，0代表是，1代表是经纪人
	int h_relevance_id;//关联操作人编号
	String h_hi_ids;//房源图片集
	String h_title;//房源标题
	String h_tag;//房源标签
	String h_ischeck;//是否审核
	String h_xpoint;//房源x坐标
	String h_ypoint;//房源y坐标
	String h_isrent;//是否已经出租
	String het_ids;//房源配置
	int h_isup;//是否置顶
	String h_date;//置顶时间
	int pt_id;//付款方式
	int ht_id;//房源类型
	int rt_id;//出租方式
	List<Object> list;//用于装相关联的的集合
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	/**
	 * 房源不带参的构造方法
	 */
	public Houses() {
	}
	/**
	 * 房源带参的构造方法
	 * @param h_number 房源编号
	 * @param h_publictime 发布日期
	 * @param hName 房源名
	 * @param hPrice 房源租金
	 * @param hProportion 房源面积
	 * @param hFloor 当前楼层
	 * @param hAllFloor 总共楼层
	 * @param hInfos 房源介绍
	 * @param hIscharge 是否是个人，0代表是，1代表是经纪人
	 * @param hRelevanceId 关联操作人编号
	 * @param hHiIds 房源图片集
	 * @param hTitle 房源标题
	 * @param hTag 房源标签
	 * @param hIscheck 是否审核
	 * @param hXpoint 房源x坐标
	 * @param hYpoint 房源y坐标
	 * @param hIsrent 是否已经出租
	 * @param hetIds 房源配置
	 * @param ptId 付款方式
	 * @param htId 房源类型
	 * @param rtId 出租方式
	 */
	public Houses(String hNumber,String hPublictime,String hName, String hPrice, String hProportion,
			String hFloor, String hAllFloor, String hInfos, int hIscharge,
			int hRelevanceId, String hHiIds, String hTitle, String hTag,
			String hIscheck, String hXpoint, String hYpoint, String hIsrent,
			String hetIds,int isup,String date, int ptId, int htId, int rtId) {
		h_number=hNumber;
		h_publictime=hPublictime;
		h_name = hName;
		h_price = hPrice;
		h_proportion = hProportion;
		h_floor = hFloor;
		h_all_floor = hAllFloor;
		h_infos = hInfos;
		h_ischarge = hIscharge;
		h_relevance_id = hRelevanceId;
		h_hi_ids = hHiIds;
		h_title = hTitle;
		h_tag = hTag;
		h_ischeck = hIscheck;
		h_xpoint = hXpoint;
		h_ypoint = hYpoint;
		h_isrent = hIsrent;
		het_ids = hetIds;
		pt_id = ptId;
		ht_id = htId;
		rt_id = rtId;
		h_isup=isup;
		h_date=date;
	}
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int hId) {
		h_id = hId;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String hName) {
		h_name = hName;
	}
	public String getH_price() {
		return h_price;
	}
	public void setH_price(String hPrice) {
		h_price = hPrice;
	}
	public String getH_proportion() {
		return h_proportion;
	}
	public void setH_proportion(String hProportion) {
		h_proportion = hProportion;
	}
	public String getH_floor() {
		return h_floor;
	}
	public void setH_floor(String hFloor) {
		h_floor = hFloor;
	}
	public String getH_all_floor() {
		return h_all_floor;
	}
	public void setH_all_floor(String hAllFloor) {
		h_all_floor = hAllFloor;
	}
	public String getH_infos() {
		return h_infos;
	}
	public void setH_infos(String hInfos) {
		h_infos = hInfos;
	}
	public int getH_ischarge() {
		return h_ischarge;
	}
	public void setH_ischarge(int hIscharge) {
		h_ischarge = hIscharge;
	}
	public int getH_relevance_id() {
		return h_relevance_id;
	}
	public void setH_relevance_id(int hRelevanceId) {
		h_relevance_id = hRelevanceId;
	}
	public String getH_hi_ids() {
		return h_hi_ids;
	}
	public void setH_hi_ids(String hHiIds) {
		h_hi_ids = hHiIds;
	}
	public String getH_title() {
		return h_title;
	}
	public void setH_title(String hTitle) {
		h_title = hTitle;
	}
	public String getH_tag() {
		return h_tag;
	}
	public void setH_tag(String hTag) {
		h_tag = hTag;
	}
	public String getH_xpoint() {
		return h_xpoint;
	}
	public void setH_xpoint(String hXpoint) {
		h_xpoint = hXpoint;
	}
	public String getH_ypoint() {
		return h_ypoint;
	}
	public void setH_ypoint(String hYpoint) {
		h_ypoint = hYpoint;
	}
	public String getH_isrent() {
		return h_isrent;
	}
	public void setH_isrent(String hIsrent) {
		h_isrent = hIsrent;
	}
	public String getHet_ids() {
		return het_ids;
	}
	public void setHet_ids(String hetIds) {
		het_ids = hetIds;
	}
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int ptId) {
		pt_id = ptId;
	}
	public int getHt_id() {
		return ht_id;
	}
	public void setHt_id(int htId) {
		ht_id = htId;
	}
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rtId) {
		rt_id = rtId;
	}
	public String getH_number() {
		return h_number;
	}
	public void setH_number(String hNumber) {
		h_number = hNumber;
	}
	public String getH_publictime() {
		return h_publictime;
	}
	public void setH_publictime(String hPublictime) {
		h_publictime = hPublictime;
	}
	public String getH_ischeck() {
		return h_ischeck;
	}
	public void setH_ischeck(String hIscheck) {
		h_ischeck = hIscheck;
	}
	public int getH_isup() {
		return h_isup;
	}
	public void setH_isup(int hIsup) {
		h_isup = hIsup;
	}
	public String getH_date() {
		return h_date;
	}
	public void setH_date(String hDate) {
		h_date = hDate;
	}
	
}
