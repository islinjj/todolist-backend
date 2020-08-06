package com.ita.todolist.mapper;

import com.ita.todolist.dto.ToDoItemRequest;
import com.ita.todolist.entity.ToDoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author LINVI7
 * @Date 8/6/2020 8:22 PM
 * @Version 1.0
 */
public class ToDoItemMapperTest {
    @Test
    void should_return_entity_when_map_request_dto_to_entity_given_request_dto() {
        //given
        ToDoItemRequest toDoItemRequest = new ToDoItemRequest(false, "vicky");

        //when
        ToDoItem toDoItem = ToDoItemMapper.requestToEntity(toDoItemRequest);

        //then
        Assertions.assertEquals(toDoItemRequest.getContent(),toDoItem.getContent());
        Assertions.assertEquals(toDoItem.getStatus(),toDoItemRequest.getStatus());
    }
}
