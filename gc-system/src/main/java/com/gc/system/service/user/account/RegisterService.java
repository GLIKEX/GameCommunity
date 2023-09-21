package com.gc.system.service.user.account;

import com.gc.system.vo.Result;

public interface RegisterService {
    Result register(String username, String password, String confirmPassword);
}
