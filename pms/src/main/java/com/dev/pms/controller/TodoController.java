package com.dev.pms.controller;

import com.dev.pms.domain.TodoVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo-list")
    public @ResponseBody List<TodoVo> getTodoList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        List<TodoVo> todo = todoService.getTodoList(userId);

        log.info("{}'s todoList init : {}",
                session.getAttribute(SessionConst.LOGIN_USER_NAME), todo);

        model.addAttribute("todoList", todo);
        log.info("model info: {}", model.getAttribute("todoList"));
        return todo;
    }
}
