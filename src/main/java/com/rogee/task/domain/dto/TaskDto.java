// DTO to model the Response for creating a task
package com.rogee.task.domain.dto;

import com.rogee.task.domain.entity.TaskPriority;
import com.rogee.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority,
    TaskStatus status
) {

}
