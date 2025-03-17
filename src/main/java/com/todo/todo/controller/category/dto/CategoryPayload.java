package com.todo.todo.controller.category.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
@Builder
public class CategoryPayload {
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String idUser;
}
