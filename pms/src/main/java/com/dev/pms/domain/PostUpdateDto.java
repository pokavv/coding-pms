package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostUpdateDto {

    private String title;
    private String postBody;
    private LocalDateTime postDate;

    public PostUpdateDto() {}

    public PostUpdateDto(String title, String postBody, LocalDateTime postDate) {
        this.title = title;
        this.postBody = postBody;
        this.postDate = postDate;
    }
}
