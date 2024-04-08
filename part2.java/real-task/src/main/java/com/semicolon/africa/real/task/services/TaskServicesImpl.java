package com.semicolon.africa.real.task.services;
import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.dto.TaskRequest;
import com.semicolon.africa.real.task.dto.TaskResponse;
import com.semicolon.africa.real.task.repositories.TodoTasks;
import com.semicolon.africa.real.task.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.CollationKey;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServicesImpl implements TaskServices {
    @Autowired
    private TodoTasks todoTasks;


    @Override
    public List<TodoTask> findCompletedTask() {
        return todoTasks.findAll().stream().filter(TodoTask::isCompleted).
                collect(Collectors.toList());
    }

    @Override
    public List<TodoTask> findInCompletedTask() {
        return todoTasks.findAll().stream().filter(task -> !task.isCompleted()).
                collect(Collectors.toList());
    }


    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
            TodoTask todoTask = new TodoTask();
            Mappers.mapRequestToTask(taskRequest, todoTask);
            todoTasks.save(todoTask);
            return Mappers.mapTaskRequestToResponse(taskRequest);
    }



    @Override
    public TaskResponse completeTask(TaskRequest taskRequest) {
        TodoTask task = findTodoTaskByTask(taskRequest.getTask());
        task.setCompleted(true);
        task.setTimeCompleted(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        Mappers.mapTaskToRequest(task,taskRequest);
        todoTasks.save(task);
        return Mappers.mapTaskRequestToResponse(taskRequest);
    }

    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest) {
        TodoTask task = findTodoTaskByTask(taskRequest.getTask());
        todoTasks.delete(task);
        Mappers.mapTaskToRequest(task,taskRequest);
        return Mappers.mapTaskRequestToResponse(taskRequest);
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest) {
        TodoTask task = findTodoTaskByTask(taskRequest.getTask());
        Mappers.mapRequestToTask(taskRequest,task);
        task.setTask(task.getNewTask());
        todoTasks.save(task);
        return Mappers.mapTaskRequestToResponseUpdate(taskRequest);
    }

    public List<TodoTask> userTodoTasks(String username){
             return todoTasks.findTaskByTaskAuthor(username);
    }

    public List<TodoTask> findAllUserCompletedTask(String userName){
                    return findCompletedTask().stream().filter(todoTask -> todoTask.getTaskAuthor()
                            .equalsIgnoreCase(userName)).collect(Collectors.toList());
    }

    public List<TodoTask> findAllUserInCompletedTask(String userName){
        return findInCompletedTask().stream().filter(todoTask -> todoTask.getTaskAuthor()
                .equalsIgnoreCase(userName)).collect(Collectors.toList());
    }

    public List<TodoTask> findAllUserTasks(String userName){
        return todoTasks.findAll().stream().filter(todoTask -> todoTask.getTaskAuthor()
                .equalsIgnoreCase(userName)).collect(Collectors.toList());
    }

    @Override
    public TodoTask findTodoTaskByTask(String task) {
          for (TodoTask todoTask : todoTasks.findAll())
              if(todoTask.getTask().equalsIgnoreCase(task))return todoTask;
          return null;
    }


}
