package com.todo.todo.controller.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private String id;
    private String name;
}
