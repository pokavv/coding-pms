package com.dev.pms.controller;

import com.dev.pms.filter.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HeaderController {

    @GetMapping("/home-group-list")
    public String groupList(HttpServletRequest request, Model model) {
        return "redirect:/group-list";
    }

    @GetMapping("/home-my-group")
    public String myGroup(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return "redirect:/my-group";
    }

    @GetMapping("/home-my-info")
    public String myInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return "redirect:/my-info";
    }
}
