package com.dev.pms.controller;

import com.dev.pms.domain.GroupMemberVo;
import com.dev.pms.domain.PermissionVo;
import com.dev.pms.domain.UserVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.BelongService;
import com.dev.pms.service.GroupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BelongController {

    private final GroupService groupService;
    private final BelongService belongService;

    @GetMapping("/group-join/{groupId}/{userId}")
    public String isCorrectJoinUser(@PathVariable("groupId") Long groupId,
                                    @PathVariable("userId") Long userId,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userIdBySession = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (userIdBySession.equals(userId)) {
            if (belongService.checkBelongInfoByUser(userIdBySession, groupId) == null) {
                log.info("user = {}, group = {}", userIdBySession, groupId);
                return "group-join";
            }
        }
        return "redirect:/group-detail/{groupId}";
    }

    @PostMapping("/group-join/{groupId}/{userId}")
    public String joinGroup(@PathVariable("groupId") Long groupId,
                            @PathVariable("userId") Long userId,
                            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userIdBySession = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        String userNameBySession = (String) session.getAttribute(SessionConst.LOGIN_USER_NAME);
        log.info("시도 : userId[{}] join group[{}]", session.getAttribute(SessionConst.LOGIN_USER_NAME), groupId);

        if (userIdBySession.equals(userId)) {
            belongService.joinGroup(userId, groupId);

            model.addAttribute("userId", userIdBySession);
            model.addAttribute("userName", userNameBySession);
            model.addAttribute("groupId", groupId);

            return "redirect:/my-group";
        }
        return "redirect:/group-detail/{groupId}";
    }

    @GetMapping("/my-group/{groupId}/admin")
    public String groupAdmin(@PathVariable("groupId") Long groupId,
                             HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (belongService.checkManager(userId, groupId) == null) {
            log.info("매니저 권한이 없는 유저의 접근 userId = {}", userId);
            return "redirect:/my-group/{groupId}";
        }

        String groupName = groupService.getGroupById(groupId).getGroupName();
        List<GroupMemberVo> groupMember = belongService.getGroupMember(groupId);
        List<GroupMemberVo> groupManager = belongService.getGroupManager(groupId);
        List<GroupMemberVo> groupJunior = belongService.getGroupJunior(groupId);

        model.addAttribute("groupName", groupName);
        model.addAttribute("member", groupMember);
        model.addAttribute("manager", groupManager);
        model.addAttribute("junior", groupJunior);

        log.info("어드민 페이지 접근");

        return "group-admin";
    }

    @GetMapping("/my-group/{groupId}/admin/{userId}/grant-auth-true")
    public String grantAuthTrue(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId,
                                HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long sessionUserId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        PermissionVo permissionVo = belongService.checkManager(sessionUserId, groupId);
        if (permissionVo == null) {
            log.info("매니저 권한이 없는 유저의 접근 userId = {}", sessionUserId);
            return "redirect:/my-group/{groupId}";
        }
        belongService.grantAuthorityTrue(userId, groupId);
        log.info("접근 권한 부여");
        return "redirect:/my-group/{groupId}/admin";
    }

    @GetMapping("/my-group/{groupId}/admin/{userId}/grant-auth-manager")
    public String grantAuthManager(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long sessionUserId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        PermissionVo permissionVo = belongService.checkManager(sessionUserId, groupId);
        if (permissionVo == null) {
            log.info("매니저 권한이 없는 유저의 접근 userId = {}", sessionUserId);
            return "redirect:/my-group/{groupId}";
        }
        belongService.grantAuthorityManager(userId, groupId);
        log.info("관리자 접근 권한 부여");
        return "redirect:/my-group/{groupId}/admin";
    }

    @GetMapping("/my-group/{groupId}/admin/{userId}/delete-user")
    public String deleteUserByGroup(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long sessionUserId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        PermissionVo permissionVo = belongService.checkManager(sessionUserId, groupId);
        if (permissionVo == null) {
            log.info("매니저 권한이 없는 유저의 접근 userId = {}", sessionUserId);
            return "redirect:/my-group/{groupId}";
        }
        belongService.deleteUserByGroup(userId, groupId);
        log.info("[관리자 권한 실행 : 유저 삭제] 삭제된 userId = {}", userId);
        return "redirect:/my-group/{groupId}/admin";
    }
}
