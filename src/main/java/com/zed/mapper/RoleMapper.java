package com.zed.mapper;

import com.zed.pojo.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-22 17:44:29
 */
public interface RoleMapper {

    String getRole(String username);
}