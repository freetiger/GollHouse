package cn.goll.dao;

import java.util.List;

import cn.goll.entity.House_Years;

/**
 * 房源年份持久层接口
 * @author 	LJ
 *
 */
public interface IHouse_YearsDao {
	/**
	 * 添加房源年份
	 * @param hy 年份对象
	 * @return true成功， false 失败
	 */
	public boolean insertHouse_Years(House_Years hy);
	/**
	 * 添加房源年份
	 * @return 新的id
	 */
	public int insertHouse_Years();
	/**
	 * 删除房源年份
	 * @param hy_id 年份编号
	 * @return 0失败，1成功
	 */
	public int deleteHouse_Years(int hy_id);
	/**
	 * 修改房源年份
	 * @param hy 年份对象
	 * @return 0失败，1成功
	 */
	public int updateHouse_Years(House_Years hy);
	/**
	 * 查询所有年份
	 * @return 年份集合 
	 */
	public List<House_Years> queryAllHouse_Years();
	/**
	 * 根据年份编号查询年份
	 * @param hy_id 年份编号
	 * @return 年份对象
	 */
	public House_Years queryHouse_YearsById(int hy_id);
}
