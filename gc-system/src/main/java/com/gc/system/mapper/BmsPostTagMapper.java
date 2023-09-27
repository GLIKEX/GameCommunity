package com.gc.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.system.model.entity.BmsPostTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;


@Mapper
public interface BmsPostTagMapper extends BaseMapper<BmsPostTag> {
    /**
     * 根据标签获取话题ID集合
     *
     * @param id
     * @return
     */
    Set<String> getPostIdsByTagId(@Param("id") String id);
}
