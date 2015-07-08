package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Historys;

/**
 * 历史记录service接口
 * @author LJ
 *
 */
public interface IHistorysService {
	/**
	 * 添加历史记录
	 * @param com 历史记录对象
	 * @return true 成功，false 失败
	 */
	public boolean insertHistorys(Historys his);
	/**
	 * 删除历史记录
	 * @param c_id 历史记录编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteHistorys(int his_id);
	/**
	 * 修改历史记录
	 * @param com 历史记录对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateHistorys(Historys his);
	/**
	 * 查询所有历史记录
	 * @return 历史记录集合
	 */
	public List<Historys> queryAllHistorys();
	/**
	 * 根据编号查询历史记录
	 * @param c_id  历史记录编号
	 * @return 历史记录对象
	 */
	public Historys queryHistorysById(int his_id);
	/**
	 * 查询所有的历史记录并进行分页
	 * @param doPage 分页类
	 * @return 历史记录集合
	 */
	public List<Historys> queryAllHistorys(DoPage doPage);
}
