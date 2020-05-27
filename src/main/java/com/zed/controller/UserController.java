package com.zed.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zed.mapper.AddressMapper;
import com.zed.mapper.AuthorityMapper;
import com.zed.mapper.RoleMapper;
import com.zed.mapper.UserMapper;
import com.zed.pojo.Authority;
import com.zed.pojo.User;
import com.zed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/findlist",method = RequestMethod.GET)
    public String findlist(ModelMap map, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        /*对于String page前端如果传入了page但是没有给值 如 ?page=  此时page的值为一个长度为0的字符串
        * 如果连page都没有  此时page为null
        *
        * 对于Integer page 只要传入数字为正常，传入字母就是400  可以写个拦截器进行判断  然后抛出自定义异常（暂不实现）
        * */
        if(pageNo==null){
            return "list";
        }
        PageHelper.startPage(pageNo,5);
        List<User> user = userMapper.find();
        PageInfo pageInfo = new PageInfo(user);
        map.addAttribute("pageInfo", pageInfo);
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "/findlist2",method = RequestMethod.GET)
    public Map<String,Object> findlist2( @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        /*对于String page前端如果传入了page但是没有给值 如 ?page=  此时page的值为一个长度为0的字符串
         * 如果连page都没有  此时page为null
         *
         * 对于Integer page 只要传入数字为正常，传入字母就是400  可以写个拦截器进行判断  然后抛出自定义异常（暂不实现）
         * */
        if(pageNo==null){
            return null;
        }
        PageHelper.startPage(pageNo,5);
        List<User> user = userMapper.find();
        PageInfo pageInfo = new PageInfo(user);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfo",pageInfo);
        return map;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }
}