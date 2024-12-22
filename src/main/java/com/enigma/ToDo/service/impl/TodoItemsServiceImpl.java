package com.enigma.ToDo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.enigma.ToDo.constant.Status;
import com.enigma.ToDo.dto.request.TodoItemsRequest;
import com.enigma.ToDo.dto.response.TodoItemsResponse;
import com.enigma.ToDo.entity.TodoItems;
import com.enigma.ToDo.repository.TodoItemsRepository;
import com.enigma.ToDo.service.TodoItemsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoItemsServiceImpl implements TodoItemsService {
    private final TodoItemsRepository todoItemsRepository;

    @Override
    public TodoItemsResponse addTodoItems(TodoItemsRequest request) {
        TodoItems addTodoItems = TodoItems.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .dueDate(request.getDueDate())
            .status(Status.IN_PROGRESS)
            .build();
        todoItemsRepository.saveAndFlush(addTodoItems);
        return toTodoItemsResponse(addTodoItems);
    }

    @Override
    public List<TodoItemsResponse> getAllTodoItems() {
        List<TodoItems> todoItems = todoItemsRepository.findAll();
        return todoItems.stream()
        .map(this::toTodoItemsResponse)
        .collect(Collectors.toList());
    }

    @Override
    public TodoItemsResponse getTodoItemsById(String id) {
        TodoItems todoItems = todoItemsRepository.findById(id).orElseThrow();
        return toTodoItemsResponse(todoItems);
    }

    @Override
    public TodoItemsResponse updateTodoItems(String id, TodoItemsRequest request) {
        Optional<TodoItems> todoItemsOptional = todoItemsRepository.findById(id);
        if (!todoItemsOptional.isPresent()) {
            return null;
        }
        TodoItems todoItems = todoItemsOptional.get();
        todoItems.setTitle(request.getTitle());
        todoItems.setDescription(request.getDescription());
        todoItems.setDueDate(request.getDueDate());
        todoItems.setStatus(request.getStatus());
        todoItemsRepository.saveAndFlush(todoItems);
        return toTodoItemsResponse(todoItems);
    }
    
    @Override
    public void deleteById(String id) {
        todoItemsRepository.deleteById(id);
    }

    public TodoItemsResponse updateStatus(String id, Status status) {
        Optional<TodoItems> todoItemsOptional = todoItemsRepository.findById(id);
        if (!todoItemsOptional.isPresent()) {
            return null;
        }
        TodoItems todoItems = todoItemsOptional.get();
        todoItems.setStatus(status.valueOf(status.name()));
        todoItemsRepository.saveAndFlush(todoItems);
        return toTodoItemsResponse(todoItems);
    }

    public TodoItemsResponse toTodoItemsResponse(TodoItems addTodoItems) {
        TodoItemsResponse todoItemsResponse = new TodoItemsResponse();
        todoItemsResponse.setId(addTodoItems.getId());
        todoItemsResponse.setTitle(addTodoItems.getTitle());
        todoItemsResponse.setDescription(addTodoItems.getDescription());
        todoItemsResponse.setDueDate(addTodoItems.getDueDate());
        todoItemsResponse.setStatus(addTodoItems.getStatus());
        todoItemsResponse.setUserId(addTodoItems.getUser().getId());
        return todoItemsResponse;
    }
}
