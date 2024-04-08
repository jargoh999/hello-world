package com.semicolon.africa.real.task.data.models;
import com.semicolon.africa.real.task.converter.TaskAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.var;


import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "Task's owner")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
   private String userName;
   @Convert(converter = TaskAttributeConverter.class)
   @OneToMany(fetch = FetchType.EAGER)
   private List<TodoTask> usersTodoTask = new ArrayList<>();
   private String passWord;
   private boolean isActive;
}
