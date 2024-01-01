package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostVo {

    private Long postId;
    private Long writerId;
    private String writer;
    private String title;
    private String postBody;
    private LocalDateTime postDate;
}
