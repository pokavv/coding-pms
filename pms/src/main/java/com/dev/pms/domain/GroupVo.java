package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupVo {

    private Long groupId;
    private String groupName;
    private String groupDescription;
    private String groupAim;
    private LocalDateTime createdDate;
    private Boolean isRecruit;
    private Boolean isCompleted;
}
