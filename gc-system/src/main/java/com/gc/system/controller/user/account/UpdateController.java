package com.gc.system.controller.user.account;

import com.gc.system.service.user.account.UpdateService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateController {

    @Autowired
    UpdateService updateService;

    @PostMapping("/api/user/account/info/update/")
    public Result updateUserInfo(@RequestParam Map<String, String> data) {
        return updateService.updateUserInfo(data);
    }
}
