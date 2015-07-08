package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Small_Areas;
/**
 * 小区持久层接口
 * @author LJ
 *
 */
public interface ISmall_AreasDao {
	/**
	 * 添加小区
	 * @param sa 封装好的小区信息
	 * @return true 成功，false 失败
	 */
	public boolean insertSmall_Areas(Small_Areas sa);
	/**
	 * 修改小区
	 * @param sa 封装好的小区信息
	 * @return 0 修改失败，1修改成功
	 */
	public int updateSmall_Areas(Small_Areas sa);
	/**
	 * 删除小区
	 * @param sa_id 小区编号
	 * @return 0 删除失败，1删除成功
	 */
	public int deleteSmall_Areas(int sa_id);
	/**
	 * 根据小区编号查询小区信息
	 * @param sa_id 小区编号
	 * @param sa_ischeck 是否审核
	 * @return 小区信息
	 */
	public Small_Areas querySmall_AreasById(int sa_id,String sa_ischeck);
	/**
	 * 查询所有小区信息
	 * @param sa_ischeck 是否审核
	 * @return 小区的集合
	 */
	public List<Small_Areas> querySmall_Areas(String sa_ischeck);
	/**
	 * 查询所有小区信息
	 * @page 分页对象
	 * @param sa_ischeck 是否审核
	 * @return 小区的集合
	 */
	public List<Small_Areas> querySmall_AreasByPages(DoPage page,String sa_ischeck);
	/**
	 * 查询区域id关联的所有小区信息
	 * @param sa_ischeck 是否审核
	 * @a_id 区域id
	 * @page 分页对象
	 * @return 小区的集合
	 */
	public List<Small_Areas> querySmall_AreasByPagesWithA_id(int a_id,DoPage page,String sa_ischeck);
	/**
	 * 根据区域编号查询小区
	 * @param a_id 区域编号
	 * @param sa_ischeck 是否审核
	 * @return 小区集合
	 */
	public List<Small_Areas> querySmall_AreasByA_id(int a_id,String sa_ischeck);
}
