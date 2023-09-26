package com.gc.system.service.impl.user.account;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.domain.User;
import com.gc.system.service.UserService;
import com.gc.system.service.impl.utils.UserDetailsImpl;
import com.gc.system.service.user.account.InfoService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private UserService userService;

    @Override
    public Result getInfo() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();

        JSONObject resp = new JSONObject();
        User userInfo = userService.getById(user.getId());
        userInfo.setPassword("");
        resp.put("user", userInfo);

        return Result.Success(resp);
    }
}
