package com.ita.todolist.service.impl;

import com.ita.todolist.entity.ToDoItem;
import com.ita.todolist.repository.ToDoItemRepository;
import com.ita.todolist.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LINVI7
 * @Date 8/6/2020 7:01 PM
 * @Version 1.0
 */
@Service
public class ToDoItemServiceImpl implements ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Override
    public List<ToDoItem> getAllTodoItem() {
        return toDoItemRepository.findAll();
    }
}
