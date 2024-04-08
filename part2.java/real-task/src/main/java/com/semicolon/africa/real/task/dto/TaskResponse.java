package com.semicolon.africa.real.task.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskResponse {
    private String task;
    private boolean isCompleted;
    private LocalDateTime timeCompleted;
    private LocalDateTime timeCreated;
    private String taskAuthor;
}
