package com.zed.service;

import com.zed.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    boolean register(User user);
    boolean login(User user);
}
