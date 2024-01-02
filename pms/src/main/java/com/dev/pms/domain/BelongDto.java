package com.dev.pms.domain;

import lombok.Data;

@Data
public class BelongDto {

    private Long belongId;
    private Long userId;
    private Long groupId;

    public BelongDto() {}

    public BelongDto(Long belongId, Long userId, Long groupId) {
        this.belongId = belongId;
        this.userId = userId;
        this.groupId = groupId;
    }
}
