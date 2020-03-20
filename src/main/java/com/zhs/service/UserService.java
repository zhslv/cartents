package com.zhs.service;

import com.zhs.bean.UserBean;

public interface UserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

    UserBean Login(UserBean userBean);
}
