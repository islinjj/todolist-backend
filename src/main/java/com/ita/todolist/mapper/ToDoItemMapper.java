package com.ita.todolist.mapper;

import com.ita.todolist.dto.ToDoItemRequestDto;
import com.ita.todolist.dto.ToDoItemResponseDto;
import com.ita.todolist.entity.ToDoItem;

import java.util.List;
import java.util.stream.Collectors;

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
        return new ToDoItemResponseDto(toDoItem.getId(),toDoItem.getStatus(), toDoItem.getContent());
    }
    public static List<ToDoItemResponseDto> entitiesToResponseDtos(List<ToDoItem> toDoItems) {
        return toDoItems.stream().map(toDoItem -> entityToResponseDto(toDoItem)).collect(Collectors.toList());
    }

}
