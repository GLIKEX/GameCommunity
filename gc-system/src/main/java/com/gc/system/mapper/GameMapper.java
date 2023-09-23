package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.domain.Game;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tiebo
* @description 针对表【bms_game(标签表)】的数据库操作Mapper
* @createDate 2023-09-23 11:02:38
* @Entity com.gc.system.domain.Game
*/
@Mapper

public interface GameMapper extends BaseMapper<Game> {

}




