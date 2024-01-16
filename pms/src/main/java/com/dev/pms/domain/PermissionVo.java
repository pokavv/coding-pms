package com.dev.pms.domain;

import lombok.Data;

@Data
public class PermissionVo {

    private Long belongId;
    private Long userId;
    private Long groupId;
    private Boolean isAdmitted;
    private Boolean isManager;
}
