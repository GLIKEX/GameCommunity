package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.Follow;
import com.gc.system.mapper.FollowMapper;
import com.gc.system.service.FollowService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【bms_follow(用户关注)】的数据库操作Service实现
* @createDate 2023-09-23 11:02:36
*/
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow>
    implements FollowService{

}




