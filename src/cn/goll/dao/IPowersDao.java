package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Powers;

/**
 * 权限持久层接口
 * @author Administrator
 *
 */
public interface IPowersDao {
	/**
	 * 添加权限
	 * @param power 权限对象
	 * @return true 成功，false 失败
	 */
	public boolean insertPowers(Powers power);
	/**
	 * 删除权限
	 * @param p_id 权限编号
	 * @return 0失败，1成功
	 */
	public int deletePowers(int p_id);
	/**
	 * 修改权限
	 * @param power 权限对象
	 * @return  0失败，1成功
	 */
	public int updatePowers(Powers power);
	/**
	 * 查询所有的权限
	 * @return 权限集合
	 */
	public List<Powers> queryAllPowers();
	/**
	 * 查询所有的权限
	 * @param dopage 分页类
	 * @return 权限集合
	 */
	public List<Powers> queryAllPowers(DoPage doPage);
	/**
	 * 根据权限编号查询权限
	 * @param p_id 权限编号
	 * @return 权限对象
	 */
	public Powers queryPowersById(int p_id);
}
