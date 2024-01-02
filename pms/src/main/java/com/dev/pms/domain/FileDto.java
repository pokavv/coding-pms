package com.dev.pms.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDto {

    private Long fileId;
    private String originalName;
    private String saveName;
    private Long fileSize;
    private LocalDateTime uploadDate;

    public FileDto() {}

    public FileDto(String originalName, String saveName,
                   Long fileSize, LocalDateTime uploadDate) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
    }
}
