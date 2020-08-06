package com.ita.todolist.controller;

import com.ita.todolist.dto.ToDoItemRequestDto;
import com.ita.todolist.dto.ToDoItemResponseDto;
import com.ita.todolist.entity.ToDoItem;
import com.ita.todolist.mapper.ToDoItemMapper;
import com.ita.todolist.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/{id}")
    public ToDoItemResponseDto updateToDoItem(@PathVariable int id, @RequestBody ToDoItem toDoItem) {
        ToDoItem newToDoItem = toDoItemService.updateToDoItem(toDoItem);
        return ToDoItemMapper.entityToResponseDto(newToDoItem);
    }

    @DeleteMapping(path = "/{id}")
    public List<ToDoItemResponseDto> deleteToDoItem(@PathVariable int id) {
        toDoItemService.deleteToDoItemById(id);
        List<ToDoItem> allTodoItem = toDoItemService.getAllTodoItem();
        return ToDoItemMapper.entitiesToResponseDtos(allTodoItem);
    }

    @PostMapping
    public List<ToDoItemResponseDto> addToDoItem(@RequestBody ToDoItemRequestDto toDoItemRequestDto) {
        ToDoItem toDoItem = ToDoItemMapper.requestToEntity(toDoItemRequestDto);
        toDoItemService.addToDoItem(toDoItem);
        List<ToDoItem> allTodoItem = toDoItemService.getAllTodoItem();
        return ToDoItemMapper.entitiesToResponseDtos(allTodoItem);
    }
}
