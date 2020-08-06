package com.ita.todolist.service;

import com.ita.todolist.entity.ToDoItem;
import com.ita.todolist.repository.ToDoItemRepository;
import com.ita.todolist.service.impl.ToDoItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @Author LINVI7
 * @Date 8/6/2020 6:45 PM
 * @Version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class ToDoListServiceTest {

    @Mock
    private ToDoItemRepository toDoItemRepository;
    @InjectMocks
    private ToDoItemServiceImpl toDoListService;

    @Test
    void should_return_size_0_when_find_all_to_do_item_given_none() {
        //given
        when(toDoItemRepository.findAll()).thenReturn(new ArrayList<ToDoItem>());

        //when
        List<ToDoItem> todoItems= toDoListService.getAllTodoItem();

        //then
        Assertions.assertEquals(0,todoItems.size());
    }
}
