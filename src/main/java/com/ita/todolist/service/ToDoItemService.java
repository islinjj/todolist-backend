package com.ita.todolist.service;

import com.ita.todolist.entity.ToDoItem;

import java.util.List;

/**
 * @Author LINVI7
 * @Date 8/6/2020 6:59 PM
 * @Version 1.0
 */
public interface ToDoItemService {
    List<ToDoItem> getAllTodoItem();

    ToDoItem addToDoItem(ToDoItem toDoItem);

    void deleteToDoItemById(Integer toDoItemId);

    ToDoItem updateToDoItem(ToDoItem toDoItem);
}
