package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {

    private Long todoId;
    private String todoContent;
    private LocalDateTime todoDate;
    private Boolean isCompleted;
    private Long userId;

    public TodoDto() {}

    public TodoDto(String todoContent, LocalDateTime todoDate,
                   Boolean isCompleted, Long userId) {
        this.todoContent = todoContent;
        this.todoDate = todoDate;
        this.isCompleted = isCompleted;
        this.userId = userId;
    }
}
