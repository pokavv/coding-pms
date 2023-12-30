package com.dev.pms.domain.post;

import com.dev.pms.domain.group.Group;
import com.dev.pms.domain.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Post {

    private Long postId;
    private String title;
    private String content;
    private LocalDateTime postDate;
    private User author;
    private Group written;

    public Post(String title, String content, LocalDateTime postDate, User author, Group written) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.author = author;
        this.written = written;
    }
}
