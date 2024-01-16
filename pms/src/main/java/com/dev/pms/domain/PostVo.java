package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostVo {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime postDate;

    private Long groupId;
    private Long userId;
    private String userName;
    private String groupName;
}
