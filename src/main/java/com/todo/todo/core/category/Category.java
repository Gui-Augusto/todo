package com.todo.todo.core.category;

import com.todo.todo.core.user.User;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "categorys")
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    private ObjectId owner;
}
