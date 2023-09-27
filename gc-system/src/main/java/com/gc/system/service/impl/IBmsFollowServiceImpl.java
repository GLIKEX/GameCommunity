package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.mapper.BmsFollowMapper;
import com.gc.system.model.entity.BmsFollow;
import com.gc.system.service.IBmsFollowService;
import org.springframework.stereotype.Service;


@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper, BmsFollow> implements IBmsFollowService {
}
