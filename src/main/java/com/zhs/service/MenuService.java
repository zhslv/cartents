package com.zhs.service;

import com.zhs.bean.MenuBean;
import com.zhs.utils.DataGridView;

import java.util.List;

public interface MenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuBean record);

    int insertSelective(MenuBean record);

    MenuBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuBean record);

    int updateByPrimaryKey(MenuBean record);

    /**
     * 查询所有菜单返回菜单List
     * @param menuBean
     * @return
     */
    List<MenuBean> queryAllMenuForList(MenuBean menuBean);

    /**
     * 根据用户id查询用户的可用菜单
     * @param menuBean
     * @param userId
     * @return
     */
    public List<MenuBean> queryMenuByUserIdForList(MenuBean menuBean,Integer userId);

    /**
     * 查询所有菜单
     * @param menuBean
     * @return
     */
    public DataGridView queryAllMenu(MenuBean menuBean);
}
