package com.gc.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gc.system.model.dto.CommentDTO;
import com.gc.system.model.entity.BmsComment;
import com.gc.system.model.entity.User;
import com.gc.system.model.vo.CommentVO;

import java.util.List;

public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, User principal);
}
