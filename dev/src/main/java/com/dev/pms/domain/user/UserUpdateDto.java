package com.dev.pms.domain.user;

import lombok.Data;

@Data
public class UserUpdateDto {

    private String name;

    public UserUpdateDto() {}

    public UserUpdateDto(String name) {
        this.name = name;
    }
}
