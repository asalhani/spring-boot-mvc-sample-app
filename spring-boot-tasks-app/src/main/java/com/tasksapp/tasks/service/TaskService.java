package com.tasksapp.tasks.service;

import com.tasksapp.tasks.domain.Task;
import org.springframework.stereotype.Service;


public interface TaskService {

    Iterable<Task> list();

    Task save(Task task);
}
