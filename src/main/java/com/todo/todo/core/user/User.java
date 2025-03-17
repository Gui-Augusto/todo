package com.todo.todo.core.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@EqualsAndHashCode
public class User {
    @Id
    private String id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}