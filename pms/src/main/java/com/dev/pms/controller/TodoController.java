package com.dev.pms.controller;

import com.dev.pms.domain.TodoDto;
import com.dev.pms.domain.TodoVo;
import com.dev.pms.filter.SessionConst;
import com.dev.pms.service.TodoService;
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
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo-list")
    @ResponseBody
    public List<TodoVo> getTodoList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        return todoService.getTodoListUncompleted(userId);
    }

    @PostMapping("/add-todo")
    @ResponseBody
    public TodoVo addTodo(HttpServletRequest request,
                          @RequestBody TodoDto addTodoParams) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        addTodoParams.setUserId(userId);
        todoService.addTodo(addTodoParams);

        Long todoId = addTodoParams.getTodoId();
        return todoService.getTodoById(todoId);
    }

    @GetMapping("/todo-list/{userId}")
    public String userTodoFindAll(@PathVariable Long userId,
                                  HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        List<TodoVo> todoListUncompleted = todoService.getTodoListUncompleted(userId);
        List<TodoVo> todoListIsCompleted = todoService.getTodoListIsCompleted(userId);

        model.addAttribute("todoUncompleted", todoListUncompleted);
        model.addAttribute("todoCompleted", todoListIsCompleted);
        log.info("uncompleted todoList = {}", todoListUncompleted);
        log.info("completed todoList = {}", todoListIsCompleted);

        return "userTodoList";
    }

    @GetMapping("/todo-detail/{todoId}")
    public String todoDetail(@PathVariable Long todoId, Model model) {
        TodoVo todoById = todoService.getTodoById(todoId);
        model.addAttribute("todo", todoById);
        return "todo-detail";
    }
}
