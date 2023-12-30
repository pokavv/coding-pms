package com.dev.pms.repository.user;

import com.dev.pms.domain.user.Role;
import lombok.Data;

@Data
public class UserSearchCond {

    private String userId;
    private String name;
    private Role role;

    public UserSearchCond() {}

    public UserSearchCond(String userId, String name, Role role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }
}
