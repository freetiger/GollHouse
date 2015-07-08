package cn.goll.service;

import java.util.List;

import cn.goll.entity.Rent_Types;

/**
 * 出租类型service接口
 * @author LJ
 *
 */
public interface IRent_TypesService {
	/**
	 * 添加出租类型
	 * @param com 出租类型对象
	 * @return true 成功，false 失败
	 */
	public boolean insertRent_Types(Rent_Types his);
	/**
	 * 添加出租类型
	 * @return 新的id
	 */
	public int insertRent_Types();
	/**
	 * 删除出租类型
	 * @param c_id 出租类型编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteRent_Types(int rt_id);
	/**
	 * 修改出租类型
	 * @param com 出租类型对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateRent_Types(Rent_Types his);
	/**
	 * 查询所有出租类型
	 * @return 出租类型集合
	 */
	public List<Rent_Types> queryAllRent_Types();
	/**
	 * 根据编号查询出租类型
	 * @param c_id  出租类型编号
	 * @return 出租类型对象
	 */
	public Rent_Types queryRent_TypesById(int rt_id);
}
