package com.zhs.controller;

import com.zhs.bean.UserBean;
import com.zhs.service.UserService;
import com.zhs.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //跳转登录页面
    @RequestMapping("tologin")
    public String toLogin(){
        return "system/main/login";
    }

    //登录方法
    @RequestMapping("login")
    public String Login(UserBean userBean, Model model){
        UserBean user = userService.Login(userBean);
        if(user!=null){
            WebUtils.getHttpSession().setAttribute("user",user);
            return "system/main/index";
        }else {
            model.addAttribute("error","请重新登录！");
            return "system/main/login";
        }
    }
    //跳转工作台页面
    @RequestMapping("desk/todeskManager")
    public String desk(){
        return "system/main/deskManager";
    }

}
