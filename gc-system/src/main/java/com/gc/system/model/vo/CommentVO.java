package com.gc.system.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

    private String id;

    private String content;

    private String postId;

    private String userId;

    private String username;

    private Date createTime;

}
