package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupSearchCond {

    private Long groupId;
    private String groupName;
    private String groupDescription;
    private String groupAim;
    private LocalDateTime createDate;
    private Boolean isRecruit;
    private Boolean isCompleted;

    public GroupSearchCond() {}

    public GroupSearchCond(String groupName, String groupDescription, String groupAim,
                           Boolean isRecruit, Boolean isCompleted) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupAim = groupAim;
        this.isRecruit = isRecruit;
        this.isCompleted = isCompleted;
    }
}
