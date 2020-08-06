package com.ita.todolist.integrator;

import com.alibaba.fastjson.JSON;
import com.ita.todolist.entity.ToDoItem;
import com.ita.todolist.repository.ToDoItemRepository;
import com.ita.todolist.service.ToDoItemService;
import com.ita.todolist.service.impl.ToDoItemServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;


/**
 * @Author LINVI7
 * @Date 8/6/2020 9:22 PM
 * @Version 1.0
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoItemIntegratorTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ToDoItemServiceImpl toDoItemService;
    @Autowired
    ToDoItemRepository toDoItemRepository;

    @AfterEach
    void clearDataBase() {
        toDoItemRepository.deleteAll();
    }

    @Test
    void should_return_size_1_when_get_all_todo_item_given_todo_item_size_1() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        LinkedList<ToDoItem> todoItems = JSON.parseObject(contentAsString, LinkedList.class);
        Assertions.assertEquals(1,todoItems.size());
    }
}
