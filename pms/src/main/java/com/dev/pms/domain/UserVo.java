package com.dev.pms.domain;

import lombok.Data;

@Data
public class UserVo {

    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String website;
}
