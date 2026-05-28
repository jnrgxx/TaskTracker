package com.rogee.task.controller;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.UpdateTaskRequest;
import com.rogee.task.domain.dto.CreateTaskRequestDto;
import com.rogee.task.domain.dto.TaskDto;
import com.rogee.task.domain.dto.UpdateTaskRequestDto;
import com.rogee.task.domain.entity.Task;
import com.rogee.task.mapper.TaskMapper;
import com.rogee.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        // call listTasks() to get List<Task> from service layer:
        List<Task> tasks = taskService.listTasks();
        // via stream, map the task to TaskDto:
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        // return response 200, with the list of tasks:
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
        @PathVariable UUID taskId, // we use @PathVariable to use "taskId" as a variable that will be added to the URL
        @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
