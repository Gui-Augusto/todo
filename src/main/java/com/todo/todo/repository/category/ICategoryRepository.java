package com.todo.todo.repository.category;

import com.todo.todo.core.category.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICategoryRepository extends MongoRepository<Category, String> {
}
