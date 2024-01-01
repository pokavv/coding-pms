package com.dev.pms.mapper;

import com.dev.pms.domain.TodoDto;
import com.dev.pms.domain.TodoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    TodoVo getTodoList(Long userId);

    TodoVo getTodoById(Long todoId);

    void insertTodo(TodoDto todoDto);

    void completeTodo(TodoDto todoDto);

    void deleteTodo(Long todoId);
}