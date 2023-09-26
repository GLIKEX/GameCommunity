package com.gc.system.service.user.account;

import com.gc.system.dvo.UserVO;
import com.gc.system.vo.Result;

public interface RegisterService {
    Result register(UserVO userVo);
}
