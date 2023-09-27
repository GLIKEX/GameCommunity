package com.gc.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gc.system.model.dto.LoginDTO;
import com.gc.system.model.dto.RegisterDTO;
import com.gc.system.model.entity.User;
import com.gc.system.model.vo.ProfileVO;


public interface IUmsUserService extends IService<User> {

    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    User executeRegister(RegisterDTO dto);
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    User getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);
    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
