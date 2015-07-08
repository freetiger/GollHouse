package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Houses;
/**
 * 房源持久层接口
 * @author LJ
 *
 */
public interface IHousesDao {
	/**
	 * 根据经纪人Id分页查询房源信息
	 * @param hIscharge 是否为个人房源
	 * @param hRelevanceId 经纪人Id
	 * @param ischeck 是否审核
	 * @param page 分页对象
	 * @return 房源信息集合
	 */
	public List<Houses> selectHouses(int hIscharge, int hRelevanceId,	String ischeck,DoPage page) ;
	/**
	 * 根据分页对象查询房源信息
	 * @param sql 要执行的sql语句
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySqlWithPage(String sql,DoPage page);
	/**
	 * 根据公司id查询关联的房源信息
	 * @param cId 公司Id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByC_id(int cId);
	/**
	 * 根据小区id查询关联的房源信息
	 * @param saId 小区Id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySa_id(int saId);
	/**
	 * 根据经纪人id分页查询关联的房源信息
	 * @param bId 经纪人Id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByB_idWithPage(int bId,DoPage page);
	/**
	 * 根据小区id分页查询关联的房源信息
	 * @param saId 小区Id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesBySa_idWithPage(int saId,DoPage page);
	/**
	 * 根据经纪人id查询关联的房源信息
	 * @param bId 经纪人Id
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByB_id(int bId);
	/**
	 * 根据公司id与分页对象查询关联的房源信息
	 * @param cId 公司Id
	 * @param page 分页对象
	 * @return 查询返回的房源信息集合
	 */
	public List<Houses> queryHousesByC_idWithPage(int cId,DoPage page);
	/**
	 * 添加房源
	 * @param house 房源对象
	 * @return  true 成功，false 失败
	 */
	public long insertHouses(Houses house);
	/**
	 * 添加房源
	 * @param house 房源对象
	 * @return  id号
	 */
	public int addHouses(Houses house);
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
	 * 修改房源
	 * @param id 房源的id
	 * @param hRelevanceId 相关联的发布人的编号
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouses(int id,int hRelevanceId);
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
	 * 查询房源
	 * @param h_ischeck  是否审核
	 * @param pager 分页对象
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(String h_ischeck,DoPage pager);
	/**
	 * 查询房源
	 * @param h_ischarge  发布人类型
	 * @param pager 分页对象
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(int h_ischarge,DoPage pager);
	/**
	 * 按发布人类型查询房源
	 * @param h_ischarge  发布人类型
	 * @return 房源集合
	 */
	public List<Houses> queryAllHouses(int h_ischarge);
	/**
	 * 分页查询房源
	 * @param pager 分页对象
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
	 * 查询房源的详细信息
	 * @param h_id 房源id
	 * @return 房源信息
	 */
	public Houses selectHousesById(int h_id);
	/**
	 * 修改房源的验证的信息
	 * @param h_id 房源id
	 * @param check 审核值
	 * @return 影响的行数
	 */
	public int updateHousesCheck(String check,int h_id);
	/**
	 * 查询小区id所关联的房源信息
	 * @param sa_id 小区id
	 * @param ischarge 是否是个人
	 * @param ischeck 是否审核
	 * @return 房源信息集合
	 */
	public List<Houses> selectHousesBySa_id(int sa_id,int ischarge,String ischeck);
	/**
	 * 按发布人查询房源信息
	 * @param h_relevance_id 发布人
	 * @param ischarge 是否是个人
	 * @param ischeck 是否审核
	 * @return 房源信息集合
	 */
	public List<Houses> selectHouses(int h_ischarge,int h_relevance_id,String ischeck);
	/**
	 * 根据分页信息查询小区id所关联的房源信息
	 * @param saId 小区id
	 * @param isCharge 是否是个人
	 * @param page 分页信息对象
	 * @param ischeck 是否审核
	 * @return 房源信息集合
	 */
	public List<Houses> selectHousesBySa_idWithPages(int saId,int isCharge,DoPage page,String ischeck) ;
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
	 * 指定sql查询语句查询房源
	 * @param sql sql查询语句
	 * @return 房源集合
	 */
	public List<Houses> queryHousesBySql(String sql);
	
	/**
	 * 查询所有关键字
	 * @return 所有关键字字符串，用","分割
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
