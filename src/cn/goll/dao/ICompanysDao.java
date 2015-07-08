package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Companys;

/**
 * 中间公司持久层接口
 * @author LJ
 *
 */
public interface ICompanysDao {
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
	 * 修改中介公司
	 * @param com 公司对象
	 * @return 0 失败 ，1 成功
	 */
	public int updateCompanys(Companys com);
	/**
	 * 查询所有中介公司
	 * @param c_ischeck  是否审核
	 * @return 公司集合
	 */
	public List<Companys> queryAllCompanys(String c_ischeck);
	/**
	 * 分页查询所有中介公司
	 * @param c_ischeck  是否审核
	 * @param page 分页对象
	 * @return 公司集合
	 */
	public List<Companys> queryAllCompanysByPages(DoPage page,String c_ischeck);
	/**
	 * 根据编号查询公司
	 * @param c_id  公司编号
	 * @param c_ischeck  是否审核
	 * @return 公司对象
	 */
	public Companys queryCompanysById(int c_id,String c_ischeck);
}
