package com.gc.system.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.dvo.PostVo;
import com.gc.system.service.PostService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public Result postList() {
        JSONObject res = new JSONObject();
        res.put("list", postService.list());
        return Result.Success(res);
    }

    @GetMapping("/{id}")
    public Result postById(@PathVariable("id") String id) {
        JSONObject res = new JSONObject();
        res.put("list", postService.getById(id));
        return Result.Success(res);
    }

    @PostMapping("/insert")
    public Result insertOne(@RequestBody PostVo postVo) {
        return Result.Success(null);
    }
}
