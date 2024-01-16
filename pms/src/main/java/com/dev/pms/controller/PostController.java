package com.dev.pms.controller;

import com.dev.pms.domain.PostDto;
import com.dev.pms.domain.PostSearchCond;
import com.dev.pms.domain.PostVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.BelongService;
import com.dev.pms.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final BelongService belongService;

    @GetMapping("/posts/{groupId}")
    public String getPosts(@PathVariable("groupId") Long groupId,
                           @ModelAttribute("postSearchCond") PostSearchCond cond,
                           HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);

        if (isPermission(groupId, request)) {
            List<PostVo> posts = postService.getPosts(groupId, cond);
            String groupName = postService.getGroupName(groupId);

            model.addAttribute("posts", posts);
            model.addAttribute("groupId", groupId);
            model.addAttribute("groupName", groupName);

            log.info("groupName = {}", model.getAttribute("groupName"));
            log.info("model.posts = {}", model.getAttribute("posts"));
            return "post-list";
        }
        return "/login";
    }

    @GetMapping("/add-post/{groupId}")
    public String addPostForm(@PathVariable("groupId") Long groupId,
                          HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (isPermission(groupId, request)) {
            model.addAttribute("userId", userId);
            model.addAttribute("groupId", groupId);
            log.info("글작성 userId={}, groupId={}", userId, groupId);
            return "addPost";
        }
        return "/login";
    }

    @PostMapping("/add-post/{groupId}")
    public String addPost(@PathVariable("groupId") Long groupId,
                          PostDto postDto, HttpServletRequest request,
                          RedirectAttributes redirectAttributes) {
        if (isPermission(groupId, request)) {
            HttpSession session = request.getSession();
            Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
            postDto.setUserId(userId);
            postDto.setGroupId(groupId);
            postService.addPost(postDto);
            log.info("addPost={}", postDto);

            redirectAttributes.addAttribute("groupId", groupId);
            redirectAttributes.addAttribute("status", true);
            return "redirect:/posts/{groupId}";
        }
        return "/login";
    }

    @GetMapping("/post-detail/{postId}")
    public String postDetail(@PathVariable("postId") Long postId,
                             HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (belongService.checkPermissionReadPost(postId, userId) != null) {
            PostVo post = postService.getPost(postId);
            model.addAttribute("post", post);
            model.addAttribute("isPosted", isPosted(postId, userId));
            return "post-detail";
        }
        return "/";
    }

    private Boolean isPosted(Long postId, Long userId) {
        if (postService.getPost(postId).getUserId().equals(userId)) {
            log.info("해당 글의 작성자입니다.");
            return true;
        }
        log.info("해당 글의 작성자가 아닙니다.");
        return false;
    }

    private Boolean isPermission(Long groupId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (belongService.checkWritePermission(userId, groupId) != null) {
            log.info("그룹 접근 권한 O");
            return true;
        }
        log.info("그룹 접근 권한 X");
        return false;
    }
}
