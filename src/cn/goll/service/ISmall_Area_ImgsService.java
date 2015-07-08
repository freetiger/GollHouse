package cn.goll.service;

import java.util.List;

import cn.goll.entity.Small_Area_Imgs;

/**
 * 小区图片service接口
 * @author LJ
 *
 */
public interface ISmall_Area_ImgsService {
	/**
	 * 添加小区图片
	 * @param com 小区图片对象
	 * @return true 成功，false 失败
	 */
	public boolean insertSmall_Area_Imgs(Small_Area_Imgs his);
	/**
	 * 删除小区图片
	 * @param c_id 小区图片编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteSmall_Area_Imgs(int sai_id);
	/**
	 * 修改小区图片
	 * @param com 小区图片对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateSmall_Area_Imgs(Small_Area_Imgs his);
	/**
	 * 查询所有小区图片
	 * @param sai_ischeck  是否审核
	 * @return 小区图片集合
	 */
	public List<Small_Area_Imgs> queryAllSmall_Area_Imgs(String sai_ischeck);
	/**
	 * 根据编号查询小区图片
	 * @param c_id  小区图片编号
	 * @param sai_ischeck  是否审核
	 * @return 小区图片对象
	 */
	public Small_Area_Imgs querySmall_Area_ImgsById(int sai_id,String sai_ischeck);
}
