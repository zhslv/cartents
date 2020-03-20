package com.zhs.controller;

import com.zhs.bean.MenuBean;
import com.zhs.bean.UserBean;
import com.zhs.service.MenuService;
import com.zhs.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu/loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuBean menuBean){
        //得到当前登陆的用户对象
        UserBean user=(UserBean) WebUtils.getHttpSession().getAttribute("user");
        List<MenuBean> list=null;
        menuBean.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
        if(user.getType()==SysConstast.USER_TYPE_SUPER) {
            list=this.menuService.queryAllMenuForList(menuBean);
        }else {
            list=this.menuService.queryMenuByUserIdForList(menuBean, user.getUserid());
        }
        List<TreeNode> nodes= new ArrayList<>();
        //把list里面的数据放到nodes
        for (MenuBean menu : list) {
            Integer id=menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
            String href=menu.getHref();
            Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
            String target=menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }


    /**
     * 加载菜单管理左边的菜单树
     */
    @RequestMapping("/menu/loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuBean menuBean){
        menuBean.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
        List<MenuBean> list=this.menuService.queryAllMenuForList(menuBean);
        List<TreeNode> nodes= new ArrayList<>();
        //把list里面的数据放到nodes
        for (MenuBean menu : list) {
            Integer id=menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
            String href=menu.getHref();
            Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
            String target=menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return new DataGridView(nodes);
    }

    /**
     * 加载菜单列表返回DataGridView
     */
    @RequestMapping("/menu/loadAllMenu")
    public DataGridView loadAllMenu(MenuBean menuBean) {
        return this.menuService.queryAllMenu(menuBean);
    }
}
