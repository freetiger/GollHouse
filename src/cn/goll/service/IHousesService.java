package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Houses;

public interface IHousesService {
	/**
	 * 根据经纪人Id分页查询房源信息
	 * @param hIscharge 是否为个人房源
	 * @param hRelevanceId 经纪人Id
	 * @param ischeck 是否审核
	 * @param page 分页对象
	 * @return 房源信息集合
	 */
	public List<Houses> queryHouses(int hIscharge, int hRelevanceId,	String ischeck,DoPage page) ;
	/**
	 * 根据分页执行sql查询语句
	 * @param sql sql查询语句字符串
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySqlWithPage(String sql,DoPage page);
	/**
	 * 根据公司id查询关联的房源信息
	 * @param c_id 公司id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByC_id(int c_id);
	/**
	 * 根据小区id查询关联的房源信息
	 * @param sa_id 小区id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySa_id(int sa_id);
	/**
	 * 根据经纪人id查询关联的房源信息
	 * @param b_id 经纪人id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByB_id(int b_id);
	/**
	 * 根据小区id分页查询关联的房源信息
	 * @param sa_id 小区id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySa_idWithPage(int sa_id,DoPage page);
	/**
	 * 根据经纪人id分页查询关联的房源信息
	 * @param b_id 经纪人id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByB_idWithPage(int b_id,DoPage page);
	/**
	 * 根据公司id与分页对象查询关联的房源信息
	 * @param c_id 公司id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByC_idWithPage(int c_id,DoPage page);
	/**
	 * 添加房源
	 * @param house 房源对象
	 * @return  true 成功，false 失败
	 */
	public long insertHouses(Houses house);
	/**
	 * 添加房源
	 * @param house 房源对象
	 * @return  true 成功，false 失败
	 */
	public int addHouses(Houses house);
	/**
	 * 修改房源
	 * @param id 房源id
	 * @param relevance 相关联的发布人的id
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouses(int id,int relevance);
	/**
	 * 删除房源
	 * @param h_id 房源id
	 * @return 0 失败 ，1成功
	 */
	public int deleteHouses(int h_id);
	/**
	 * 修改房源
	 * @param house 房源对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouses(Houses house);
	/**
	 * 查询房源
	 * @param h_ischeck  是否审核
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(String h_ischeck);
	/**
	 * 查询房源
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses();
	/**
	 * 查询小区id关联的所有房源信息
	 * @param sa_id 小区id
	 * @param ischarge 是否为个人
	 * @param ischeck 是否审核
	 * @return 查询到的房源信息集合
	 */
	public List<Houses> queryAllHousesBySa_id(int sa_id,int ischarge,String ischeck);
	/**
	 * 根据分页信息查询小区id关联的所有房源信息
	 * @param sa_id 小区id
	 * @param ischarge 是否是个人
	 * @param page 分页信息对象
	 * @param ischeck 是否审核
	 * @return 查询到的房源信息集合
	 */
	public List<Houses> queryAllHousesBySa_idWithPages(int sa_id,int ischarge,DoPage page,String ischeck);
	/**
	 * 查询房源
	 * @return 房源集合
	 */
	public Houses queryHouseById(int h_id);
	/**
	 * 查询房源
	 * @param h_ischeck  是否审核
	 * @param pager   分页对象
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(String h_ischeck,DoPage pager);
	/**
	 * 按发布人类型查询房源
	 * @param h_ischarge  发布人类型
	 * @param pager   分页对象
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(int h_ischarge,DoPage pager);
	/**
	 * 查询房源
	 * @param h_ischeck  是否审核
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(DoPage pager);
	/**
	 * 根据id查询房源
	 * @param h_id  房源id
	 * @param h_ischeck  是否审核
	 * @return  房源信息
	 */
	public Houses queryHousesById(int h_id,String h_ischeck);
	/**
	 * 按发布人类型查询房源
	 * @param h_ischarge  发布人类型
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(int h_ischarge);
	/**
	 * 修改房源的验证的信息
	 * @param h_id 房源id
	 * @param check 审核值
	 * @return 影响的行数
	 */
	public int updateHousesCheck(String check,int h_id);
	/**
	 * 按发布人查询房源信息
	 * @param h_relevance_id 发布人
	 * @param ischarge 是否是个人
	 * @param ischeck 是否审核
	 * @return 房源信息集合
	 */
	public List<Houses> selectHouses(int h_ischarge,int h_relevance_id,String ischeck);
	/**
	 * 根据置顶字段查询所有置顶的房源
	 * @param isup 置顶参数
	 * @return 房源集合
	 */
	public List<Houses> queryHousesByIsup(int isup);
	/**
	 * 根据置顶字段查询所有置顶的房源
	 * @param isup 置顶参数
	 * @return 房源集合
	 */
	public List<Houses> queryHousesByIsupAndtime(int isup); 
	/**
	 * 指定sql查询语句查询房源信息
	 * @param sql sql查询语句
	 * @return 房源集合
	 */
	public List<Houses> queryHousesBySql(String sql);
	/**
	 * 查询所以关键字信息
	 * @return 关键字字符串，用","分割
	 */
	public String queryHousesAllTag();
	/**
	 * 根据关键字查询房源信息
	 * @param tag 关键字
	 * @return 房源信息集合
	 */
	public List<Houses> queryHousesByTag(String tag);
	/**
	 * 查询经纪人所有的房源
	 * @param h_relevance_id 经纪人对应的id
	 * @param ischeck 是否审核
	 * @param pager 分页组件
	 * @return 房源集合
	 */
	public List<Houses> queryHouseBybid(int h_relevance_id,String ischeck,DoPage pager);
	/**
	 * 查询经纪人所有的房源
	 * @param h_relevance_id 经纪人对应的id
	 * @param ischeck 是否审核
	 * @return 房源集合
	 */
	public List<Houses> queryHouseBybid(int h_relevance_id,String ischeck);
}
