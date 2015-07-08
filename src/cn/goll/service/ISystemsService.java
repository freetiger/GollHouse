package cn.goll.service;

import java.util.List;

import cn.goll.entity.Systems;

/**
 * 系统service接口
 * @author LJ
 *
 */
public interface ISystemsService {
	/**
	 * 添加系统
	 * @param com 系统对象
	 * @return true 成功，false 失败
	 */
	public boolean insertSystems(Systems his);
	/**
	 * 删除系统
	 * @param c_id 系统编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteSystems(int sys_id);
	/**
	 * 修改系统
	 * @param com 系统对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateSystems(Systems his);
	/**
	 * 查询所有系统
	 * @return 系统集合
	 */
	public List<Systems> queryAllSystems();
	/**
	 * 根据编号查询系统
	 * @param c_id  系统编号
	 * @return 系统对象
	 */
	public Systems querySystemsById(int sys_id);
}
