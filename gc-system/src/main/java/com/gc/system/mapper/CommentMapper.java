package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tiebo
* @description 针对表【bms_comment(评论表)】的数据库操作Mapper
* @createDate 2023-09-23 11:02:23
* @Entity com.gc.system.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}




