package com.zed.mapper;

import com.zed.pojo.Authority;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Authority)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-24 19:22:12
 */
public interface AuthorityMapper {
   List<Authority> queryPermissions(String role);
}