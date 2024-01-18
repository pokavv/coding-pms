package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long commentId;
    private String commentContent;
    private LocalDateTime commentDate;
    private Long postId;
    private Long userId;

    public CommentDto() {}

    public CommentDto(String commentContent, LocalDateTime commentDate, Long postId, Long userId) {
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.postId = postId;
        this.userId = userId;
    }
}
