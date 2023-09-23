package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.domain.Follow;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tiebo
* @description 针对表【bms_follow(用户关注)】的数据库操作Mapper
* @createDate 2023-09-23 11:02:36
* @Entity com.gc.system.domain.Follow
*/
@Mapper

public interface FollowMapper extends BaseMapper<Follow> {

}




