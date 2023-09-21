package com.gc.system.controller.user.account;

import com.gc.system.service.user.account.InfoService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoServiceController {

    @Autowired
    InfoService infoService;

    @GetMapping("/api/user/account/info/")
    public Result getInfo(){
        return infoService.getInfo();
    }
}
