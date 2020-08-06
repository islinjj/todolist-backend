package com.ita.todolist.controller;

import com.ita.todolist.entity.ToDoItem;
import com.ita.todolist.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LINVI7
 * @Date 8/6/2020 9:17 PM
 * @Version 1.0
 */
@RestController
@RequestMapping("/todos")
public class ToDoItemController {
    @Autowired
    private ToDoItemService toDoItemService;

    @GetMapping
    public List<ToDoItem> getAllToDoItem() {
        return toDoItemService.getAllTodoItem();
    }

}
