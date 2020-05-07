package com.zed.service.Impl;


import com.zed.dao.UserDao;
import com.zed.model.User;
import com.zed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public int register(User user) {

        return userDao.insert(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

/*    @Override
    public List finAll() {
        return userDao.findAll();
    }*/
}
