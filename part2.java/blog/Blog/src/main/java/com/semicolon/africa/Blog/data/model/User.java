package com.semicolon.africa.Blog.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document("Users")
public class User {
    private String firstName;
    private String lastName;
    @Id
    private String  id;
    private String password;
    private String userName;
    @DBRef
    private List<Post> posts = new ArrayList<>();
    private boolean isLoggedIn;
}
