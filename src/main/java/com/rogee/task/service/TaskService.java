package com.rogee.task.service;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.UpdateTaskRequest;
import com.rogee.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);
}
