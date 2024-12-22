package com.enigma.ToDo.service;

import java.util.List;

import com.enigma.ToDo.constant.Status;
import com.enigma.ToDo.dto.request.TodoItemsRequest;
import com.enigma.ToDo.dto.response.TodoItemsResponse;
import com.enigma.ToDo.entity.TodoItems;

public interface TodoItemsService {
    public TodoItemsResponse addTodoItems(TodoItemsRequest request);
    List<TodoItemsResponse> getAllTodoItems();
    public TodoItemsResponse getTodoItemsById(String id);
    public TodoItemsResponse updateTodoItems(String id, TodoItemsRequest request);
    public void deleteById(String id);
    public TodoItemsResponse updateStatus(String id, Status status);
}
