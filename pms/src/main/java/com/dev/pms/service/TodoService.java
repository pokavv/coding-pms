package com.dev.pms.service;

import com.dev.pms.domain.TodoDto;
import com.dev.pms.domain.TodoVo;
import com.dev.pms.mapper.TodoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public List<TodoVo> getTodoListUncompleted(Long userId) {
        return todoMapper.getTodoListUncompleted(userId);
    }

    public List<TodoVo> getTodoListIsCompleted(Long userId) {
        return todoMapper.getTodoListIsCompleted(userId);
    }

    public List<TodoVo> getTodoListAll(Long userId) {
        return todoMapper.getTodoListAll(userId);
    }

    public TodoVo getTodoById(Long todoId) {
        return todoMapper.getTodoById(todoId);
    }

    public void addTodo(TodoDto todoDto) {
        todoMapper.insertTodo(todoDto);
    }

    public void completeTodo(TodoDto todoDto) {
        todoMapper.completeTodo(todoDto);
    }

    public void deleteTodo(Long todoId) {
        todoMapper.deleteTodo(todoId);
    }
}
