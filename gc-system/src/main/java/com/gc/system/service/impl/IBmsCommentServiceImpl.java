package com.gc.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.mapper.BmsCommentMapper;
import com.gc.system.model.dto.CommentDTO;
import com.gc.system.model.entity.BmsComment;
import com.gc.system.model.entity.User;
import com.gc.system.model.vo.CommentVO;
import com.gc.system.service.IBmsCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class IBmsCommentServiceImpl extends ServiceImpl<BmsCommentMapper, BmsComment> implements IBmsCommentService {
    @Override
    public List<CommentVO> getCommentsByTopicID(String topicid) {
        List<CommentVO> lstBmsComment = new ArrayList<CommentVO>();
        try {
            lstBmsComment = this.baseMapper.getCommentsByTopicID(topicid);
        } catch (Exception e) {
            log.info("lstBmsComment失败");
        }
        return lstBmsComment;
    }

    @Override
    public BmsComment create(CommentDTO dto, User user) {
        BmsComment comment = BmsComment.builder()
                .userId(user.getId())
                .content(dto.getContent())
                .postId(dto.getTopic_id())
                .createTime(new Date())
                .build();
        this.baseMapper.insert(comment);
        return comment;
    }
}
