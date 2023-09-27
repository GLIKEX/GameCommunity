package com.gc.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gc.system.common.api.ApiResult;
import com.gc.system.common.exception.ApiAsserts;
import com.gc.system.model.entity.BmsFollow;
import com.gc.system.model.entity.User;
import com.gc.system.service.IBmsFollowService;
import com.gc.system.service.IUmsUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.gc.system.config.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/relationship")
public class BmsRelationshipController extends BaseController {

    @Resource
    private IBmsFollowService bmsFollowService;

    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/subscribe/{userId}")
    public ApiResult<Object> handleFollow(@RequestHeader(value = USER_NAME) String userName
            , @PathVariable("userId") String parentId) {
        User user = umsUserService.getUserByUsername(userName);
        if (parentId.equals(user.getId())) {
            ApiAsserts.fail("怎么可以关注自己呢 😮");
        }
        BmsFollow one = bmsFollowService.getOne(
                new LambdaQueryWrapper<BmsFollow>()
                        .eq(BmsFollow::getParentId, parentId)
                        .eq(BmsFollow::getFollowerId, user.getId()));
        if (!ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("已关注");
        }

        BmsFollow follow = new BmsFollow();
        follow.setParentId(parentId);
        follow.setFollowerId(user.getId());
        bmsFollowService.save(follow);
        return ApiResult.success(null, "关注成功");
    }

    @GetMapping("/unsubscribe/{userId}")
    public ApiResult<Object> handleUnFollow(@RequestHeader(value = USER_NAME) String userName
            , @PathVariable("userId") String parentId) {
        User user = umsUserService.getUserByUsername(userName);
        BmsFollow one = bmsFollowService.getOne(
                new LambdaQueryWrapper<BmsFollow>()
                        .eq(BmsFollow::getParentId, parentId)
                        .eq(BmsFollow::getFollowerId, user.getId()));
        if (ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("未关注！");
        }
        bmsFollowService.remove(new LambdaQueryWrapper<BmsFollow>().eq(BmsFollow::getParentId, parentId)
                .eq(BmsFollow::getFollowerId, user.getId()));
        return ApiResult.success(null, "取关成功");
    }

    @GetMapping("/validate/{topicUserId}")
    public ApiResult<Map<String, Object>> isFollow(@RequestHeader(value = USER_NAME) String userName
            , @PathVariable("topicUserId") String topicUserId) {
        User user = umsUserService.getUserByUsername(userName);
        Map<String, Object> map = new HashMap<>(16);
        map.put("hasFollow", false);
        if (!ObjectUtils.isEmpty(user)) {
            BmsFollow one = bmsFollowService.getOne(new LambdaQueryWrapper<BmsFollow>()
                    .eq(BmsFollow::getParentId, topicUserId)
                    .eq(BmsFollow::getFollowerId, user.getId()));
            if (!ObjectUtils.isEmpty(one)) {
                map.put("hasFollow", true);
            }
        }
        return ApiResult.success(map);
    }
}
