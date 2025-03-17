package com.todo.todo.core.task;

import com.todo.todo.core.category.Category;
import com.todo.todo.core.user.User;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "tasks")
@EqualsAndHashCode
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private ObjectId owner;
    private boolean completed;
    private ObjectId category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}