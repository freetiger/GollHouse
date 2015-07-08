package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Systems;

/**
 * 系统持久层接口
 * @author LJ
 *
 */
public interface ISystemsDao {
	/**
	 * 添加系统数据
	 * @param sys 数据对象
	 * @return true 成功，false 失败
	 */
	public boolean insertSystems(Systems sys);
	/**
	 * 删除系统数据
	 * @param sys_id 数据编号
	 * @return 0失败， 1 成功
	 */
	public int deleteSystems(int sys_id);
	/**
	 * 修改系统数据
	 * @param sys 数据对象
	 * @return 0 失败， 1 成功
	 */
	public int updateSystems(Systems sys);
	/**
	 * 查询所有系统数据
	 * @return 数据集合
	 */
	public List<Systems> queryAllSystems();
	/**
	 * 根据系统数据编号查询数据
	 * @param sys_id 数据编号
	 * @return 数据对象
	 */
	public Systems querySystemsById(int sys_id);
}
