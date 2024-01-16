package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentVo {

    private Long commentId;
    private String commentContent;
    private LocalDateTime commentDate;
    private Long userId;
    private Long postId;
}
