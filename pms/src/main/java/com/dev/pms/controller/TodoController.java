package com.dev.pms.controller;

import com.dev.pms.domain.TodoDto;
import com.dev.pms.domain.TodoVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo-list")
    public List<TodoVo> getTodoList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return todoService.getTodoList(userId);
    }

    @PostMapping("/add-todo")
    public TodoVo addTodo(HttpServletRequest request,
                          @RequestBody TodoDto addTodoParams) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        addTodoParams.setUserId(userId);
        todoService.addTodo(addTodoParams);

        Long todoId = addTodoParams.getTodoId();
        return todoService.getTodoById(todoId);
    }
}
