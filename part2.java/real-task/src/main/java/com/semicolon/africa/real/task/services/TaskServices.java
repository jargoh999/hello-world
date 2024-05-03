package com.semicolon.africa.real.task.services;


import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.dto.TaskRequest;
import com.semicolon.africa.real.task.dto.TaskResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskServices {
    public List<TodoTask> findCompletedTask();
    public List<TodoTask> findInCompletedTask();
    public TaskResponse createTask(TaskRequest taskRequest);
    public TaskResponse completeTask(TaskRequest taskRequest);
    public TaskResponse deleteTask(TaskRequest taskRequest);
    public TaskResponse updateTask(TaskRequest taskRequest);
    public List<TodoTask>userTodoTasks(String username);
    public List<TodoTask>findAllUserCompletedTask(String userName);
    List<TodoTask> findAllUserInCompletedTask(String userName);
    List<TodoTask> findAllUserTasks(String userName);
    TodoTask findTodoTaskByTask(String task);

    TaskResponse beginTask(TaskRequest taskRequest);
    List<TodoTask> findAllUserTaskInProgress(TaskRequest taskRequest);
    List<TodoTask> findAllUserHighPriorityTask(String userName);
    List<TodoTask> findAllUserImportantTask(String userName);
    List<TodoTask> findAllUserLowPriorityTask(String userName);
    int getTaskCompletionTime(LocalDateTime timeCreated , LocalDateTime timeCompleted);

    List<TodoTask> findAllTask();

}
