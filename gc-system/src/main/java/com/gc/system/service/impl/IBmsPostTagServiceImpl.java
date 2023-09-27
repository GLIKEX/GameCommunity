package com.gc.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.mapper.BmsPostTagMapper;
import com.gc.system.model.entity.BmsPostTag;
import com.gc.system.model.entity.BmsTag;
import com.gc.system.service.IBmsPostTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
@Transactional(rollbackFor = Exception.class)
public class IBmsPostTagServiceImpl extends ServiceImpl<BmsPostTagMapper, BmsPostTag> implements IBmsPostTagService {

    @Override
    public List<BmsPostTag> selectByTopicId(String topicId) {
        QueryWrapper<BmsPostTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BmsPostTag::getGameId, topicId);
        return this.baseMapper.selectList(wrapper);
    }
    @Override
    public void createTopicTag(String id, List<BmsTag> tags) {
        // 先删除topicId对应的所有记录
        this.baseMapper.delete(new LambdaQueryWrapper<BmsPostTag>().eq(BmsPostTag::getGameId, id));

        // 循环保存对应关联
        tags.forEach(tag -> {
            BmsPostTag topicTag = new BmsPostTag();
            topicTag.setGameId(id);
            topicTag.setTagId(tag.getId());
            this.baseMapper.insert(topicTag);
        });
    }
    @Override
    public Set<String> selectTopicIdsByTagId(String id) {
        return this.baseMapper.getPostIdsByTagId(id);
    }

}
