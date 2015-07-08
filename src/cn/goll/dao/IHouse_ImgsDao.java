package cn.goll.dao;

import java.util.List;

import cn.goll.entity.House_Imgs;

/**
 * 房源图片持久层接口
 * @author LJ
 *
 */
public interface IHouse_ImgsDao {
	/**
	 * 添加房源图片
	 * @param hi 图片对象
	 * @return true成功,false失败
	 */
	public long insertHouse_Imgs(House_Imgs hi);
	/**
	 * 删除房源图片
	 * @param hi_id 图片编号
	 * @return 0失败，1成功
	 */
	public int deleteHouse_Imgs(int hi_id);
	/**
	 * 修改房源图片
	 * @param hi 图片对象
	 * @return  0失败，1成功
	 */
	public int updateHouse_Imgs(House_Imgs hi);
	/**
	 * 查询所有房源图片
	 * @param hi_ischeck  是否审核
	 * @return 图片集合
	 */
	public List<House_Imgs> queryAllHouse_Imgs(String hi_ischeck);
	/**
	 * 根据图片编号查询图片
	 * @param hi_id 图片编号
	 * @param hi_ischeck  是否审核
	 * @return 图片对象
	 */
	public House_Imgs queryHouse_ImgsById(int hi_id,String hi_ischeck);
}
