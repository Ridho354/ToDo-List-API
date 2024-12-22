package com.enigma.ToDo.dto.request;

import com.enigma.ToDo.constant.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItemsRequest {
    private String title;
    private String description;
    private String dueDate;
    private Status status;
    private String userId;
}
