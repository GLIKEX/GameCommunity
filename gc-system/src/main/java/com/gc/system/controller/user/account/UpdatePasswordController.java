package com.gc.system.controller.user.account;

import com.gc.system.service.user.account.UpdatePasswordService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdatePasswordController {
    @Autowired
    private UpdatePasswordService updatePasswordService;

    @PostMapping("/api/user/account/update/password/")
    public Result updatePassword(@RequestParam Map<String, String> data) {
        String oldPassword = data.get("oldPassword");
        String newPassword = data.get("newPassword");
        String confirmPassword = data.get("confirmPassword");
        return updatePasswordService.updatePassword(oldPassword, newPassword, confirmPassword);
    }
}
