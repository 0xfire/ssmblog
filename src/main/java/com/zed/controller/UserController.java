package com.zed.controller;


import com.zed.model.User;
import com.zed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

        return "user";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){

        boolean loginStatus=userService.login(user);
        if (loginStatus==true){
            System.out.println("登录成功");
        }
        return "user";
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user, MultipartFile useravatar, HttpServletRequest request){

        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        user.setRegDate(ft.format(new Date()).toString());

        //获取上传头像的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断路径是否存在
        File file = new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }

        String filename = useravatar.getOriginalFilename();
        System.out.println(filename);
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        try {
            useravatar.transferTo(new File(path,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setAvatar(filename);
        //注册
        boolean regstatus = userService.register(user);
        //user信息保存到session
        request.getSession().setAttribute("user", user);

        System.out.println(regstatus);

        return "user";
    }
}
