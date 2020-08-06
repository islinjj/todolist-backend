package com.ita.todolist.dto;

import javax.validation.constraints.NotBlank;

/**
 * @Author LINVI7
 * @Date 8/6/2020 8:18 PM
 * @Version 1.0
 */
public class ToDoItemRequest {
    private Boolean status;
    @NotBlank
    private String content;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ToDoItemRequest(Boolean status, String content) {
        this.status = status;
        this.content = content;
    }

    public ToDoItemRequest() {
    }
}
