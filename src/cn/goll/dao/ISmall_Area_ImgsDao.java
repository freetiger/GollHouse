package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Small_Area_Imgs;

/**
 * 小区图片持久层接口
 * @author LJ
 *
 */
public interface ISmall_Area_ImgsDao {
	/**
	 * 添加小区图片
	 * @param sai 图片对象
	 * @return true成功，false失败
	 */
	public boolean insertSmall_Area_Imgs(Small_Area_Imgs sai);
	/**
	 * 删除小区图片 
	 * @param sai_id 图片编号
	 * @return 0失败，1成功
	 */
	public int deleteSmall_Area_Imgs(int sai_id);
	/**
	 * 修改小区图片
	 * @param sai 图片对象
	 * @return 0失败，1成功
	 */
	public int updateSmall_Area_Imgs(Small_Area_Imgs sai);
	/**
	 * 查询所有小区图片
	 * @param sai_ischeck  是否审核
	 * @return 小区图片集合
	 */
	public List<Small_Area_Imgs> queryAllSmall_Area_Imgs(String sai_ischeck);
	/**
	 * 根据小区编号查询小区图片
	 * @param sai_id 小区编号
	 * @param sai_ischeck  是否审核
	 * @return 小区图片对象
	 */
	public Small_Area_Imgs querySmall_Area_ImgsById(int sai_id,String  sai_ischeck);
}
