package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long commentId;
    private String commentContent;
    private LocalDateTime commentDate;

    public CommentDto() {}

    public CommentDto(String commentContent, LocalDateTime commentDate) {
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }
}
