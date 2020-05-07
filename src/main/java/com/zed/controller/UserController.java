package com.zed.controller;


import com.zed.model.User;
import com.zed.service.UserService;
import com.zed.utils.fileUpload;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

/*    @GetMapping("/findAll")
    public String findAll(){
        List<User> userList=userService.findAll();
        if (userList!=null)
            for (User user:userList){
                System.out.println(user);
            }

        return "user";
    }*/

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {

        User current = userService.login(request.getParameter("username"), request.getParameter("password"));
        if (current != null) {
            System.out.println("登录成功");
        }
        request.getSession().setAttribute("user", current.getName());
        return "user";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, MultipartFile userAvatar, HttpServletRequest request) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        user.setRegdate(ft.format(new Date()));
        //上传头像
        user.setAvatar(fileUpload.uploadAvater(request, userAvatar));
        //注册
        int regstatus = userService.register(user);
        System.out.println(regstatus);
        //注册成功
        if (regstatus != 0) {
            //user信息保存到session
            request.getSession().setAttribute("user", user.getName());
            return "user";
        }

        return "user";

    }
}
