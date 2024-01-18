package com.dev.pms.mapper;

import com.dev.pms.domain.CommentDto;
import com.dev.pms.domain.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    Integer countComment(Long postId);

    List<CommentVo> getCommentsByGroup(Long groupId);

    void addComment(CommentDto commentDto);

    CommentVo getCommentById(Long commentId);
}
