package com.zed.controller;

import com.zed.mapper.AddressMapper;
import com.zed.mapper.UserMapper;
import com.zed.pojo.Address;
import com.zed.pojo.User;
import com.zed.service.UserService;
import com.zed.utils.myUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-05-19 19:41:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private AddressMapper addressMapper;
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(User user, MultipartFile userAvatar, HttpServletRequest request){

        userService.register(user);

        return "main";
    }

}