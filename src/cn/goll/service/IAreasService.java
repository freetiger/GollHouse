package cn.goll.service;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Areas;

public interface IAreasService {
	
	/**
	 * 添加区域
	 * @param area 区域对象
	 * @return true 成功，false 失败
	 */
	public boolean insertAreas(Areas area);
	
	/**
	 * 删除区域
	 * @param id 区域对象id
	 * @return 影响行数
	 */
	public int deleteAreas(int id);
	
	/**
	 * 删除多个区域
	 * @param id 区域对象id数组
	 * @return 影响行数
	 */
	public int deleteAreasByIds(int[] ids);
	
	/**
	 * 修改区域
	 * @param area 区域对象
	 * @return 影响行数
	 */
	public int updateAreas(Areas area);
	
	/**
	 * 修改区域集合
	 * @param areaList 区域对象集合
	 * @return 影响行数
	 */
	public int updateAreasList(List<Areas> areaList);
	
	/**
	 * 根据id查询区域
	 * @param id 区域对象id
	 * @param a_ischeck  是否审核
	 * @return 区域对象
	 */
	public Areas queruAreasByid(int id,String a_ischeck);
	
	/**
	 * 根据id数组查询区域
	 * @param ids 区域对象id数组
	 * @param a_ischeck  是否审核
	 * @return 区域对象集合
	 */
	public List<Areas> queruAreasByids(int[] ids,String a_ischeck);
	
	/**
	 * 查询所有区域
	 * @param a_ischeck  是否审核
	 * @return 区域对象集合
	 */
	public List<Areas> queryAllAreas(String a_ischeck);
	/**
	 * 根据分页对象查询区域对象集合
	 * @param page 分页对象
	 * @param isCheck 是否审核
	 * @return 区域对象集合
	 */
	public List<Areas> queryAllAreasByPage(DoPage page,String isCheck);
}
