package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.domain.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tiebo
* @description 针对表【bms_tag】的数据库操作Mapper
* @createDate 2023-09-23 11:02:44
* @Entity com.gc.system.domain.Tag
*/
@Mapper

public interface TagMapper extends BaseMapper<Tag> {

}




