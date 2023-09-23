package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tiebo
* @description 针对表【ums_user(用户表)】的数据库操作Mapper
* @createDate 2023-09-23 11:03:14
* @Entity generator.domain.User
*/
@Mapper

public interface UserMapper extends BaseMapper<User> {

}




