package com.semicolon.africa.real.task.services;
import com.semicolon.africa.real.task.data.models.TodoTask;
import com.semicolon.africa.real.task.dto.TaskRequest;
import com.semicolon.africa.real.task.repositories.TodoTasks;
import lombok.experimental.Wither;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TodoTaskServicesImplTest {
    @Autowired
    private TaskServicesImpl taskServices;
    @Autowired
    private TodoTasks todoTasks;

    @BeforeEach
    public void setTaskServices(){
        todoTasks.deleteAll();
    }

    @Test
    public void testThatTaskCanBeCompleted() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
        taskServices.completeTask(taskRequest);
        assertEquals(taskServices.findCompletedTask().size(), 1);
    }


    @Test
    public void testThatAllInCompletedTaskCanBeFound() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
  }

    @Test
   public void testThatTaskCanBeCreated() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
    }

    @Test
    public void testThatTasksCanBeCompletedAndFound() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        taskServices.completeTask(taskRequest);
        assertEquals(taskServices.findCompletedTask().size(),1);
    }

    @Test
    public void testThatTaskCanBeDeleted() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        taskServices.deleteTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 0);
    }

    @Test
    public void testThatTaskCanBeUpdated() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
        TaskRequest taskRequestForUpdate = new TaskRequest();
        taskRequestForUpdate.setTaskAuthor("ayomide");
        taskRequestForUpdate.setNewTask("my codes are massive");
        taskRequestForUpdate.setCompleted(true);
        taskRequestForUpdate.setTimeCompleted(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        taskRequestForUpdate.setTask("my codes");
        taskServices.updateTask(taskRequestForUpdate);
        assertNotNull(taskServices.findTodoTaskByTask("my codes are massive"));
        assertEquals(taskServices.findCompletedTask().size(), 1);
        assertEquals(taskServices.findAllUserCompletedTask("ayomide")
        .stream().map(TodoTask::getTask).collect(Collectors.joining()),taskRequestForUpdate.getNewTask());
    }
    @Test
    public void getAllUserCompletedTask() {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
        TaskRequest taskRequestForUpdate = new TaskRequest();
        taskRequestForUpdate.setTaskAuthor("ayo");
        taskRequestForUpdate.setTask("my codes1");
        taskServices.createTask(taskRequestForUpdate);
        taskServices.completeTask(taskRequest);
        taskServices.completeTask(taskRequestForUpdate);
        assertEquals(taskServices.findCompletedTask().size(), 2);
        assertEquals(taskServices.findAllUserCompletedTask("ayo").size(), 2);

   }

    @Test
    public void getAllUsersTask(){
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("ayo");
        taskRequest.setTask("my codes");
        taskServices.createTask(taskRequest);
        assertEquals(taskServices.findInCompletedTask().size(), 1);
        TaskRequest taskRequestForUpdate = new TaskRequest();
        taskRequestForUpdate.setTaskAuthor("ayo");
        taskRequestForUpdate.setTask("my codes1");
        taskServices.createTask(taskRequestForUpdate);
        taskServices.completeTask(taskRequest);
        taskServices.completeTask(taskRequestForUpdate);
        assertEquals(taskServices.findCompletedTask().size(), 2);
        assertEquals(taskServices.userTodoTasks("ayo").size(),2);
 }
}