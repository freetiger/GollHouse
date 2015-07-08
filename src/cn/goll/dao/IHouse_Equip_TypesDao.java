package cn.goll.dao;

import java.util.List;

import cn.goll.entity.House_Equip_Types;

/**
 * 房源配置持久层接口
 * @author LJ
 *
 */
public interface IHouse_Equip_TypesDao {
	/**
	 * 添加房源配置
	 * @param het 配置对象
	 * @return true  成功，false  失败
 	 */
	public boolean insertHouse_Equip_Types(House_Equip_Types het);
	/**
	 * 添加房源配置
	 * @return 新的id
 	 */
	public int insertHouse_Equip_Types();
	/**
	 * 删除房源配置
	 * @param het_id 配置编号
	 * @return 0失败，1成功
	 */
	public int deleteHouse_Equip_Types(int het_id);
	/**
	 * 修改房源配置
	 * @param het 配置对象
	 * @return 0失败，1成功
	 */
	public int updateHouse_Equip_Types(House_Equip_Types het);
	/**
	 * 查询所有房源配置
	 * @return 配置集合
	 */
	public List<House_Equip_Types> queryAllHouse_Equip_Types();
	/**
	 * 根据配置编号查询配置
	 * @param het_id 配置编号
	 * @return 配置对象
	 */
	public House_Equip_Types queryHouse_Equip_TypesById(int het_id);
}
