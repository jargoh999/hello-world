package com.semicolon.africa.real.task.dto;

import com.semicolon.africa.real.task.data.models.TodoTask;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
@Data
public class TodoLogInResponse {
    private List<TodoTask> usersTodoTask = new ArrayList<>();
    private String username;
    private boolean isActive;
}
