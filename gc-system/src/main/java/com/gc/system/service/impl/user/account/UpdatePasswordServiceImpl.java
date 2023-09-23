package com.gc.system.service.impl.user.account;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.domain.User;
import com.gc.system.mapper.UserMapper;
import com.gc.system.service.impl.utils.UserDetailsImpl;
import com.gc.system.service.user.account.UpdatePasswordService;
import com.gc.system.utils.JwtUtil;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdatePasswordServiceImpl implements UpdatePasswordService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public Result updatePassword(String oldPassword, String newPassword, String confirmPassword) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();
        boolean matches = passwordEncoder.matches(oldPassword, user.getPassword());
        JSONObject resp = new JSONObject();

        if (!matches) {
            return Result.fail(400, null, "原密码错误");
        }
        if (newPassword == null || confirmPassword == null || newPassword.equals("") || confirmPassword.equals("")) {
            return Result.fail(400, null, "密码不能为空");
        }
        if (newPassword.equals(oldPassword)) {
            return Result.fail(400, null, "新旧密码不能相同");
        }
        if (!newPassword.equals(confirmPassword)) {
            return Result.fail(400, null, "俩次密码不同");
        }

        String PasswordEncode = passwordEncoder.encode(newPassword);
        userMapper.updateById(new User(
                user.getId(),
                user.getUsername(),
                PasswordEncode
                ));
        String jwt = JwtUtil.createJWT(user.getId());
        resp.put("token", jwt);
        return Result.Success(resp);
    }
}
