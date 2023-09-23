package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.Post;
import com.gc.system.mapper.PostMapper;
import com.gc.system.service.PostService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【bms_post(话题表)】的数据库操作Service实现
* @createDate 2023-09-23 11:02:42
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

}




