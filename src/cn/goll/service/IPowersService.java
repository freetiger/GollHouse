package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Powers;

/**
 * 权限service接口
 * @author LJ
 *
 */
public interface IPowersService {
	/**
	 * 添加权限
	 * @param com 权限对象
	 * @return true 成功，false 失败
	 */
	public boolean insertPowers(Powers his);
	/**
	 * 删除权限
	 * @param c_id 权限编号
	 * @return 0 失败 ，1 成功
	 */
	public int deletePowers(int p_id);
	/**
	 * 修改权限
	 * @param com 权限对象
	 * @return 0 失败 ，1 成功
	 */
	public int updatePowers(Powers his);
	/**
	 * 查询所有权限
	 * @return 权限集合
	 */
	public List<Powers> queryAllPowers();
	/**
	 * 根据编号查询权限
	 * @param c_id  权限编号
	 * @return 权限对象
	 */
	public Powers queryPowersById(int p_id);
	/**
	 * 查询所有的权限
	 * @param dopage 分页类
	 * @return 权限集合
	 */
	public List<Powers> queryAllPowers(DoPage doPage);
}
