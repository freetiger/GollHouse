package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Companys;

/**
 * 中间公司service接口
 * @author LJ
 *
 */
public interface ICompanysService {
	/**
	 * 添加中介公司
	 * @param com 公司对象
	 * @return true 成功，false 失败
	 */
	public boolean insertCompanys(Companys com);
	/**
	 * 删除中介公司
	 * @param c_id 公司编号
	 * @return 0 失败 ，1 成功
	 */
	public int deleteCompanys(int c_id);
	/**
	 * 删除中介公司集合
	 * @param c_ids 公司编号数组
	 * @return 0 失败 ，1 成功
	 */
	public int deleteCompanys(int[] c_ids);
	/**
	 * 修改中介公司
	 * @param com 公司对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateCompanys(Companys com);
	/**
	 * 修改多个中介公司对象信息
	 * @param comList 公司对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateCompanys(List<Companys> comList);
	/**
	 * 查询所有中介公司
	 * @param h_ischeck  是否审核
	 * @return 公司集合
	 */
	public List<Companys> queryAllCompanys(String c_ischeck);
	/**
	 * 分页查询所有中介公司
	 * @param h_ischeck  是否审核
	 * @param page 分页对象
	 * @return 公司集合
	 */
	public List<Companys> queryAllCompanysByPages(DoPage page,String c_ischeck);
	/**
	 * 根据编号查询公司
	 * @param c_id  公司编号
	 * @param h_ischeck  是否审核
	 * @return 公司对象
	 */
	public Companys queryCompanysById(int c_id,String c_ischeck);
	/**
	 * 根据编号数组查询公司集合
	 * @param c_ids  公司编号数组
	 * @param h_ischeck  是否审核
	 * @return 公司对象集合
	 */
	public List<Companys> queryCompanysById(int[] c_ids,String c_ischeck);
}
