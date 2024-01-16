package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime postDate;
    private Long groupId;
    private Long userId;

    public PostDto() {}

    public PostDto(String title, String content, LocalDateTime postDate,
                   Long groupId, Long userId) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.groupId = groupId;
        this.userId = userId;
    }
}
