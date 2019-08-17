package com.tasksapp.tasks;

import com.tasksapp.tasks.domain.Task;
import com.tasksapp.tasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }

    @Bean
    CommandLineRunner taskRunner(TaskService taskService) {
        return args -> {
            taskService.save(new Task(1L, "Task 1", LocalDate.now(), true));
            taskService.save(new Task(2L, "Task 2", LocalDate.now().plus(1, ChronoUnit.DAYS), false));
            taskService.save(new Task(3L, "Task 3", LocalDate.now().plus(4, ChronoUnit.DAYS), true));
            taskService.save(new Task(4L, "Task 4", LocalDate.now().plus(5, ChronoUnit.DAYS), false));
            taskService.save(new Task(5L, "Task 5", LocalDate.now().plus(2, ChronoUnit.DAYS), false));
            taskService.save(new Task(6L, "Task 6", LocalDate.now().plus(7, ChronoUnit.DAYS), true));
            taskService.save(new Task(7L, "Task 7", LocalDate.now().plus(3, ChronoUnit.DAYS), true));
            taskService.save(new Task(8L, "Task 8", LocalDate.now().plus(1, ChronoUnit.DAYS), false));

        };
    }
}
