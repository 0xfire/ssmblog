package com.zed.controller;


import com.zed.model.User;
import com.zed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/findAll")
    public String findAll(){
        List<User> userList=userService.findAll();
        if (userList!=null)
            for (User user:userList){
                System.out.println(user);
            }

        return "helloView";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){

        boolean loginStatus=userService.login(user);
        if (loginStatus==true){
            System.out.println("登录成功");
        }
        return "helloView";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        user.setRegDate(ft.format(new Date()).toString());
        System.out.println(user.toString());

        return "helloView";
    }
}
