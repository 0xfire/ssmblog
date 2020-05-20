package com.zed.service;

import com.zed.pojo.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 20:57:26
 */
public interface UserService {

    void register(User user);

    User login(User user);
}