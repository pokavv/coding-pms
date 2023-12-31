package com.dev.pms.controller;

import com.dev.pms.domain.UserVo;
import com.dev.pms.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String getUserList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("list", userList);
        return "userList";
    }

    @GetMapping("/login")
    public String toLoginPage(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) { // 이미 로그인한 상태
            return "redirect:/";
        }
        return "login"; // 비로그인 상태
    }

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session) {
        Long loginId = userService.login(email, password);
        if (loginId == null) {
            log.info("로그인 실패");
            return "redirect:/login";
        }
        log.info("로그인 성공");
        session.setAttribute("userId", loginId);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String toSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserVo userVo) {
        try {
            userService.signup(userVo);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error-code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error-code=-99";
        }
        log.info("회원가입 완료");
        return "redirect:/login";
    }

    @GetMapping("/update")
    public String toUpdatePage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        UserVo userVo = userService.getUserById(userId);
        model.addAttribute("user", userVo);
        return "update";
    }

    @PostMapping("/update")
    public String modifyInfo(HttpSession session, UserVo userVo) {
        Long userId = (Long) session.getAttribute("userId");
        userVo.setId(userId);
        userService.modifyInfo(userVo);
        log.info("회원정보수정 완료");
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        log.info("로그아웃 성공");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String withdraw(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            userService.withdraw(userId);
            log.info("회원탈퇴 완료");
            session.invalidate();
            return "redirect:/";
        }
        return "redirect:/";
    }
}
