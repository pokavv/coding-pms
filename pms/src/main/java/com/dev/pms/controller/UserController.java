package com.dev.pms.controller;

import com.dev.pms.domain.UserVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login(String email, String password, HttpServletRequest request,
                        @RequestParam(defaultValue = "/", required = false) String redirectURL) {
        Long loginId = userService.login(email, password);
        String username = userService.getUserById(loginId).getUserName();

        if (loginId == null) {
            log.info("로그인 실패");
            return "redirect:/login";
        }
        log.info("로그인 성공");
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginId);
        session.setAttribute(SessionConst.LOGIN_USER_NAME, username);
        log.info("HttpSession Session Info : loginId : {}, loginUserName : {}",
                session.getAttribute(SessionConst.LOGIN_USER), session.getAttribute(SessionConst.LOGIN_USER_NAME));
        return "redirect:" + redirectURL;
    }

    @GetMapping("/signup")
    public String toSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserVo userVo) {
        int duplicateCheck = userService.emailDuplicateCheck(userVo);
        if (duplicateCheck != 0) {
            log.info("이메일 중복!");
            return "redirect:/signup";
        }
        userService.signup(userVo);
        log.info("회원가입 완료");
        return "redirect:/login";
    }

    @GetMapping("/update")
    public String toUpdatePage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        UserVo userVo = userService.getUserById(userId);
        model.addAttribute("user", userVo);
        return "update-user";
    }

    @PostMapping("/update")
    public String modifyInfo(HttpSession session, UserVo userVo) {
        Long userId = (Long) session.getAttribute("userId");
        userVo.setUserId(userId);
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

    @GetMapping("/my-info")
    public String myInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        UserVo userVo = userService.getUserById(userId);
        model.addAttribute("user", userVo);
        log.info("user info = {}", userVo);

        return "my-info";
    }

    @GetMapping("/change-password")
    public String changePasswordForm(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        if (userService.getUserById(userId) != null) {
            return "change-password";
        }
        return "redirect:/login";
    }

    @PostMapping("/change-password")
    public String changePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        String password = userService.getUserById(userId).getPassword();

        if (!request.getParameter("old_password").equals(password)) {
            log.info("회원 비밀번호 변경 실패");
            return "redirect:/change-password-error";
        }

        String newPassword = request.getParameter("new_password");
        userService.changePassword(userId, newPassword);
        log.info("회원 비밀번호 변경 완료");
        return "redirect:/my-info";
    }

    @GetMapping("/change-password-error")
    public String changePasswordError() {
        return "change-password-error";
    }
}
