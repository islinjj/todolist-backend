package com.ita.todolist.mapper;

import com.ita.todolist.dto.ToDoItemRequestDto;
import com.ita.todolist.dto.ToDoItemResponseDto;
import com.ita.todolist.entity.ToDoItem;

/**
 * @Author LINVI7
 * @Date 8/6/2020 8:29 PM
 * @Version 1.0
 */
public class ToDoItemMapper {
    public static ToDoItem requestToEntity(ToDoItemRequestDto toDoItemRequest) {
        return new ToDoItem(toDoItemRequest.getStatus(), toDoItemRequest.getContent());
    }

    public static ToDoItemResponseDto entityToResponseDto(ToDoItem toDoItem) {
        return new ToDoItemResponseDto(toDoItem.getStatus(), toDoItem.getContent());
    }
}
