package com.dev.pms.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ErrorPageController {

    @RequestMapping("/error/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] 404 NOT FOUND", request);
        return "error-404";
    }

    @RequestMapping("/error/500")
    public String errorPage500(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] 500 INTERNAL SERVER ERROR", request);
        return "error-500";
    }
}
