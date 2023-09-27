package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.model.entity.BmsComment;
import com.gc.system.model.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BmsCommentMapper extends BaseMapper<BmsComment> {

    /**
     * getCommentsByTopicID
     *
     * @param postid
     * @return
     */
    List<CommentVO> getCommentsByTopicID(@Param("postid") String postid);
}
