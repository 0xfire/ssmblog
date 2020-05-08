package com.zed.service.impl;

import com.zed.pojo.Address;
import com.zed.mapper.AddressMapper;
import com.zed.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 20:57:03
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public void addAddress(Address address) {

    }
}