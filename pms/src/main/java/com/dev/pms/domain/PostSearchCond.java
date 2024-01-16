package com.dev.pms.domain;

import lombok.Data;

@Data
public class PostSearchCond {

    private Long postId;
    private String title;
    private String userName;
    private String groupName;
}
