package com.zhs.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhs.bean.MenuBean;
import com.zhs.dao.MenuBeanDao;
import com.zhs.utils.DataGridView;
import com.zhs.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuBeanDao menuBeanDao;

    public List<MenuBean> queryAllMenuForList(MenuVo menuVo) {
        return menuBeanDao.queryAllMenu(menuVo);
    }

    /**
     * 权限管理要修改的
     * @param menuVo
     * @param userId
     * @return
     */
    public List<MenuBean> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
        return menuBeanDao.queryAllMenu(menuVo);
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
        List<MenuBean> data = menuBeanDao.queryAllMenu(menuVo);
        return new DataGridView(page.getTotal(),data);
    }
}
