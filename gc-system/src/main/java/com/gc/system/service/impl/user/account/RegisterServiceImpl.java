package com.gc.system.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gc.system.domain.User;
import com.gc.system.mapper.UserMapper;
import com.gc.system.service.user.account.RegisterService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Result register(String username, String password, String confirmPassword) {
        if (username == null || username.equals("")) {
            return Result.fail(400,null, "用户名不能为空");
        }
        if (password == null || confirmPassword == null || password.equals("") || confirmPassword.equals("")) {
            return Result.fail(400,null, "密码不能为空");
        }
        if (!password.equals(confirmPassword)) {
            return Result.fail(400,null, "俩次密码不同");
        }
        username = username.trim();
        if (username.length() > 100) {
            return Result.fail(400,null, "用户名长度不能大于100");
        }
        if (password.length() > 100) {
            return Result.fail(400,null, "密码长度不能大于100");
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User users = userMapper.selectOne(queryWrapper);
        if (users != null) {
            return Result.fail(400,null, "用户名已存在");
        }
        String encodePassword = passwordEncoder.encode(password);
        User user = new User(null, username, encodePassword);
        userMapper.insert(user);
        return Result.Success(null);
    }
}
