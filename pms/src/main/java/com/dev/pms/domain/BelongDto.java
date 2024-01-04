package com.dev.pms.domain;

import lombok.Data;

@Data
public class BelongDto {

    private Long belongId;
    private Long userId;
    private Long groupId;
    private Boolean isAdmitted;
    private Boolean isManager;

    public BelongDto() {}

    public BelongDto(Long belongId, Long userId, Long groupId,
                     Boolean isAdmitted, Boolean isManager) {
        this.belongId = belongId;
        this.userId = userId;
        this.groupId = groupId;
        this.isAdmitted = isAdmitted;
        this.isManager = isManager;
    }
}
