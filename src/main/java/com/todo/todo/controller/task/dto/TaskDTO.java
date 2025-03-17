package com.todo.todo.controller.task.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskDTO {
    private String id;
    private String title;
    private String description;
    private String owner;
    private boolean completed;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
