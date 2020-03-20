package com.zhs.dao;

import com.zhs.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBeanDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

     UserBean Login(UserBean userBean);
}