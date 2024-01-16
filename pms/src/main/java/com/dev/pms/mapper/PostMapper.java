package com.dev.pms.mapper;

import com.dev.pms.domain.PostDto;
import com.dev.pms.domain.PostSearchCond;
import com.dev.pms.domain.PostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostVo> getPosts(@Param("groupId") Long groupId,
                          @Param("postSearchCond") PostSearchCond cond);

    String getGroupName(Long groupId);

    void addPost(PostDto postDto);

    PostVo getPost(Long postId);
}
