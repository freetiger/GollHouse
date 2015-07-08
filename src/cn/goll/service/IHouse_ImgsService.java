package cn.goll.service;

import java.util.List;

import cn.goll.entity.House_Imgs;

/**
 * 房源图片service接口
 * @author LJ
 *
 */
public interface IHouse_ImgsService {
	/**
	 * 添加房源图片
	 * @param com 房源图片对象
	 * @return true 成功，false 失败
	 */
	public long insertHouse_Imgs(House_Imgs his);
	/**
	 * 删除房源图片
	 * @param c_id 房源图片编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteHouse_Imgs(int hi_id);
	/**
	 * 修改房源图片
	 * @param com 房源图片对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouse_Imgs(House_Imgs his);
	/**
	 * 查询所有房源图片
	 * @param hi_ischeck  是否审核
	 * @return 房源图片集合
	 */
	public List<House_Imgs> queryAllHouse_Imgs(String hi_ischeck);
	/**
	 * 根据编号查询房源图片
	 * @param c_id  房源图片编号
	 * @param hi_ischeck  是否审核
	 * @return 房源图片对象
	 */
	public House_Imgs queryHouse_ImgsById(int hi_id,String  hi_ischeck);
}
