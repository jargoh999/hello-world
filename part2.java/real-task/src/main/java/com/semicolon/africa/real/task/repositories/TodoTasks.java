package com.semicolon.africa.real.task.repositories;


import com.semicolon.africa.real.task.data.models.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoTasks extends JpaRepository<TodoTask,Long> {
    List<TodoTask> findTasksByTimeCompleted(LocalDateTime timeCompleted);
    List<TodoTask> findTasksByTimeCreated(LocalDateTime timeCreated);
    TodoTask findTodoTaskByTask(String task);
    List<TodoTask> findTaskByTaskAuthor(String author);
}


