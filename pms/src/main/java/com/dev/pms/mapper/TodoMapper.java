package com.dev.pms.mapper;

import com.dev.pms.domain.TodoDto;
import com.dev.pms.domain.TodoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<TodoVo> getTodoListUncompleted(Long userId);

    List<TodoVo> getTodoListIsCompleted(Long userId);

    List<TodoVo> getTodoListAll(Long userId);

    TodoVo getTodoById(Long todoId);

    void insertTodo(TodoDto todoDto);

    void completeTodo(TodoDto todoDto);

    void deleteTodo(Long todoId);
}
