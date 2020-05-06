package com.zed.dao;

import com.zed.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> findAll();
    boolean login(User user);
    boolean register(User user);
}
