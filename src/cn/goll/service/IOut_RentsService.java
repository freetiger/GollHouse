package cn.goll.service;

import java.util.List;

import cn.goll.entity.Out_Rents;

public interface IOut_RentsService {
	
	/**
	 * 添加出租信息
	 * @param or 出租信息对象
	 * @return true 成功，false 失败
	 */
	public boolean insertOut_Rents(Out_Rents or);
	
	/**
	 * 删除出租信息
	 * @param id 出租信息对象id
	 * @return 影响行数
	 */
	public int deleteOut_Rents(int id);
	
	/**
	 * 修改出租信息
	 * @param or 出租信息对象
	 * @return 影响行数
	 */
	public int updateOut_Rents(Out_Rents or);
	
	/**
	 * 根据id查询出租信息
	 * @param id 出租信息对象id
	 * @param id or_ischeck 是否审核
	 * @return 出租信息对象
	 */
	public Out_Rents queruOut_RentsByid(int id,String or_ischeck);
	/**
	 * 根据id查询出租信息
	 * @param hid 出租信息对象id
	 * @param id or_ischeck 是否审核
	 * @return 出租信息对象
	 */
	public Out_Rents selOut_RentsByid(int hid,String or_ischeck);
	
	/**
	 * 查询所有出租信息
	 * @param id or_ischeck 是否审核
	 * @return 出租信息对象集合
	 */
	public List<Out_Rents> queryAllOut_Rents(String or_ischeck);
}
