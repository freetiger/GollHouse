package cn.goll.dao;

import java.util.List;

import cn.goll.entity.Pay_Types;

/**
 * 付款方式持久层接口
 * @author LJ
 *
 */
public interface IPay_TypesDao {
	/**
	 * 添加付款方式
	 * @param pt 付款方式对象
	 * @return true 成功，false 失败
	 */
	public boolean insertPay_Types(Pay_Types pt);
	/**
	 * 添加付款方式
	 * @return 新的id
	 */
	public int insertPay_Types();
	/**
	 * 删除付款方式
	 * @param pt_id 方式编号
	 * @return 0失败，1成功
	 */
	public int deletePay_Types(int pt_id);
	/**
	 * 修改付款方式
	 * @param pt 付款方式对象
	 * @return  0失败，1成功
	 */
	public int updatePay_Types(Pay_Types pt);
	/**
	 * 查询所有付款方式
	 * @return 付款方式集合
	 */
	public List<Pay_Types> queryAllPay_Types();
	/**
	 * 根据付款方式编号查询
	 * @param pt_id 付款方式编号
	 * @return 付款方式对象
	 */
	public Pay_Types queryPay_TypesById(int pt_id);
}
