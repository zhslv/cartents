package com.zhs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhs.bean.MenuBean;
import com.zhs.dao.MenuBeanDao;
import com.zhs.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuBeanDao menuBeanDao;

    public void setMenuBeanDao(MenuBeanDao menuBeanDao) {
        this.menuBeanDao = menuBeanDao;
    }

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(MenuBean record) {
        return 0;
    }

    public int insertSelective(MenuBean record) {
        return 0;
    }

    public MenuBean selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(MenuBean record) {
        return 0;
    }

    public int updateByPrimaryKey(MenuBean record) {
        return 0;
    }



    public List<MenuBean> queryAllMenuForList(MenuBean menuBean) {
        return menuBeanDao.queryAllMenu(menuBean);
    }


    public List<MenuBean> queryMenuByUserIdForList(MenuBean menuBean, Integer userId) {
        return menuBeanDao.queryAllMenu(menuBean);
    }


    public DataGridView queryAllMenu(MenuBean menuBean) {
        Page<Object> page= PageHelper.startPage(menuBean.getPage(), menuBean.getLimit());
        List<MenuBean> data = this.menuBeanDao.queryAllMenu(menuBean);
        return new DataGridView(page.getTotal(), data);
    }
}
