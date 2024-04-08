package com.semicolon.africa.real.task.services;

import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.dto.TaskRequest;
import com.semicolon.africa.real.task.dto.TodoLogInRequest;
import com.semicolon.africa.real.task.dto.TodoSignUpRequest;
import com.semicolon.africa.real.task.repositories.TodoTasks;
import com.semicolon.africa.real.task.repositories.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServicesImplTest {

    @Autowired
    private UserServicesImpl userServices;

    @Autowired
    private Users users;
    @Autowired
    private TodoTasks todoTasks;
    @BeforeEach
    public void setUserServices(){
        users.deleteAll();
        todoTasks.deleteAll();
    }

    @Test
   public void testThatUserCanSignUp() {
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        assertTrue(users.existsById(userServices.findUserByUserName("ayo").getId()));
    }

    @Test
    public void testThatUserCanLogIn() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        assertTrue(users.findUsersByUserName("ayo").isActive(), "user is logged in");

    }

    @Test
    public void testThatUserCanLogOut() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        userServices.logOut(todoLogInRequest);
        assertFalse(users.findUsersByUserName("ayo").isActive(), "user is logged out");
    }

    @Test
    public void findCompletedTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        userServices.createTask(taskRequest);
        userServices.completeTask(taskRequest);
       assertFalse(userServices.findCompletedTask().isEmpty(), "task are completed");

    }

    @Test
    public void findInCompletedTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        userServices.createTask(taskRequest);
        assertFalse(userServices.findInCompletedTask().isEmpty(), "no completed task yet");
    }

    @Test

    public void testThatUserCanCreateTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTask("i don tire for this life");
        taskRequest.setTaskAuthor(todoLogInRequest.getUserName());
        taskRequest.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        userServices.createTask(taskRequest);
        userServices.logOut(todoLogInRequest);
        userServices.logIn(todoLogInRequest);
        assertFalse(userServices.findUserByUserName("ayo").getUsersTodoTask().isEmpty());
    }

    @Test
    public void completeTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTask("i don tire for this life");
        taskRequest.setTaskAuthor(todoLogInRequest.getUserName());
        taskRequest.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        userServices.createTask(taskRequest);
        userServices.completeTask(taskRequest);
        assertFalse(userServices.findAllUserCompletedTasks("ayo").isEmpty(),"a task has been completed");

    }

    @Test
    public void testThatTaskCanBeDeleted() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTask("i don tire for this life");
        taskRequest.setTaskAuthor(todoLogInRequest.getUserName());
        taskRequest.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        userServices.createTask(taskRequest);
        userServices.completeTask(taskRequest);
        userServices.deleteTask(taskRequest);
        assertTrue(userServices.findUserByUserName("ayo").getUsersTodoTask().isEmpty(),"a task has been completed");


    }

    @Test
    public void testThatUserCanUpdateTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName("ayo");
        todoSignUpRequest.setPassWord("1234");
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TodoLogInRequest todoLogInRequest1 = new TodoLogInRequest();
        todoLogInRequest1.setPassword("12345");
        todoLogInRequest1.setUserName("ayomide");
        TodoSignUpRequest todoSignUpRequest1 = new TodoSignUpRequest();
        todoSignUpRequest1.setUserName("ayomide");
        todoSignUpRequest1.setPassWord("12345");
        userServices.signUp(todoSignUpRequest1);
        userServices.logIn(todoLogInRequest1);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        userServices.createTask(taskRequest);
        assertEquals(userServices.findInCompletedTask().size(), 1);
        TaskRequest taskRequestForUpdate = new TaskRequest();
        taskRequestForUpdate.setTaskAuthor("ayomide");
        taskRequestForUpdate.setNewTask("my codes are massive");
        taskRequestForUpdate.setCompleted(true);
        taskRequestForUpdate.setTimeCompleted(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        taskRequestForUpdate.setTask("my codes");
        userServices.updateTask(taskRequestForUpdate);
        assertEquals(userServices.findCompletedTask().size(), 1);
    }


    @Test
    public void findAllUserCompletedTask() {
        TodoLogInRequest todoLogInRequest = new TodoLogInRequest();
        todoLogInRequest.setPassword("1234");
        todoLogInRequest.setUserName("ayo");
        TodoSignUpRequest todoSignUpRequest = new TodoSignUpRequest();
        todoSignUpRequest.setUserName(todoLogInRequest.getUserName());
        todoSignUpRequest.setPassWord(todoLogInRequest.getPassword());
        userServices.signUp(todoSignUpRequest);
        userServices.logIn(todoLogInRequest);
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        userServices.createTask(taskRequest);
        userServices.completeTask(taskRequest);
        assertFalse(userServices.findAllUserCompletedTasks("ayo").isEmpty(), "tasks have been completed");
    }

}