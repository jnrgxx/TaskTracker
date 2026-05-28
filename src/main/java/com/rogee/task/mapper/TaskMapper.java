package com.rogee.task.mapper;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.UpdateTaskRequest;
import com.rogee.task.domain.dto.CreateTaskRequestDto;
import com.rogee.task.domain.dto.TaskDto;
import com.rogee.task.domain.dto.UpdateTaskRequestDto;
import com.rogee.task.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
