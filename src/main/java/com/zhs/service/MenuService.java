package com.zhs.service;

import com.zhs.bean.MenuBean;
import com.zhs.utils.DataGridView;
import com.zhs.vo.MenuVo;

import java.util.List;

public interface MenuService {

    /**
     * 查询所有菜单返回菜单List
     * @param menuVo
     * @return
     */
    List<MenuBean> queryAllMenuForList(MenuVo menuVo);

    /**
     * 根据用户id查询用户的可用菜单
     * @param menuVo
     * @param userId
     * @return
     */
    public List<MenuBean> queryMenuByUserIdForList(MenuVo menuVo,Integer userId);


   public DataGridView queryAllMenu(MenuVo menuVo);
}
