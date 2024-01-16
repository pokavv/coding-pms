package com.dev.pms.service;

import com.dev.pms.domain.PostDto;
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
    PostMapper postMapper;

    public List<PostVo> getPosts(Long groupId) {
        return postMapper.getPosts(groupId);
    }

    public String getGroupName(Long groupId) {
        return postMapper.getGroupName(groupId);
    }

    public void addPost(PostDto postDto) {
        postMapper.addPost(postDto);
    }
}
