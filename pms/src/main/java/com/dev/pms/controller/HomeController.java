package com.dev.pms.controller;

import com.dev.pms.domain.UserVo;
import com.dev.pms.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            UserVo userVo = userService.getUserById(userId);
            model.addAttribute("user", userVo);
            return "home";
        }
        return "redirect:/login";
    }
}