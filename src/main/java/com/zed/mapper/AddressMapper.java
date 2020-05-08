package com.zed.mapper;

import com.zed.pojo.Address;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AddressMapper {

    void addAddress(Address address);

}