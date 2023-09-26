package com.gc.system.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gc.system.domain.User;
import com.gc.system.dvo.UserVO;
import com.gc.system.mapper.UserMapper;
import com.gc.system.service.user.account.RegisterService;
import com.gc.system.utils.IdGenerator;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public Result register(UserVO userVO) {
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        String confirmPassword = userVO.getConfirmPassword();

        if (username == null || username.equals("")) {
            return Result.fail(400, null, "用户名不能为空");
        }
        if (password == null || confirmPassword == null || password.equals("") || confirmPassword.equals("")) {
            return Result.fail(400, null, "密码不能为空");
        }
        if (!password.equals(confirmPassword)) {
            return Result.fail(400, null, "俩次密码不同");
        }
        username = username.trim();
        if (username.length() > 100) {
            return Result.fail(400, null, "用户名长度不能大于100");
        }
        if (password.length() > 100) {
            return Result.fail(400, null, "密码长度不能大于100");
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User users = userMapper.selectOne(queryWrapper);
        if (users != null) {
            return Result.fail(400, null, "用户名已存在");
        }
        String encodePassword = passwordEncoder.encode(password);
        User user = new User(
                idGenerator.generateId(),
                username,
                username,
                encodePassword,
                "https://s1.locimg.com/2023/09/25/94b2d1c515a70.png",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                new Date(),
                new Date()
        );
        userMapper.insert(user);
        return Result.Success(null);
    }
}
