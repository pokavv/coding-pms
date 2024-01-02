package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileImageDto {

    private Long imgId;
    private String originalName;
    private String saveName;
    private Long fileSize;
    private LocalDateTime uploadDate;
    private Long userId;

    public ProfileImageDto() {}

    public ProfileImageDto(String originalName, String saveName,
                           Long fileSize, LocalDateTime uploadDate, Long userId) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.userId = userId;
    }
}
