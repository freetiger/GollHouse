package cn.goll.service;

import java.util.List;

import cn.goll.entity.House_Equip_Types;

/**
 * 房源配置service接口
 * @author LJ
 *
 */
public interface IHouse_Equip_TypesService {
	/**
	 * 添加房源配置
	 * @param com 房源配置对象
	 * @return true 成功，false 失败
	 */
	public boolean insertHouse_Equip_Types(House_Equip_Types het);
	/**
	 * 添加房源配置
	 * @return 新的id
	 */
	public int insertHouse_Equip_Types();
	/**
	 * 删除房源配置
	 * @param c_id 房源配置编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteHouse_Equip_Types(int het_id);
	/**
	 * 修改房源配置
	 * @param com 房源配置对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouse_Equip_Types(House_Equip_Types his);
	/**
	 * 查询所有房源配置
	 * @return 房源配置集合
	 */
	public List<House_Equip_Types> queryAllHouse_Equip_Types();
	/**
	 * 根据编号查询房源配置
	 * @param c_id  房源配置编号
	 * @return 房源配置对象
	 */
	public House_Equip_Types queryHouse_Equip_TypesById(int het_id);
}
