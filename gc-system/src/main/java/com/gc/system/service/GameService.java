package com.gc.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gc.system.domain.Game;
import com.gc.system.dvo.GameVo;
import com.gc.system.vo.Result;

/**
* @author Tiebo
* @description 针对表【bms_game(标签表)】的数据库操作Service
* @createDate 2023-09-23 11:02:38
*/
public interface GameService extends IService<Game> {
    Result insertOne(GameVo gameVo);
}
