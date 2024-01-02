package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileImageVo {

    private Long imgId;
    private String originalName;
    private String saveName;
    private Long fileSize;
    private LocalDateTime uploadDate;
    private Long userId;
}
