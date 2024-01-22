package com.dev.pms.domain;

import lombok.Data;

@Data
public class GroupMemberVo {

    private Long belongId;
    private Boolean isAdmitted;
    private Boolean isManager;

    private Long userId;
    private String userName;
    private String email;
    private String phone;
    private String website;

    private Long groupId;
}
