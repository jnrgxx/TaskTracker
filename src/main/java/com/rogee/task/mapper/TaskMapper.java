package com.rogee.task.mapper;

import com.rogee.task.domain.CreateTaskRequest;
import com.rogee.task.domain.dto.CreateTaskRequestDto;
import com.rogee.task.domain.dto.TaskDto;
import com.rogee.task.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
