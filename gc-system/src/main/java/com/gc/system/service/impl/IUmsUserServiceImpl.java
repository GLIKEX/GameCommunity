package com.gc.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.common.exception.ApiAsserts;
import com.gc.system.config.jwt.JwtUtil;
import com.gc.system.mapper.BmsFollowMapper;
import com.gc.system.mapper.BmsPostMapper;
import com.gc.system.mapper.UserMapper;
import com.gc.system.model.dto.LoginDTO;
import com.gc.system.model.dto.RegisterDTO;
import com.gc.system.model.entity.BmsFollow;
import com.gc.system.model.entity.BmsPost;
import com.gc.system.model.entity.User;
import com.gc.system.model.vo.ProfileVO;
import com.gc.system.service.IUmsUserService;
import com.gc.system.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;



@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IUmsUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUmsUserService {

    @Autowired
    private BmsPostMapper bmsPostMapper;
    @Autowired
    private BmsFollowMapper bmsFollowMapper;

    @Override
    public User executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, dto.getUsername()).or().eq(User::getEmail, dto.getEmail());
        User user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        User addUser = User.builder()
                .username(dto.getUsername())
                .bio("这个人很懒, 暂时还没有简介~")
                .roleId(0)
                .alias(dto.getUsername())
                .password(MD5Utils.getPwd(dto.getPassword()))
                .email(dto.getEmail())
                .createTime(new Date())
                .modifyTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }
    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }
    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            User user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.createJWT(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }
        return token;
    }
    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        User user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user, profile);
        // 用户文章数
        int count = Math.toIntExact(bmsPostMapper.selectCount(new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getUserId, id)));
        profile.setTopicCount(count);

        // 粉丝数
        int followers = Math.toIntExact(bmsFollowMapper.selectCount((new LambdaQueryWrapper<BmsFollow>().eq(BmsFollow::getParentId, id))));
        profile.setFollowerCount(followers);

        return profile;
    }
}
