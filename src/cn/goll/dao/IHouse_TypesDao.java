package cn.goll.dao;

import java.util.List;

import cn.goll.entity.House_Types;

/**
 * 房源类型持久层接口
 * @author LJ
 *
 */
public interface IHouse_TypesDao{
	/**
	 * 添加房源类型
	 * @param ht 类型对象
	 * @return true 成功，false 失败
	 */
	public boolean insertHouse_Types(House_Types ht);
	/**
	 * 添加房源类型
	 * @return 返回新的id
	 */
	public int insertHouse_Types();
	/**
	 * 删除房源类型
	 * @param ht_id 房源类型编号
	 * @return 0失败，1成功
	 */
	public int deleteHouse_Types(int ht_id);
	/**
	 * 修改房源类型
	 * @param ht 房源类型编号
	 * @return 编号
	 * @return 0失败，1成功
	 */
	public int updateHouse_Types(House_Types ht);
	/**
	 * 查询所有房源类型
	 * @return 房源类型集合
	 */
	public List<House_Types> queryAllHouse_Types();
	/**
	 * 根据房源类型编号查询房源类型
	 * @param ht_id  房源类型编号
	 * @return 房源类型对象
	 */
	public House_Types queryHouse_TypesById(int ht_id);
	
}
