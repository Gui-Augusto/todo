package com.todo.todo.core.task;

import com.todo.todo.common.GeradorData;
import com.todo.todo.controller.task.dto.TaskDTO;
import com.todo.todo.controller.task.dto.TaskPayload;
import com.todo.todo.core.task.service.TaskService;
import com.todo.todo.repository.task.ITaskRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    ITaskRepository repository;
    @Mock
    GeradorData geradorData;
    @InjectMocks
    TaskService taskService;

    @Test
    void testAddTask() {
        LocalDateTime now = LocalDateTime.now();
        TaskPayload taskPayload = TaskPayload.builder()
                .title("Test Task")
                .description("Test Description")
                .idUser("64e1b6a7c9a8b7b1c2d3e4f5") // Example ObjectId as String
                .idCategory("64e1b6a7c9a8b7b1c2d3e4f6") // Example ObjectId as String
                .completed(false)
                .build();
        Task taskMock = Task.builder()
                .title("Test Task")
                .description("Test Description")
                .owner(new ObjectId("64e1b6a7c9a8b7b1c2d3e4f5"))
                .category(new ObjectId("64e1b6a7c9a8b7b1c2d3e4f6"))
                .completed(false)
                .createdAt(now)
                .updatedAt(now)
                .build();
        when(geradorData.gerarLocalDataAtual()).thenReturn(now);

        taskService.addTask(taskPayload);

        verify(repository).insert(taskMock);
    }

    @Test
    void testGetAllTasks() {
        LocalDateTime now = LocalDateTime.now();
        List<Task> tasks = new ArrayList();
        Task taskMock = Task.builder()
                .title("title")
                .description("description")
                .owner(new ObjectId("64e1b6a7c9a8b7b1c2d3e4f5"))
                .category(new ObjectId("64e1b6a7c9a8b7b1c2d3e4f5"))
                .completed(false)
                .createdAt(now)
                .updatedAt(now)
                .build();
        tasks.add(taskMock);

        when(repository.findAll()).thenReturn(tasks);

        List<TaskDTO> taskDTOS = taskService.getAllTasks();

        assertEquals(1, taskDTOS.size());
        assertEquals("title", taskDTOS.get(0).getTitle());
    }
}
