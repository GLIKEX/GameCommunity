package com.gc.system.controller;

import com.gc.system.common.api.ApiResult;
import com.gc.system.model.dto.CommentDTO;
import com.gc.system.model.entity.BmsComment;
import com.gc.system.model.entity.User;
import com.gc.system.model.vo.CommentVO;
import com.gc.system.service.IBmsCommentService;
import com.gc.system.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.gc.system.config.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/comment")
public class BmsCommentController extends BaseController {

    @Resource
    private IBmsCommentService bmsCommentService;
    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(topicid);
        return ApiResult.success(lstBmsComment);
    }
    @PostMapping("/add_comment")
    public ApiResult<BmsComment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                             @RequestBody CommentDTO dto) {
        User user = umsUserService.getUserByUsername(userName);
        BmsComment comment = bmsCommentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
