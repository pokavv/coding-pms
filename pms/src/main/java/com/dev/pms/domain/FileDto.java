package com.dev.pms.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FileDto {

    private Long fileId;
    private String originalName;
    private String saveName;
    private Long fileSize;
    private LocalDateTime uploadDate;
    private Long postId;

    public FileDto() {}

    @Builder
    public FileDto(String originalName, String saveName,
                   Long fileSize, LocalDateTime uploadDate, Long postId) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.postId = postId;
    }
}
