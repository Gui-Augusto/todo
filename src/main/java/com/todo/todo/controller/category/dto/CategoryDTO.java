package com.todo.todo.controller.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryDTO {
    private String id;
    private String name;
    private String description;
    private String idUser;
}
