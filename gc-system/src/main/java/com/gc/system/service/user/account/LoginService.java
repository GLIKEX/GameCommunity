package com.gc.system.service.user.account;

import com.gc.system.vo.Result;

public interface LoginService {
    Result getToken(String username, String password);
}
