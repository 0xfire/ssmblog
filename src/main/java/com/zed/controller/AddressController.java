package com.zed.controller;

import com.zed.pojo.Address;
import com.zed.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Address)表控制层
 *
 * @author makejava
 * @since 2020-05-19 19:40:36
 */
@RestController
@RequestMapping("address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Address selectOne(String id) {
        return null;
    }

}