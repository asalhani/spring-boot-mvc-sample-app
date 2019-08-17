package com.tasksapp.tasks.repository;

import com.tasksapp.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
