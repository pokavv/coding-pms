package com.dev.pms.domain;

import lombok.Data;

@Data
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private Long groupId;

    public PostDto() {}

    public PostDto(String title, String content, Long groupId) {
        this.title = title;
        this.content = content;
        this.groupId = groupId;
    }
}
