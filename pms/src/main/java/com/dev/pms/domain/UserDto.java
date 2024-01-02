package com.dev.pms.domain;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String website;

    public UserDto() {}

    public UserDto(String name, String email, String password,
                   String phone, String website) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.website = website;
    }
}
