package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Rent_Types;

/**
 * 出租类型持久层接口
 * @author LJ
 *
 */
public interface IRent_TypesDao {
	/**
	 * 添加出租类型
	 * @param rt 出租类型对象
	 * @return true 成功，false 失败
	 */
	public boolean insertRent_Types(Rent_Types rt);
	/**
	 * 添加出租类型
	 * @return 新的id
	 */
	public int insertRent_Types();
	/**
	 * 删除出租类型
	 * @param rt_id 类型编号
	 * @return 0失败，1成功
	 */
	public int deleteRent_Types(int rt_id);
	/**
	 * 修改出租类型
	 * @param rt 类型对象
	 * @return 0失败，1成功
	 */
	public int updateRent_Types(Rent_Types rt);
	/**
	 * 查询所有的出租类型
	 * @return 类型集合
	 */
	public List<Rent_Types> queryAllRent_Types();
	/**
	 * 根据类型编号查询类型
	 * @param rt_id 类型编号
	 * @return  类型对象
	 */
	public Rent_Types queryRent_TypesById(int rt_id);
}
