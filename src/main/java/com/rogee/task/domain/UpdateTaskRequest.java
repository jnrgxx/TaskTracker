// contains all information that can be updated on a task

package com.rogee.task.domain;

import com.rogee.task.domain.entity.TaskPriority;
import com.rogee.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
    String title,
    String description,
    LocalDate dueDate,
    TaskStatus status,
    TaskPriority priority
) {
}
