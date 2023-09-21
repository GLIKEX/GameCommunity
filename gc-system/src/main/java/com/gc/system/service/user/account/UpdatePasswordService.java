package com.gc.system.service.user.account;

import com.gc.system.vo.Result;

public interface UpdatePasswordService {
    Result updatePassword(String oldPassword, String newPassword, String confirmPassword);

}
