package com.zed.controller;

import com.zed.mapper.AddressMapper;
import com.zed.mapper.AuthorityMapper;
import com.zed.mapper.RoleMapper;
import com.zed.mapper.UserMapper;
import com.zed.pojo.Authority;
import com.zed.pojo.User;
import com.zed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private RoleMapper roleMapper;

    @Resource
    private AuthorityMapper authorityMapper;

    @Resource
    private UserService userService;

    @Resource
    private AddressMapper addressMapper;
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user, MultipartFile userAvatar, HttpServletRequest request){

        userService.register(user);

        return "main";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user,HttpServletRequest request){
        User current = userService.login(user);
        if (current!=null){
            //设置用户到session中
            request.getSession().setAttribute("USER_SESSION",current);
            //获取权限 分两步 第一步查role 然后根据role查权限
            String currentRole = roleMapper.getRole(user.getName());
            String[] userRoles =  currentRole.split(",");
            List<Authority> premissions=new ArrayList<>();
            for (String role:userRoles
                 ) {
                premissions.addAll(authorityMapper.queryPermissions(role));
            }
            /*获取各类权限的url*/
            ArrayList<String> premissionUrl = new ArrayList<>();
            for (Authority premission:premissions
                 ) {
                if (!premissionUrl.contains(premission.getPermissionsUrl())){
                    premissionUrl.add(premission.getPermissionsUrl());
                }
            }
            /*权限的url保存到session中*/
            request.getSession().setAttribute("USER_PREMISSIONS",premissionUrl);
        }
        return "main";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}