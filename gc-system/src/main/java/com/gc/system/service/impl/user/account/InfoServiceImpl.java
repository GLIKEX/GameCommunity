package com.gc.system.service.impl.user.account;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.domain.User;
import com.gc.system.service.impl.utils.UserDetailsImpl;
import com.gc.system.service.user.account.InfoService;
import com.gc.system.vo.Result;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Override
    public Result getInfo() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();

        JSONObject resp = new JSONObject();
        resp.put("id", user.getId());
        resp.put("username", user.getUsername());
        return Result.Success(resp);
    }
}
