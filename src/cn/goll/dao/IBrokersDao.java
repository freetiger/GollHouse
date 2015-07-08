package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Brokers;
import cn.goll.entity.Managers;

/**
 * 经纪人持久层接口
 * @author LJ
 *
 */
public interface IBrokersDao {
	/**
	 * 根据公司id查询关联的经纪人信息
	 * @param c_id 公司id
	 * @param b_ischeck 是否审核
	 * @return 查询返回的经纪人信息集合
	 */
	public List<Brokers> queryBrokersByC_id(int c_id,String b_ischeck);
	/**
	 * 添加经纪人
	 * @param brokers 经纪人对象
	 * @return  true成功,false失败
	 */
	public boolean insertBrokers(Brokers brokers);
	/**
	 * 删除经纪人
	 * @param b_id 经纪人编号
	 * @return 0失败，1成功
	 */
	public int deleteBrokers(int b_id);
	/**
	 * 修改经纪人
	 * @param brokers 经纪人对象
	 * @return 0失败，1成功
	 */
	public int updateBrokers(Brokers brokers);
	/**
	 * 查询所有经纪人
	 * @param b_ischeck  是否审核
	 * @return 经纪人集合
	 */
	public List<Brokers> queryAllBrokers(String b_ischeck);
	/**
	 * 根据编号查询经纪人
	 * @param b_id 经纪人编号
	 * @param b_ischeck  是否审核
	 * @return 经纪人对象
	 */
	public Brokers queryBrokersById(int b_id,String b_ischeck);
	/**
	 * 根据用户名查询经纪人是否存在
	 * @param b_name 经纪人的用户名
	 * @return true 存在，false 不存在
	 */
	public Brokers queryBrokersByName(String b_name);
	/**
	 * 根据邮箱查询经纪人是否存在
	 * @param b_email 经纪人的用户名
	 * @return true 存在，false 不存在
	 */
	public Brokers queryBrokersByEmail(String b_email);
	/**
	 * 查询经纪人及其所在的公司的集合并进行分页
	 * @param doPage 分页类
	 * @param ischeck 是否审核
	 * @return 经纪人和公司的集合
	 */
	public List<Brokers> queryByBrokerAndCompany(DoPage doPage,String ischeck);
	/**
	 * 查询经纪人及其所在的公司的集合
	 * @return 经纪人和公司的集合
	 */
	public List<Brokers> queryByBrokerAndCompany(String ischeck);
	/**
	 * 初始化设置所有经纪人的在线状态为不在线
	 * @return 个数
	 */
	public int setBrokersIsonline();
}
