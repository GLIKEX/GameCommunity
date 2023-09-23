package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.Comment;
import com.gc.system.mapper.CommentMapper;
import com.gc.system.service.CommentService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【bms_comment(评论表)】的数据库操作Service实现
* @createDate 2023-09-23 11:02:23
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




