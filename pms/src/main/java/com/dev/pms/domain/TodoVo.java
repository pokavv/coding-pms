package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoVo {

    private Long todoId;
    private String todoContent;
    private LocalDateTime todoDate;
    private Boolean isCompleted;
    private Long userId;
}
