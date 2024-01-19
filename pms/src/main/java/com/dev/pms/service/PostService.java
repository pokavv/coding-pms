package com.dev.pms.service;

import com.dev.pms.domain.PostDto;
import com.dev.pms.domain.PostSearchCond;
import com.dev.pms.domain.PostVo;
import com.dev.pms.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<PostVo> getPosts(Long groupId, PostSearchCond cond) {
        return postMapper.getPosts(groupId, cond);
    }

    public String getGroupName(Long groupId) {
        return postMapper.getGroupName(groupId);
    }

    public void addPost(PostDto postDto) {
        postMapper.addPost(postDto);
    }

    public PostVo getPost(Long postId) {
        return postMapper.getPost(postId);
    }

    public void updatePost(Long postId, String title, String content) {
        postMapper.updatePost(postId, title, content);
    }

    public void deletePost(Long postId) {
        postMapper.deletePost(postId);
    }

    public Long getRecentPostId() {
        return postMapper.getRecentPostId();
    }
}
