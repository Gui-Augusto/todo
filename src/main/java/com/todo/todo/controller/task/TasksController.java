package com.todo.todo.controller.task;

import com.todo.todo.controller.task.dto.TaskDTO;
import com.todo.todo.controller.task.dto.TaskPayload;
import com.todo.todo.core.task.Task;
import com.todo.todo.core.task.service.TaskService;
import com.todo.todo.core.user.User;
import com.todo.todo.core.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    TaskService taskService;

    @GetMapping("/findAllTasks")
    public ResponseEntity<List<TaskDTO>> findTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping("/addTask")
    public ResponseEntity<Void> addUser(@Valid @RequestBody TaskPayload taskPayload) {
        taskService.addTask(taskPayload);
        return ResponseEntity.ok().build();
    }
}
