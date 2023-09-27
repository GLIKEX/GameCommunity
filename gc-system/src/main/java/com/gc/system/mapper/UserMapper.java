package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Knox 2020/11/7
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
