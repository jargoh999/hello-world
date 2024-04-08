package com.semicolon.africa.real.task.data.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "todo task")
public class TodoTask {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long id;
    private String task;
    private boolean isCompleted;
    private LocalDateTime timeCompleted;
    private LocalDateTime timeCreated;
    private String taskAuthor;
    private String newTask;
}
