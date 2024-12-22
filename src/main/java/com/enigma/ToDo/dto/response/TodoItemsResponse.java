package com.enigma.ToDo.dto.response;

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
public class TodoItemsResponse {
    private String id;
    private String title;
    private String description;
    private String dueDate;
    private Status status;
    private String userId;
}
