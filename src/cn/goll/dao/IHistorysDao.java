package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Historys;

/**
 * 历史记录持久层接口
 * @author LJ
 *
 */
public interface IHistorysDao {
	/**
	 * 添加历史记录
	 * @param his 记录对象
	 * @return true 成功， false 失败
	 */
	public boolean insertHistorys(Historys his);
	/**
	 * 删除历史记录
	 * @param his_id 记录编号
 	 * @return 0失败，1成功
	 */
	public int deleteHistorys(int his_id);
	/**
	 * 修改历史记录
	 * @param his 记录对象
	 * @return 0失败，1成功
	 */
	public int updateHistorys(Historys his);
	/**
	 * 查询所有的历史记录
	 * @return 记录集合
	 */
	public List<Historys> queryAllHistorys();
	/**
	 * 根据历史记录编号查询记录
	 * @param his_id 记录编号
	 * @return 记录对象
	 */
	public Historys queryHistorysById(int his_id);
	/**
	 * 查询所有的历史记录并进行分页
	 * @param doPage 分页类
	 * @return 历史记录集合
	 */
	public List<Historys> queryAllHistorys(DoPage doPage);
	
}
