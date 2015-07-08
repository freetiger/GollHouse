package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Managers;

/**
 * 用户service接口
 * @author LJ
 *
 */
public interface IManagersService {
	/**
	 * 添加用户
	 * @param com 用户对象
	 * @return true 成功，false 失败
	 */
	public boolean insertManagers(Managers his);
	/**
	 * 删除用户
	 * @param c_id 用户编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteManagers(int id);
	/**
	 * 修改用户
	 * @param com 用户对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateManagers(Managers his);
	/**
	 * 查询所有的管理员
	 * @param ischeck  是否审核
	 * @param pager  分页对象
	 * @return 管理员集合
	 */
	public List<Managers> queryAllManagers(String ischeck,DoPage pager);
	/**
	 * 查询所有用户
	 * @param ischeck  是否审核
	 * @return 用户集合
	 */
	public List<Managers> queryAllManagers(String ischeck);
	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	public List<Managers> queryAllManagers();
	/**
	 * 查询所有用户
	 * @param pager  分页对象
	 * @return 用户集合
	 */
	public List<Managers> queryAllManagers(DoPage pager);
	/**
	 * 根据编号查询用户
	 * @param c_id  用户编号
	 * @param ischeck  是否审核
	 * @return 用户对象
	 */
	public Managers queryManagersById(int id,String ischeck);
	/**
	 * 根据管理员的账户查询
	 * @param uname 管理员账户
	 * @param ischeck 是否审核
	 * @return 管理员信息
	 */
	public Managers queryManagersByName(String uname,String ischeck);
	/**
	 * 根据管理员编号修改管理员
	 * @param id 管理员编号
	 * @param ischeck  是否审核
	 * @return 管理员对象
	 */
	public int updateManagers(int id,String  ischeck);
	/**
	 * 初始化所以的管理员用户在线状态为不在线
	 * @return 个数
	 */
	public int setManagerIsonline();
}
