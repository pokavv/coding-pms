package com.dev.pms.domain.user;

import com.dev.pms.domain.group.Group;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private Long userId;
    private String name;
    private String email;
    private Role role;

    private List<Group> participation = new ArrayList<Group>();

    public User() {}

    private User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = Role.GUEST;
    }
}
