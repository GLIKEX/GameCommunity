package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
