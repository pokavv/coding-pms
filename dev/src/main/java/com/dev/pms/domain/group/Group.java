package com.dev.pms.domain.group;

import com.dev.pms.domain.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Group {

    private Long groupId;
    private String name;
    private String description;

    private GroupAim aim;
    private GroupStatus status;
    private GroupPeriod period;
    private List<User> participants;

    public Group(String name, String description,
                 GroupAim aim, GroupStatus status,
                 GroupPeriod period, List<User> participants) {
        this.name = name;
        this.description = description;
        this.aim = aim;
        this.status = status;
        this.period = period;
        this.participants = participants;
    }
}
