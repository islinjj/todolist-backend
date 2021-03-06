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

import static org.mockito.Mockito.verify;
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

    @Test
    void should_return_size_1_when_find_all_to_do_item_given_1_todo_item() {
        //given
        ToDoItem toDoItem = new ToDoItem(1, false, "vicky");
        ArrayList<ToDoItem> toDoItems = new ArrayList<>();
        toDoItems.add(toDoItem);
        when(toDoItemRepository.findAll()).thenReturn(toDoItems);

        //when
        List<ToDoItem> todoItems= toDoListService.getAllTodoItem();

        //then
        Assertions.assertEquals(1,todoItems.size());
    }

    @Test
    void should_return_id_1_when_add_to_do_item_given_1_todo_item() {
        //given
        ToDoItem newItem = new ToDoItem( false, "vicky");
        ToDoItem compareItem = new ToDoItem(1, false, "vicky");
        when(toDoItemRepository.save(newItem)).thenReturn(compareItem);

        //when
        ToDoItem item= toDoListService.addToDoItem(newItem);

        //then
        Assertions.assertEquals(1,item.getId());
    }

    @Test
    void should_execution_delete_method_when_delete_to_do_item_given_item_id() {
        //given
        Integer toDoItemId = 1;

        //when
        toDoListService.deleteToDoItemById(toDoItemId);

        //then
        verify(toDoItemRepository).deleteById(toDoItemId);
    }

    @Test
    void should_return_true_when_update_todo_item_given_todo_item_with_status_true() {
        //given
        ToDoItem updateToDoItem = new ToDoItem( 1,true, "vicky");
        when(toDoItemRepository.save(updateToDoItem)).thenReturn(updateToDoItem);

        //when
        ToDoItem newToDoItem = toDoListService.updateToDoItem(updateToDoItem);

        //then
        Assertions.assertTrue(newToDoItem.getStatus());
    }
}
