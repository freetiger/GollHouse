package cn.goll.service;

import java.util.List;

import cn.goll.entity.House_Years;

/**
 * 年份service接口
 * @author LJ
 *
 */
public interface IHouse_YearsService {
	/**
	 * 添加年份
	 * @param com 年份对象
	 * @return true 成功，false 失败
	 */
	public boolean insertHouse_Years(House_Years his);
	/**
	 * 添加年份
	 * @return 返回的id
	 */
	public int insertHouse_Years();
	/**
	 * 删除年份
	 * @param c_id 年份编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteHouse_Years(int hy_id);
	/**
	 * 修改年份
	 * @param com 年份对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHouse_Years(House_Years his);
	/**
	 * 查询所有年份
	 * @return 年份集合
	 */
	public List<House_Years> queryAllHouse_Years();
	/**
	 * 根据编号查询年份
	 * @param c_id  年份编号
	 * @return 年份对象
	 */
	public House_Years queryHouse_YearsById(int hy_id);
}
