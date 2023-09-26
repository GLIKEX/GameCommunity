package com.gc.system.controller.user.account;

import com.gc.system.dvo.UserVO;
import com.gc.system.service.user.account.InfoService;
import com.gc.system.service.user.account.LoginService;
import com.gc.system.service.user.account.RegisterService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/account/")
public class UserAccountController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    InfoService infoService;

    @PostMapping("/register")
    public Result register(@RequestBody UserVO userVO) {
        return registerService.register(userVO);
    }

    @PostMapping("/token")
    public Result getToken(@RequestBody UserVO userVO){
        return loginService.getToken(userVO.getUsername(), userVO.getPassword());
    }

    @GetMapping("/info")
    public Result getInfo(){
        return infoService.getInfo();
    }
}


