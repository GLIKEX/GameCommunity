package com.gc.system.service.impl.user.account;

import com.gc.system.domain.User;
import com.gc.system.mapper.UserMapper;
import com.gc.system.service.impl.utils.UserDetailsImpl;
import com.gc.system.service.user.account.UpdateService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result updateUserInfo(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();

        String username = data.get("username");
        String description = data.get("description");

        if (username == null || username.equals("")) {
            return Result.fail(400, null, "用户名不能为空");
        }
//        User new_user = new User(user.getId(), username, null);
//        int i = userMapper.updateById(new_user);
//        if (i == 1){
//            return Result.Success(null);
//        } else {
//            return Result.fail(400, null, "更新失败");
//        }
        return Result.fail(400, null, "更新失败");
    }
}
