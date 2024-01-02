package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileVo {

    private Long fileId;
    private String originalName;
    private String saveName;
    private Long fileSize;
    private LocalDateTime uploadDate;
}
