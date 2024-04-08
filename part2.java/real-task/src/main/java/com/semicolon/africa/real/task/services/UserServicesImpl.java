package com.semicolon.africa.real.task.services;
import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.data.models.User;
import com.semicolon.africa.real.task.dto.*;
import com.semicolon.africa.real.task.exception.AlreadyInActiveException;
import com.semicolon.africa.real.task.exception.InactiveStateException;
import com.semicolon.africa.real.task.exception.UserAlreadyExistException;
import com.semicolon.africa.real.task.exception.UserNotFoundException;
import com.semicolon.africa.real.task.repositories.Users;
import com.semicolon.africa.real.task.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static com.semicolon.africa.real.task.utils.Mappers.*;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private TaskServicesImpl taskServices;

    @Autowired
    private Users users;

    @Override
    public TodoSignUpResponse signUp(TodoSignUpRequest todoSignUpRequest){
        User user = new User();
        mapRequestToUser(todoSignUpRequest,user);
        if(findUserByUserName(user.getUserName())==null)users.save(user);
        else throw new UserAlreadyExistException("user already exist");
        return mapSignUpRequestToResponse(todoSignUpRequest);
    }

    @Override
    public TodoLogInResponse logIn(TodoLogInRequest todoLogInRequest) {
        User user = users.findUsersByUserName(todoLogInRequest.getUserName());
        if(!user.getPassWord().equals(todoLogInRequest.getPassword()))throw new UserNotFoundException("user not found");
        user.setActive(true);
        user.setUsersTodoTask(taskServices.userTodoTasks(user.getUserName()));
        users.save(user);
        return mapUserToResponse(user);
    }

    @Override
    public TodoLogInResponse logOut(TodoLogInRequest todoLogInRequest) {
        User user = users.findUsersByUserName(todoLogInRequest.getUserName());
        if (user.isActive()) user.setActive(false);
        else throw new AlreadyInActiveException("you are already logged out");
        user.setUsersTodoTask(taskServices.userTodoTasks(user.getUserName()));
        users.save(user);
        return mapUserToResponse(user);
    }

    @Override
    public List<TodoTask> findCompletedTask() {
        return taskServices.findCompletedTask();
    }

    @Override
    public List<TodoTask> findInCompletedTask() {
        return taskServices.findInCompletedTask();
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        User user = users.findUsersByUserName(taskRequest.getTaskAuthor());
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.isActive()) throw new InactiveStateException("you are inactive");
        return taskServices.createTask(taskRequest);
    }
    @Override
    public TaskResponse completeTask(TaskRequest taskRequest) {
        User user = users.findUsersByUserName(taskRequest.getTaskAuthor());
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.isActive()) throw new InactiveStateException("you are inactive");
        return taskServices.completeTask(taskRequest);
    }
    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest) {
        User user = users.findUsersByUserName(taskRequest.getTaskAuthor());
        TodoTask todoTask = new TodoTask();
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.isActive()) throw new InactiveStateException("you are inactive");
        mapRequestToTask( taskRequest,todoTask);
        user.getUsersTodoTask().remove(todoTask);
        return taskServices.deleteTask(taskRequest);
    }
    @Override
    public TaskResponse updateTask(TaskRequest taskRequest) {
        User user = users.findUsersByUserName(taskRequest.getTaskAuthor());
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.isActive()) throw new InactiveStateException("you are inactive");
        return taskServices.updateTask(taskRequest);
    }
    public List<TaskResponse> findAllUserCompletedTask(TaskRequest taskRequest) {
       User user = users.findUsersByUserName(taskRequest.getTaskAuthor());
        if (user == null) throw new UserNotFoundException("you are not a valid user");
        if (!user.isActive()) throw new InactiveStateException("you are inactive");
        return taskServices.findAllUserCompletedTask(user.getUserName()).
                stream().map(Mappers::mapTaskToResponse).collect(Collectors.toList());
   }


    @Override
    public User findUserByUserName(String authorName) {
         return users.findUsersByUserName(authorName);
    }

    @Override
    public List<TodoTask> findAllUserCompletedTasks(String userName) {
        User user = users.findUsersByUserName(userName);
        if (user == null) throw new UserNotFoundException("you are not a valid user");
        return taskServices.findAllUserCompletedTask(userName);
    }

    @Override
    public List<TodoTask> findAllUserInCompletedTask(String userName) {
        User user = users.findUsersByUserName(userName);
        if (user == null) throw new UserNotFoundException("you are not a valid user");
        return taskServices.findAllUserInCompletedTask(userName);
    }

    @Override
    public List<TodoTask> findAllUserTasks(String userName) {
        User user = users.findUsersByUserName(userName);
        if (user == null) throw new UserNotFoundException("you are not a valid user");
        return taskServices.findAllUserTasks(userName);
    }


}