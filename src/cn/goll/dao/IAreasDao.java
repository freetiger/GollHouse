package cn.goll.dao;

import java.util.List;

import cn.goll.common.DoPage;
import cn.goll.entity.Areas;
/**
 * 区域持久层接口
 * @author LJ
 *
 */
public interface IAreasDao {
	
	/**
	 * 添加区域
	 * @param area 区域对象
	 * @return 影响行数
	 */
	public int insertAreas(Areas area);
	
	/**
	 * 修改区域
	 * @param area 区域对象
	 * @return 影响行数
	 */
	public int updateAreas(Areas area);
	
	/**
	 * 删除区域
	 * @param id
	 * @return 影响行数
	 */
	public int deleteAreas(int id);
	
	/**
	 * 根据id查询区域
	 * @param id
	 * @param a_ischeck 是否审核
	 * @return 区域对象
	 */
	public Areas queryAreasById(int id,String a_ischeck);
	
	/**
	 * 查询所有区域
	 * @param a_ischeck 是否审核
	 * @return 区域对象集合
	 */
	public List<Areas> queryAllAreas(String a_ischeck);
	
	/**
	 * 根据分页对象查询区域对象集合
	 * @param page 分页对象
	 * @param isCheck 是否审核
	 * @return 区域对象集合
	 */
	public List<Areas> selectAllAreasByPage(DoPage page,String isCheck);
}
