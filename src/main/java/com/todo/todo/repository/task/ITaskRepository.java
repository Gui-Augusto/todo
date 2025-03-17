package com.todo.todo.repository.task;

import com.todo.todo.core.task.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITaskRepository extends MongoRepository<Task, String> {
}
