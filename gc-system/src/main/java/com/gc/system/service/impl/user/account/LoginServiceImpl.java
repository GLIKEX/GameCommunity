package com.gc.system.service.impl.user.account;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.pojo.User;
import com.gc.system.service.impl.utils.UserDetailsImpl;
import com.gc.system.service.user.account.LoginService;
import com.gc.system.utils.JwtUtil;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result getToken(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();

        String jwt = JwtUtil.createJWT(user.getUserId().toString());

        JSONObject resp = new JSONObject();
        resp.put("token", jwt);

        return Result.Success(resp);
    }
}
