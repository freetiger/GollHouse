package cn.goll.service;

import java.util.List;

import cn.goll.entity.Menus;

/**
 * 菜单service接口
 * @author LJ
 *
 */
public interface IMenusService {
	/**
	 * 添加菜单
	 * @param menu 菜单对象
	 * @return true 成功，false 失败
	 */
	public Long insertMenus(Menus menu);
	/**
	 * 删除菜单
	 * @param m_id 菜单编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteMenus(int m_id);
	/**
	 * 修改菜单
	 * @param com 菜单对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateMenus(Menus his);
	/**
	 * 查询所有菜单
	 * @param m_ischeck  是否审核
	 * @return 菜单集合
	 */
	public List<Menus> queryAllMenus(String m_ischeck);
	/**
	 * 根据编号查询菜单
	 * @param m_id  菜单编号
	 * @param m_ischeck  是否审核
	 * @return 菜单对象
	 */
	public Menus queryMenusById(int m_id,String m_ischeck);
	/**
	 * 根据菜单编号查询菜单
	 * @param m_id 菜单编号
	 * @param m_ischeck  是否审核
	 * @return 菜单对象
	 */
	public List<Menus> queryMenusByFid(int m_id,String m_ischeck);
}
