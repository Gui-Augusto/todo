package com.todo.todo.controller.task.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Getter
@Builder
public class TaskPayload {
    @NotNull
    private String title;

    private String description;

    @NotNull
    private String idUser;

    @NotNull
    private String idCategory;

    @NotNull
    private boolean completed;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
