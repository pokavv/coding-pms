package com.dev.pms.service;

import com.dev.pms.domain.CommentDto;
import com.dev.pms.domain.CommentVo;
import com.dev.pms.mapper.CommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public Integer countComment(Long postId) {
        return commentMapper.countComment(postId);
    }

    public List<CommentVo> getCommentsByGroup(Long postId) {
        return commentMapper.getCommentsByGroup(postId);
    }

    public void addComment(CommentDto commentDto) {
        commentMapper.addComment(commentDto);
    }

    public CommentVo getCommentById(Long commentId) {
        return commentMapper.getCommentById(commentId);
    }
}
