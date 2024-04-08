package com.semicolon.africa.real.task.utils;
import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.data.models.User;
import com.semicolon.africa.real.task.dto.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;



public class Mappers {


    public  static  void mapRequestToTask(TaskRequest taskRequest, TodoTask todoTask){
        todoTask.setTaskAuthor(taskRequest.getTaskAuthor());
        todoTask.setTask(taskRequest.getTask());
        todoTask.setNewTask(taskRequest.getNewTask());
        todoTask.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        taskRequest.setTimeCreated(todoTask.getTimeCreated());
        todoTask.setCompleted(taskRequest.isCompleted());
    }

    public  static  void mapTaskToRequest(TodoTask todoTask, TaskRequest taskRequest){
        taskRequest.setTaskAuthor(todoTask.getTaskAuthor());
        taskRequest.setTask(todoTask.getTask());
        taskRequest.setNewTask(todoTask.getNewTask());
        taskRequest.setTimeCreated(todoTask.getTimeCreated());
        taskRequest.setTimeCompleted(todoTask.getTimeCompleted());
        taskRequest.setCompleted(todoTask.isCompleted());
    }

    public static TaskResponse mapTaskRequestToResponse(TaskRequest taskRequest){
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskAuthor(taskRequest.getTaskAuthor());
        taskResponse.setTimeCreated(taskRequest.getTimeCreated());
        taskResponse.setTask(taskRequest.getTask());
        taskResponse.setCompleted(taskRequest.isCompleted());
        taskResponse.setTimeCompleted(taskRequest.getTimeCompleted());
        return taskResponse;
    }

    public static TaskResponse mapTaskRequestToResponseUpdate(TaskRequest taskRequest){
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskAuthor(taskRequest.getTaskAuthor());
        taskResponse.setTimeCreated(taskRequest.getTimeCreated());
        taskResponse.setTask(taskRequest.getNewTask());
        taskResponse.setCompleted(taskRequest.isCompleted());
        taskResponse.setTimeCompleted(taskRequest.getTimeCompleted());
        return taskResponse;
    }


    public static TodoLogInResponse mapUserToResponse(User user){
                   TodoLogInResponse todoLogInResponse = new TodoLogInResponse();
                   todoLogInResponse.setUsersTodoTask(user.getUsersTodoTask());
                   todoLogInResponse.setUsername(user.getUserName());
                   todoLogInResponse.setActive(user.isActive());
                   return todoLogInResponse;
    }

    public static TaskResponse mapTaskToResponse(TodoTask todoTask){
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskAuthor(todoTask.getTaskAuthor());
        taskResponse.setTask(todoTask.getTask());
        taskResponse.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        taskResponse.setTimeCreated(todoTask.getTimeCreated());
        return  taskResponse;
    }
    public static void mapRequestToUser(TodoSignUpRequest todoSignUpRequest,User user){
        user.setUserName(todoSignUpRequest.getUserName());
        user.setPassWord(todoSignUpRequest.getPassWord());
    }

    public static TodoSignUpResponse mapSignUpRequestToResponse(TodoSignUpRequest todoSignUpRequest) {
        TodoSignUpResponse todoSignUpResponse = new TodoSignUpResponse();
        todoSignUpResponse.setUserName(todoSignUpRequest.getUserName());
        return todoSignUpResponse;
    }
}
