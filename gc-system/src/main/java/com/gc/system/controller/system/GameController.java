package com.gc.system.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.gc.system.dvo.GameVo;
import com.gc.system.service.GameService;
import com.gc.system.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/list")
    public Result gameList() {
        JSONObject res = new JSONObject();
        res.put("list", gameService.list());
        return Result.Success(res);
    }

    @GetMapping("/{id}")
    public Result gameById(@PathVariable("id") String id) {
        JSONObject res = new JSONObject();
        res.put("list", gameService.getById(id));
        return Result.Success(res);
    }

    @PostMapping("/insert")
    public Result insertOne(@RequestBody GameVo gameVo) {
        return gameService.insertOne(gameVo);
    }
}
