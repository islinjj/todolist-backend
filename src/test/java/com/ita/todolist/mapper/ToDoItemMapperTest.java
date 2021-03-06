package com.ita.todolist.mapper;

import com.ita.todolist.dto.ToDoItemRequestDto;
import com.ita.todolist.dto.ToDoItemResponseDto;
import com.ita.todolist.entity.ToDoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LINVI7
 * @Date 8/6/2020 8:22 PM
 * @Version 1.0
 */
public class ToDoItemMapperTest {
    @Test
    void should_return_entity_when_map_request_dto_to_entity_given_request_dto() {
        //given
        ToDoItemRequestDto toDoItemRequest = new ToDoItemRequestDto(false, "vicky");

        //when
        ToDoItem toDoItem = ToDoItemMapper.requestToEntity(toDoItemRequest);

        //then
        Assertions.assertEquals(toDoItemRequest.getContent(),toDoItem.getContent());
        Assertions.assertEquals(toDoItem.getStatus(),toDoItemRequest.getStatus());
    }

    @Test
    void should_return_to_do_item_response_dto_when_map_entity_to_response_dto_given_entity() {
        //given
        ToDoItem toDoItem = new ToDoItem(1,false,"vicky");

        //when
        ToDoItemResponseDto toDoItemResponseDto = ToDoItemMapper.entityToResponseDto(toDoItem);

        //then
        Assertions.assertEquals(toDoItemResponseDto.getContent(),toDoItem.getContent());
        Assertions.assertEquals(toDoItemResponseDto.getStatus(),toDoItem.getStatus());
    }

    @Test
    void should_return_size_2_when_entities_map_to_dtos_given_2_entity(){
        //given
        ToDoItem toDoItem2 = new ToDoItem(1,false,"vicky");
        ToDoItem toDoItem1 = new ToDoItem(1,false,"vicky");
        ArrayList<ToDoItem> toDoItems = new ArrayList<>();
        toDoItems.add(toDoItem2);
        toDoItems.add(toDoItem1);
        //when
        List<ToDoItemResponseDto> toDoItemResponseDtos = ToDoItemMapper.entitiesToResponseDtos(toDoItems);
        //then
        Assertions.assertEquals(2,toDoItemResponseDtos.size());
    }
}
