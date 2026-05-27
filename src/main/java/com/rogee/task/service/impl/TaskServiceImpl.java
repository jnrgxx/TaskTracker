package com.rogee.task.service.impl;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.entity.Task;
import com.rogee.task.domain.entity.TaskStatus;
import com.rogee.task.repository.TaskRepository;
import com.rogee.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service // specialized version of @Component, descriptive
public class TaskServiceImpl implements TaskService {

    // Dependency, bcoz we want to save to the database when creating tasks:
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now(); // we need the time now for audit

        Task task = new Task(
            null, // we set UUID to null so Spring Boot fills it
            request.title(),
            request.description(),
            request.dueDate(),
            TaskStatus.OPEN,
            request.priority(),
            now,
            now

        );

        return taskRepository.save(task);
    }
}
