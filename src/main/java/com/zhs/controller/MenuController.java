package com.zhs.controller;

import com.zhs.bean.MenuBean;
import com.zhs.bean.UserBean;
import com.zhs.service.MenuService;
import com.zhs.utils.*;
import com.zhs.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 登录时初始化菜单
     * @param menuVo
     * @return
     */
    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
        //得到当前登陆的用户对象
        UserBean user=(UserBean) WebUtils.getHttpSession().getAttribute("user");
        List<MenuBean> list=null;
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
        if(user.getType()==SysConstast.USER_TYPE_SUPER) {
            list=this.menuService.queryAllMenuForList(menuVo);
        }else {
            list=this.menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
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
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
        List<MenuBean> list=this.menuService.queryAllMenuForList(menuVo);
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
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo) {
        return this.menuService.queryAllMenu(menuVo);
    }
}
