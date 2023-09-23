package com.gc.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gc.system.domain.Tag;
import com.gc.system.mapper.TagMapper;
import com.gc.system.service.TagService;
import org.springframework.stereotype.Service;

/**
* @author Tiebo
* @description 针对表【bms_tag】的数据库操作Service实现
* @createDate 2023-09-23 11:02:44
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




