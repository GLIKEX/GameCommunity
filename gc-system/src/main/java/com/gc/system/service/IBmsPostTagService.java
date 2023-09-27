package com.gc.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gc.system.model.entity.BmsPostTag;
import com.gc.system.model.entity.BmsTag;

import java.util.List;
import java.util.Set;

public interface IBmsPostTagService extends IService<BmsPostTag> {

    /**
     * 获取Topic Tag 关联记录
     *
     * @param topicId TopicId
     * @return
     */
    List<BmsPostTag> selectByTopicId(String topicId);
    /**
     * 创建中间关系
     *
     * @param id
     * @param tags
     * @return
     */
    void createTopicTag(String id, List<BmsTag> tags);
    /**
     * 获取标签换脸话题ID集合
     *
     * @param id
     * @return
     */
    Set<String> selectTopicIdsByTagId(String id);

}
