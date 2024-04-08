package com.semicolon.africa.Blog.dtos;
import com.semicolon.africa.Blog.data.model.Post;
import lombok.Data;
import java.util.List;
@Data
public class LogInResponse {
        private String userName;
        private List<Post> posts;
}
