package cn.goll.service;

import java.util.List;

import cn.goll.entity.House_Types;

/**
 * 房型service接口
 * @author LJ
 *
 */
public interface IHouse_TypesService {
	/**
	 * 添加房型
	 * @param com 房型对象
	 * @return true 成功，false 失败
	 */
	public boolean insertHouse_Types(House_Types his);
	/**
	 * 添加房型
	 * @return 返回的id
	 */
	public int insertHouse_Types();
	/**
	 * 删除房型
	 * @param c_id 房型编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteHouse_Types(int ht_id);
	/**
	 * 修改房型
	 * @param com 房型对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouse_Types(House_Types his);
	/**
	 * 查询所有房型
	 * @return 房型集合
	 */
	public List<House_Types> queryAllHouse_Types();
	/**
	 * 根据编号查询房型
	 * @param c_id  房型编号
	 * @return 房型对象
	 */
	public House_Types queryHouse_TypesById(int ht_id);
}
