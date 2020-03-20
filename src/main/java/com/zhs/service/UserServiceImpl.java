package com.zhs.service;

import com.zhs.bean.UserBean;
import com.zhs.dao.UserBeanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserBeanDao userBeanDao;
    public void setUserBeanDao(UserBeanDao userBeanDao) {
        this.userBeanDao=userBeanDao;
    }
    public int deleteByPrimaryKey(Integer userid) {
        return userBeanDao.deleteByPrimaryKey(userid);
    }

    public int insert(UserBean record) {
        return userBeanDao.insert(record);
    }

    public int insertSelective(UserBean record) {
        return userBeanDao.insertSelective(record);
    }

    public UserBean selectByPrimaryKey(Integer userid) {
        return userBeanDao.selectByPrimaryKey(userid);
    }

    public int updateByPrimaryKeySelective(UserBean record) {
        return userBeanDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserBean record) {
        return userBeanDao.updateByPrimaryKey(record);
    }

    public UserBean Login(UserBean userBean) {
        //明文123456
        //生成密文
        String pwd = DigestUtils.md5DigestAsHex(userBean.getPwd().getBytes());
        userBean.setPwd(pwd);
        return userBeanDao.Login(userBean);
    }
}
