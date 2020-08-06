package com.ita.todolist.dto;

/**
 * @Author LINVI7
 * @Date 8/6/2020 8:42 PM
 * @Version 1.0
 */
public class ToDoItemResponseDto {
    private Integer id;
    private Boolean status;
    private String content;

    public ToDoItemResponseDto() {
    }

    public ToDoItemResponseDto(Integer id, Boolean status, String content) {
        this.id = id;
        this.status = status;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public ToDoItemResponseDto(Boolean status, String content) {
        this.status = status;
        this.content = content;
    }
}
