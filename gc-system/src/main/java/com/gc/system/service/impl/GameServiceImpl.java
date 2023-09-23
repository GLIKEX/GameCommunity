package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.Game;
import com.gc.system.mapper.GameMapper;
import com.gc.system.service.GameService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【bms_game(标签表)】的数据库操作Service实现
* @createDate 2023-09-23 11:02:38
*/
@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game>
    implements GameService{

}




