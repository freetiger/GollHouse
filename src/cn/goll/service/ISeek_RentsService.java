package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Seek_Rents;

public interface ISeek_RentsService {
	
	/**
	 * 添加求租信息
	 * @param sr 求租信息对象
	 * @return true 成功，false 失败
	 */
	public boolean insertSeek_Rents(Seek_Rents sr);
	
	/**
	 * 删除求租信息
	 * @param id 求租信息对象id
	 * @return 影响行数
	 */
	public int deleteSeek_Rents(int id);
	/**
	 * 修改求租信息
	 * @param id 编号
	 * @param ischeck 审核
	 * @return 影响行数
	 */
	public int updateSeek_Rents(int id,String ischeck);
	
	/**
	 * 修改求租信息
	 * @param sr 求租信息对象
	 * @return 影响行数
	 */
	public int updateSeek_Rents(Seek_Rents sr);
	
	/**
	 * 根据id查询求租信息
	 * @param id 求租信息对象id
	 * @param id sr_ischeck 是否审核
	 * @return 求租信息对象
	 */
	public Seek_Rents queruSeek_RentsByid(int id,String sr_ischeck);
	
	/**
	 * 查询所有求租信息
	 * @param id sr_ischeck 是否审核
	 * @return 求租信息对象集合
	 */
	public List<Seek_Rents> queryAllSeek_Rents(String sr_ischeck);
	/**
	 * 查询所有求租信息
	 * @param id sr_ischeck 是否审核
	 * @param pager 分页对象
	 * @return 求租信息对象集合
	 */
	public List<Seek_Rents> queryAllSeek_Rents(String sr_ischeck,DoPage pager);
}
