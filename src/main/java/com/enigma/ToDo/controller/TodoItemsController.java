package com.enigma.ToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enigma.ToDo.dto.request.TodoItemsRequest;
import com.enigma.ToDo.dto.response.TodoItemsResponse;
import com.enigma.ToDo.service.TodoItemsService;
import com.enigma.ToDo.constant.Constant;
import com.enigma.ToDo.constant.Status;

import java.util.List;

@RestController
@RequestMapping(Constant.todos_API)
public class TodoItemsController {
    
    private final TodoItemsService todoItemsService;

    @Autowired
    public TodoItemsController(TodoItemsService todoItemsService) {
        this.todoItemsService = todoItemsService;
    }

    @PostMapping
    public ResponseEntity<TodoItemsResponse> addTodoItem(@RequestBody TodoItemsRequest request) {
        TodoItemsResponse response = todoItemsService.addTodoItems(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoItemsResponse>> getAllTodoItems() {
        List<TodoItemsResponse> responses = todoItemsService.getAllTodoItems();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItemsResponse> getTodoItemById(@PathVariable String id) {
        TodoItemsResponse response = todoItemsService.getTodoItemsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItemsResponse> updateTodoItem(@PathVariable String id, @RequestBody TodoItemsRequest request) {
        TodoItemsResponse response = todoItemsService.updateTodoItems(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable String id) {
        todoItemsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TodoItemsResponse> updateTodoItemStatus(@PathVariable String id, @RequestBody Status status) {
        TodoItemsResponse response = todoItemsService.updateStatus(id, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
