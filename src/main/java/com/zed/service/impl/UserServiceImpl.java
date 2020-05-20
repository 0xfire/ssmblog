package com.zed.service.impl;

import com.zed.mapper.AddressMapper;
import com.zed.pojo.Address;
import com.zed.pojo.User;
import com.zed.mapper.UserMapper;
import com.zed.service.UserService;
import com.zed.utils.myUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 20:57:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private AddressMapper addressMapper;

    @Override
    public void register(User user) {

        user.setRegDate(myUtils.getDATE());

        String uid = myUtils.getUUID();

        user.setId(uid);
        List<Address> addresses =  user.getAddresses();
        for (Address a: addresses) {

            a.setUserId(uid);
            a.setId(myUtils.getUUID());
            addressMapper.addAddress(a);
            System.out.println(a);
            if (a.getType().equals("homeAddress")){
                user.setHomeAddress(a.getId());
            }
            else {
                user.setWorkAddress(a.getId());
            }
        }
        userMapper.register(user);

    }

    @Override
    public User login(User user){

        return userMapper.login(user);
    }
}