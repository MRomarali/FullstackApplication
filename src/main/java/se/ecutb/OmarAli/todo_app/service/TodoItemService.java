package se.ecutb.OmarAli.todo_app.service;

import se.ecutb.OmarAli.todo_app.dto.TodoFormDto;
import se.ecutb.OmarAli.todo_app.entity.AppUser;
import se.ecutb.OmarAli.todo_app.entity.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoItemService {

    TodoItem create(TodoFormDto itemFormDto);
    TodoItem save(TodoItem todoItem);
    Optional<TodoItem> findById(int todoItemId);
    List<TodoItem> findByAssignee(AppUser appUser);
    Optional<TodoItem> findByTitle(String todoTitle);
    List<TodoItem> findAll();
}
