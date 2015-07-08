package cn.goll.service.impl;

import java.util.List;

import cn.goll.dao.IMenusDao;
import cn.goll.dao.impl.MenusDaoImpl;
import cn.goll.entity.Menus;
import cn.goll.service.IMenusService;

/**
 * IMenusService 持久层实现类
 * @author LYC
 *
 */
public class MenusServiceImpl implements IMenusService {
	IMenusDao dao=new MenusDaoImpl();
	public int deleteMenus(int hId) {
		return dao.deleteMenus(hId);
	}

	public Long insertMenus(Menus menu) {
		return dao.insertMenus(menu);
	}
	
	public List<Menus> queryAllMenus(String m_ischeck) {
		return dao.queryAllMenus(m_ischeck);
	}

	public Menus queryMenusById(int hId,String m_ischeck) {
		return dao.queryMenusById(hId,m_ischeck);
	}

	public int updateMenus(Menus menu) {
		return dao.updateMenus(menu);
	}

	public List<Menus> queryMenusByFid(int mId, String mIscheck) {
		return dao.queryMenusByFid(mId, mIscheck);
	}

}
