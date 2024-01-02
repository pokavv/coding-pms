package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupDto {

    private Long groupId;
    private String groupName;
    private String groupDescription;
    private String groupAim;
    private LocalDateTime createdDate;
    private Boolean isRecruit;
    private Boolean isCompleted;

    public GroupDto() {}

    public GroupDto(String groupName, String groupDescription, String groupAim,
                    LocalDateTime createdDate, Boolean isRecruit, Boolean isCompleted) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupAim = groupAim;
        this.createdDate = createdDate;
        this.isRecruit = isRecruit;
        this.isCompleted = isCompleted;
    }
}
