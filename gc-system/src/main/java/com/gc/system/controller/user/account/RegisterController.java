package com.gc.system.controller.user.account;

import com.gc.system.service.user.account.RegisterService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/user/account/register/")
    public Result register(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmPassword = map.get("confirmPassword");
        return registerService.register(username, password, confirmPassword);
    }
}
