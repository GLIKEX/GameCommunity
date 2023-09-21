package com.gc.system.service.user.account;

import com.gc.system.vo.Result;

import java.util.Map;

public interface UpdateService {
    Result updateUserInfo(Map<String, String> data);
}
