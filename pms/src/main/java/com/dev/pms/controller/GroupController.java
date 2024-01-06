package com.dev.pms.controller;

import com.dev.pms.domain.GroupVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.GroupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/userGroup-list")
    public @ResponseBody List<GroupVo> getGroupByUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return groupService.getGroupByUer(userId);
    }
}
