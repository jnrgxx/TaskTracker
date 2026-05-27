package com.rogee.task.repository;

import com.rogee.task.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // sub-class of @Components, similar but more descriptive
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
