package com.zed.mapper;

import com.zed.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 20:57:26
 */
public interface UserMapper {

    void register(User user);

}