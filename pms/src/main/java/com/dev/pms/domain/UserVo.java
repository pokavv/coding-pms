package com.dev.pms.domain;

import lombok.Data;

@Data
public class UserVo {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String website;
}
