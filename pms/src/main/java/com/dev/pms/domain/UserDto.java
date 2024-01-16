package com.dev.pms.domain;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String website;

    public UserDto() {}

    public UserDto(String userName, String email, String password,
                   String phone, String website) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.website = website;
    }
}
