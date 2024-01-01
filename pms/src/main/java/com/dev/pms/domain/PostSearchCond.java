package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostSearchCond {

    private String title;
    private String writer;

    public PostSearchCond() {}

    public PostSearchCond(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }
}
