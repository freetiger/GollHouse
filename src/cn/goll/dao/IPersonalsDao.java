package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Personals;

/**
 * 个人持久层接口
 * @author LJ
 *
 */
public interface IPersonalsDao {
	/**
	 * 添加个人
	 * @param person 个人对象
	 * @return true成功，false失败
	 */
	public boolean insertPersonals(Personals person);
	/**
	 * 添加个人
	 * @param person 个人对象
	 * @return 返回id
	 */
	public int addPersonals(Personals person);
	/**
	 * 删除个人
	 * @param per_id 个人编号
	 * @return 0失败，1成功
	 */
	public int deletePersonals(int per_id);
	/**
	 * 修改个人
	 * @param person 个人对象
	 * @return 0失败，1成功
	 */
	public int updatePersonals(Personals person);
	/**
	 * 查询所有个人
	 * @param per_ischeck  是否审核
	 * @return 个人集合
	 */
	public List<Personals> queryAllPersonals(String per_ischeck);
	/**
	 * 根据个人编号查询个人
	 * @param per_id 个人编号 
	 * @param per_ischeck  是否审核
	 * @return 个人对象
	 */
	public Personals queryPersonalsById(int per_id,String per_ischeck);
}
