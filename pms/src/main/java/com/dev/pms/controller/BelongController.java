package com.dev.pms.controller;

import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.BelongService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BelongController {

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
}
