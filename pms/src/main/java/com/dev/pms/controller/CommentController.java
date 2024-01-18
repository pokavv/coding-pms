package com.dev.pms.controller;

import com.dev.pms.domain.CommentDto;
import com.dev.pms.domain.CommentVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/post-detail/{postId}/comment-list")
    public @ResponseBody List<CommentVo> comments(@PathVariable Long postId) {
        List<CommentVo> commentsByGroup = commentService.getCommentsByGroup(postId);
        log.info("comments={}", commentsByGroup);
        return commentsByGroup;
    }

    @PostMapping("/post-detail/{postId}/add-comment")
    public @ResponseBody CommentVo addComment(@PathVariable("postId") Long postId,
                                 HttpServletRequest request,
                                 @RequestBody CommentDto commentParams) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        commentParams.setUserId(userId);
        commentParams.setPostId(postId);
        commentService.addComment(commentParams);

        Long commentId = commentParams.getCommentId();
        return commentService.getCommentById(commentId);
    }
}
