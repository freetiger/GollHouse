package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Out_Rents;
/**
 * 出租持久层接口
 * @author LJ
 *
 */
public interface IOut_RentsDao {
	
	/**
	 * 添加出租信息
	 * @param or 出租信息对象
	 * @return 影响行数
	 */
	public int insertOut_Rents(Out_Rents or);
	
	/**
	 * 修改出租信息
	 * @param or 出租信息对象
	 * @return 影响行数
	 */
	public int updateOut_Rents(Out_Rents or);
	
	/**
	 * 删除出租信息
	 * @param id 出租信息对象id
	 * @return 影响行数
	 */
	public int deleteOut_Rents(int id);
	
	/**
	 * 根据id查询出租信息
	 * @param id 出租信息对象id
	 * @param or_ischeck  是否审核
	 * @return 出租信息对象
	 */
	public Out_Rents queryOut_RentsById(int id,String or_ischeck);
	/**
	 * 根据id查询出租信息
	 * @param id 出租信息对象id
	 * @param or_ischeck  是否审核
	 * @return 出租信息对象
	 */
	public Out_Rents selOut_RentsById(int hid,String or_ischeck);
	
	/**
	 * 查询所有出租信息
	 * @param or_ischeck  是否审核
	 * @return 出租信息对象集合
	 */
	public List<Out_Rents> queryAllOut_Rents(String or_ischeck);
}
