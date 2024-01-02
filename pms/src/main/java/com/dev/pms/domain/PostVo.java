package com.dev.pms.domain;

import lombok.Data;

@Data
public class PostVo {

    private Long postId;
    private String title;
    private String content;
    private Long groupId;
}
