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

    @Test
    void should_return_1_to_do_item_when_add_one_todo_item_given_1_to_do_item() throws Exception {
        String toDoItemJson = "{\n" +
                "    \"content\":\"finish homewrok\",\n" +
                "    \"status\": false\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/todos").contentType(MediaType.APPLICATION_JSON).content(toDoItemJson));
        ToDoItem toDoItem = toDoItemRepository.findAll().get(0);
        Assertions.assertEquals("finish homewrok",toDoItem.getContent());
    }

    @Test
    void should_return_1_updated_to_do_item_when_update_one_todo_item_given_1_to_do_item_and_id() throws Exception {
        String oldToDoItemJson = "{\n" +
                "    \"content\":\"finish homewrok\",\n" +
                "    \"status\": false\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/todos").contentType(MediaType.APPLICATION_JSON).content(oldToDoItemJson));
        String updateToDoItemJson = "{\n" +
                "    \"content\":\"finish homewrok\",\n" +
                "    \"status\": true\n" +
                "}";
        ToDoItem toDoItem = toDoItemRepository.findAll().get(0);
        mockMvc.perform(MockMvcRequestBuilders.put(String.format("/todos/%d", toDoItem.getId())).contentType(MediaType.APPLICATION_JSON).content(updateToDoItemJson));
        Assertions.assertTrue(toDoItem.getStatus());
    }

    @Test
    void should_return_0_when_delete_todo_item_given_id() throws Exception {
        String toDoItemJson = "{\n" +
                "    \"content\":\"finish homewrok\",\n" +
                "    \"status\": false\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/todos").contentType(MediaType.APPLICATION_JSON).content(toDoItemJson));
        ToDoItem toDoItem = toDoItemRepository.findAll().get(0);
        mockMvc.perform(MockMvcRequestBuilders.delete(String.format("/todos/%d", toDoItem.getId())));
        Assertions.assertEquals(0,toDoItemRepository.findAll().size());
    }
}
