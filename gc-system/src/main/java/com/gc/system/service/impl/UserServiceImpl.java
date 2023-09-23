package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.User;
import com.gc.system.mapper.UserMapper;
import com.gc.system.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【ums_user(用户表)】的数据库操作Service实现
* @createDate 2023-09-23 11:03:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




