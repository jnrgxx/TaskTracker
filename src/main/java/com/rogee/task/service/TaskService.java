package com.rogee.task.service;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
}
