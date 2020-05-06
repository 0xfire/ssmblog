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

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll(){
        return userDao.findAll();
    }

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }
}
