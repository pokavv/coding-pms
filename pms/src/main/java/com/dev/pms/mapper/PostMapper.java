package com.dev.pms.mapper;

import com.dev.pms.domain.PostDto;
import com.dev.pms.domain.PostVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostVo> getPosts(Long groupId);

    String getGroupName(Long groupId);

    void addPost(PostDto postDto);
}
