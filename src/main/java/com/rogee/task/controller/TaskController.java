package com.rogee.task.controller;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.dto.CreateTaskRequestDto;
import com.rogee.task.domain.dto.TaskDto;
import com.rogee.task.domain.entity.Task;
import com.rogee.task.mapper.TaskMapper;
import com.rogee.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    // dependencies
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    // only Post method returns a response body:
    @PostMapping
    public ResponseEntity<TaskDto> createTask( // ReponseEntity<Type>
       // expect CreateTaskRequestDto in Response Body and validate:
        @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        // take createTaskRequestDto and map it to createTaskRequest object:
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        // pass createTaskRequest to Service Layer, which creates a Task:
        Task task = taskService.createTask(createTaskRequest);
        // take the task and map it to TaskDto:
        TaskDto createdTaskDto = taskMapper.toDto(task);
        // return to Task to ResponseEntity:
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }
}
