package com.semicolon.africa.real.task.services;



import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.data.models.User;
import com.semicolon.africa.real.task.dto.*;

import java.util.List;

public interface UserServices {

    TodoLogInResponse logIn(TodoLogInRequest todoLogInRequest);
    TodoLogInResponse logOut(TodoLogInRequest todoLogInRequest);
    List<TodoTask> findCompletedTask();
    List<TodoTask> findInCompletedTask();
    TaskResponse createTask(TaskRequest taskRequest);
    TaskResponse completeTask(TaskRequest taskRequest);
    TaskResponse deleteTask(TaskRequest taskRequest);
    TaskResponse updateTask(TaskRequest taskRequest);
    TodoSignUpResponse signUp(TodoSignUpRequest todoSignUpRequest);
    List<TaskResponse> findAllUserCompletedTask(TaskRequest taskRequest);
    User findUserByUserName(String authorName);
    List<TodoTask>findAllUserCompletedTasks(String userName);
    List<TodoTask> findAllUserInCompletedTask(String userName);
    List<TodoTask> findAllUserTasks(String userName);
}
