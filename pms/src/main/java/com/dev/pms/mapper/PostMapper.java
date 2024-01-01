package com.dev.pms.mapper;

import com.dev.pms.domain.PostSearchCond;
import com.dev.pms.domain.PostUpdateDto;
import com.dev.pms.domain.PostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostVo> getPostsByTitle(String title);

    List<PostVo> getPostsByWriter(String writer);

    List<PostVo> getPostsByCond(PostSearchCond cond);

    PostVo getPostById(Long postId);

    void save(PostVo post);

    void update(@Param("postId") Long postId,
                @Param("updateParam") PostUpdateDto updateParam);

    void delete(Long postId);

    String getWriter(Long writerId);
}
