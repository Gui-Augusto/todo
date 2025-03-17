package com.todo.todo.core.task.service;

import com.todo.todo.common.GeradorData;
import com.todo.todo.controller.task.dto.TaskDTO;
import com.todo.todo.controller.task.dto.TaskPayload;
import com.todo.todo.core.category.Category;
import com.todo.todo.core.category.service.CategoryService;
import com.todo.todo.core.task.Task;
import com.todo.todo.core.user.User;
import com.todo.todo.core.user.service.UserService;
import com.todo.todo.repository.task.ITaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    GeradorData geradorData;
    @Autowired
    ITaskRepository taskRepository;

    public void addTask(TaskPayload taskPayload) {
        Task task = Task.builder()
                .title(taskPayload.getTitle())
                .description(taskPayload.getDescription())
                .owner(new ObjectId(taskPayload.getIdUser()))
                .category(new ObjectId(taskPayload.getIdCategory()))
                .completed(taskPayload.isCompleted())
                .createdAt(geradorData.gerarLocalDataAtual())
                .updatedAt(geradorData.gerarLocalDataAtual())
                .build();
        taskRepository.insert(task);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task -> TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .owner(task.getOwner().toString())
                .category(task.getCategory().toString())
                .completed(task.isCompleted())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build()).toList();
    }
}
