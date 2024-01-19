package com.dev.pms.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime postDate;
    private Long groupId;
    private Long userId;
    private List<MultipartFile> files;

    public PostDto() {}

    public PostDto(String title, String content, LocalDateTime postDate,
                   Long groupId, Long userId) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.groupId = groupId;
        this.userId = userId;
    }
}