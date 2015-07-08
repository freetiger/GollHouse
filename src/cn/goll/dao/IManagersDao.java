package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Managers;

/**
 * 管理员持久层接口
 * @author LJ
 *
 */
public interface IManagersDao {
	/**
	 * 添加管理员
	 * @param manager 管理员对象
	 * @return true 成功，false 失败
	 */
	public boolean insertManagers(Managers manager);
	/**
	 * 删除管理员
	 * @param id 管理员编号
	 * @return 0失败，1成功
	 */
	public int deleteManagers(int id);
	/**
	 * 修改管理员
	 * @param manager 管理员对象
	 * @return  0失败，1成功
	 */
	public int updateManagers(Managers manager);
	/**
	 * 查询所有的管理员
	 * @param ischeck  是否审核
	 * @return 管理员集合
	 */
	public List<Managers> queryAllManagers(String ischeck);
	
	/**
	 * 查询所有的管理员
	 * @param ischeck  是否审核
	 * @param pager  分页对象
	 * @return 管理员集合
	 */
	public List<Managers> queryAllManagers(String ischeck,DoPage pager);
	/**
	 * 查询所有的管理员
	 * @return 管理员集合
	 */
	public List<Managers> queryAllManagers();
	/**
	 * 查询所有的管理员
	 * @param pager 分页对象
	 * @return 管理员集合
	 */
	public List<Managers> queryAllManagers(DoPage pager);
	/**
	 * 根据管理员编号查询管理员
	 * @param id 管理员编号
	 * @param ischeck  是否审核
	 * @return 管理员对象
	 */
	public Managers queryManagersById(int id,String  ischeck);
	/**
	 * 根据管理员编号修改管理员
	 * @param id 管理员编号
	 * @param ischeck  是否审核
	 * @return 管理员对象
	 */
	public int updateManagers(int id,String  ischeck);
	/**
	 * 根据管理员的账户查询
	 * @param uname 管理员账户
	 * @param ischeck 是否审核
	 * @return 管理员信息
	 */
	public Managers queryManagersByName(String uname,String ischeck);
	/**
	 * 初始化所以的管理员用户在线状态为不在线
	 * @return 个数
	 */
	public int setManagerIsonline();
}
