package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Seek_Rents;
/**
 * 求租持久层接口
 * @author LJ
 *
 */
public interface ISeek_RentsDao {
	
	/**
	 * 添加求租信息
	 * @param sr 求租信息对象
	 * @return  影响行数
	 */
	public int insertSeek_Rents(Seek_Rents sr);
	
	/**
	 * 修改求租信息
	 * @param sr 求租信息对象
	 * @return 影响行数
	 */
	public int updateSeek_Rents(Seek_Rents sr);
	/**
	 * 修改求租信息
	 * @param id 编号
	 * @param ischeck 审核
	 * @return 影响行数
	 */
	public int updateSeek_Rents(int id,String ischeck);
	
	/**
	 * 删除求租信息
	 * @param id 求租信息对象id
	 * @return 影响行数
	 */
	public int deleteSeek_Rents(int id);
	
	/**
	 * 根据id查询求租信息
	 * @param id 求租信息对象id
	 * @param id sr_ischeck 是否审核
	 * @return 求租信息对象
	 */
	public Seek_Rents querySeek_RentsById(int id,String sr_ischeck);
	
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
