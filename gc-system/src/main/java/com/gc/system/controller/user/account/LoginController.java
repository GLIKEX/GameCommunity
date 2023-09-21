package com.gc.system.controller.user.account;


import com.gc.system.service.user.account.LoginService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/api/user/account/token/")
    public Result getToken(@RequestParam Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username, password);
    }
}