package com.zhs.dao;

import com.zhs.bean.MenuBean;

import java.util.List;

public interface MenuBeanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuBean record);

    int insertSelective(MenuBean record);

    MenuBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuBean record);

    int updateByPrimaryKey(MenuBean record);
    /**
     * 查询所有菜单
     */
    List<MenuBean> queryAllMenu(MenuBean menuBean);
}