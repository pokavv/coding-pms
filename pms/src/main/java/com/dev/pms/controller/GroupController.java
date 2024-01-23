package com.dev.pms.controller;

import com.dev.pms.domain.GroupSearchCond;
import com.dev.pms.domain.GroupVo;
import com.dev.pms.domain.PermissionVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.BelongService;
import com.dev.pms.service.GroupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final BelongService belongService;

    @GetMapping("/userGroup-list")
    public @ResponseBody List<GroupVo> getGroupByUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return groupService.getGroupByUser(userId);
    }

    @GetMapping("/group-list")
    public String groupList(@ModelAttribute("groupSearchCond")GroupSearchCond cond,
                            HttpServletRequest request,
                            Model model) {
        List<GroupVo> groupAll = groupService.getGroupAll(cond);
        model.addAttribute("groups", groupAll);
        log.info("model.group-list = {}", model.getAttribute("groups"));
        return "groupList";
    }

    @GetMapping("/group-detail/{groupId}")
    public String groupDetail(@PathVariable Long groupId,
                              HttpServletRequest request,
                              Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        model.addAttribute("userId", userId);

        GroupVo groupById = groupService.getGroupById(groupId);
        model.addAttribute("group", groupById);
        log.info("group-detail-info = {}, userId = {}", model.getAttribute("group"), userId);
        return "group-detail";
    }

    @GetMapping("/my-group")
    public String myGroup(HttpServletRequest request,
                          Model model) {
        HttpSession session = request.getSession();
        Long userIdBySession = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        List<GroupVo> groupByUser = groupService.getGroupByUser(userIdBySession);

        model.addAttribute("groups", groupByUser);
        log.info("{}'s group = {}", session.getAttribute(SessionConst.LOGIN_USER_NAME), model.getAttribute("groups"));
        return "myGroup";
    }

    @GetMapping("/my-group/{groupId}")
    public String myGroup(@PathVariable("groupId") Long groupId,
                          HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        String userName = (String) session.getAttribute(SessionConst.LOGIN_USER_NAME);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);

        Boolean isManager = groupService.checkAuthManagerBySessionId(groupId, userId);
        model.addAttribute("isManager", isManager);

        GroupVo groupById = groupService.getGroupById(groupId);
        model.addAttribute("group", groupById);

        return "my-group-detail";
    }

    @GetMapping("/create-group")
    public String createGroupForm() {
        return "create-group";
    }

    @PostMapping("/create-group")
    public String createGroup(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);

        String groupName = request.getParameter("groupName");
        String groupDescription = request.getParameter("groupDescription");
        String groupAim = request.getParameter("groupAim");

        groupService.createGroup(groupName, groupDescription, groupAim);
        Long groupId = groupService.getRecentAddGroupId();
        belongService.addBelongCreateUser(userId, groupId);
        return "redirect:/group-list";
    }
}
