package cn.goll.service;

import java.util.List;

import cn.goll.entity.Rent_Moneys;

/**
 * 租金service接口
 * @author LJ
 *
 */
public interface IRent_MoneysService {
	/**
	 * 添加租金
	 * @param rm 租金对象
	 * @return true 成功，false失败
	 */
	public boolean insertRent_Moneys(Rent_Moneys rm);
	/**
	 * 添加租金
	 * @return 新的id
	 */
	public int insertRent_Moneys();
	/**
	 * 删除租金
	 * @param rm_id 租金编号
	 * @return 0失败，1成功
	 */
	public int deleteRent_Moneys(int rm_id);
	/**
	 * 修改租金
	 * @param rm 租金对象
	 * @return 0失败，1成功
	 */
	public int updateRent_Moneys(Rent_Moneys rm);
	/**
	 * 查询所有租金
	 * @return 租金集合
	 */
	public List<Rent_Moneys> queryAllRent_Moneys();
	/**
	 * 根据租金编号查询租金
	 * @param rm_id 租金编号
	 * @return 租金对象
	 */
	public Rent_Moneys queryRent_MoneysById(int rm_id);
}
