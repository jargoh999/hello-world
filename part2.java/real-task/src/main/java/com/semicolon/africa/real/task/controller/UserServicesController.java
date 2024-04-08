package com.semicolon.africa.real.task.controller;

import com.semicolon.africa.real.task.dto.TaskRequest;
import com.semicolon.africa.real.task.dto.TodoLogInRequest;
import com.semicolon.africa.real.task.dto.TodoSignUpRequest;
import com.semicolon.africa.real.task.exception.TodoExceptions;
import com.semicolon.africa.real.task.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/todo-list")
public class UserServicesController {

     @Autowired
     private UserServicesImpl userServices;

     @PostMapping("/sign-up")
     public ResponseEntity<?> signUp(@RequestBody TodoSignUpRequest todoSignUpRequest){
         try {
             return new ResponseEntity<>(userServices.signUp(todoSignUpRequest),CREATED);
         }catch (TodoExceptions todoExceptions){
              return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
         }
     }

    @PostMapping("/log-in")
    public ResponseEntity<?> logIn(@RequestBody TodoLogInRequest todoLogInRequest){
        try {
            return new ResponseEntity<>(userServices.logIn(todoLogInRequest),CREATED);
        }catch (TodoExceptions todoExceptions){
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logOut(@RequestBody TodoLogInRequest todoLogInRequest){
        try {
            return new ResponseEntity<>(userServices.logOut(todoLogInRequest),CREATED);
        }catch (TodoExceptions todoExceptions){
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/delete-task")
    public ResponseEntity<?> deleteTask(@RequestBody TaskRequest taskRequest){
        try {
            return new ResponseEntity<>(userServices.deleteTask(taskRequest),CREATED);
        }catch (TodoExceptions todoExceptions){
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        try {
            return new ResponseEntity<>(userServices.createTask(taskRequest), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/update-task")
    public ResponseEntity<?> updateTask(@RequestBody TaskRequest taskRequest) {
        try {
            return new ResponseEntity<>(userServices.updateTask(taskRequest), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }


    @PostMapping("/complete-task")
    public ResponseEntity<?> completeTask(@RequestBody TaskRequest taskRequest) {
        try {
            return new ResponseEntity<>(userServices.completeTask(taskRequest), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }


    @GetMapping("/show-all-task/{author}")
    public ResponseEntity<?> getAllAuthorTask(@PathVariable("author") String author){
        try {
            return new ResponseEntity<>(userServices.findAllUserTasks(author), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }


    @GetMapping("/show-all-uncompleted-task/{author}")
    public ResponseEntity<?> getAllAuthorUncompletedTask(@PathVariable("author") String author){
        try {
            return new ResponseEntity<>(userServices.findAllUserInCompletedTask(author), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }


    @GetMapping("/show-all-completed-task/{author}")
    public ResponseEntity<?> getAllAuthorCompletedTask(@PathVariable("author") String author){
        try {
            return new ResponseEntity<>(userServices.findAllUserCompletedTasks(author), CREATED);
        } catch (TodoExceptions todoExceptions) {
            return new ResponseEntity<>(todoExceptions.getMessage(), BAD_REQUEST);
        }
    }

}
