package com.semicolon.africa.Blog.controllers;

import com.semicolon.africa.Blog.Exceptions.UserExceptions;
import com.semicolon.africa.Blog.dtos.*;
import com.semicolon.africa.Blog.services.CommentServicesImpl;
import com.semicolon.africa.Blog.services.PostServicesImpl;
import com.semicolon.africa.Blog.services.UserServicesImpl;
import com.semicolon.africa.Blog.services.ViewServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class UserServicesController {
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private ViewServicesImpl viewServices;
    @Autowired
    private PostServicesImpl postServices;
    @Autowired
    private CommentServicesImpl commentServices;

     @PostMapping("/signup")
     public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest){
          try {
              return new ResponseEntity<>(new ApiResponses(true,userServices.signUp(registerRequest)), CREATED);
          }catch (UserExceptions e){
                return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
          }
     }

   @PostMapping ("/log-in")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userServices.logIn(logInRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }

    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody PostRequest postRequest){
         try {
             return new ResponseEntity<>(postServices.createPost(postRequest), CREATED);
         }catch(UserExceptions exceptions){
             return new ResponseEntity<>(exceptions.getMessage(),BAD_REQUEST);
         }
    }


    @GetMapping("/view-user-posts/{username}")
    public ResponseEntity<?> viewUserPost(@PathVariable String username){
          try {
              return new ResponseEntity<>(postServices.getAllPostsOf(username), GONE);
          }catch(UserExceptions e){
              return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
          }
    }

    @PostMapping("/view-a-post")
     public ResponseEntity<?> viewPost(@RequestBody ViewRequest viewRequest){
         try {
             return new ResponseEntity<>(viewServices.viewPosts(viewRequest),CREATED);
         }catch (UserExceptions e){
              return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
         }
    }

    @PostMapping("/delete-a-post")
    public ResponseEntity<?> deletePost(@RequestBody PostRequest postRequest){
        try {
            return new ResponseEntity<>(new ApiResponse("post successfully deleted",postServices.deletePostBy(postRequest)),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }


    @PostMapping("/comment-to-a-post")
    public ResponseEntity<?> commentToPost(@RequestBody CommentRequest commentRequest){
        try {
            return new ResponseEntity<>(commentServices.commentToPost(commentRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }



    @PostMapping("/delete-a-comment")
    public ResponseEntity<?> deleteComment(@RequestBody CommentRequest commentRequest){
        try {
            return new ResponseEntity<>(commentServices.deleteCommentBy(commentRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }

  @PostMapping("/update-post")
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostRequest updatePostRequest){
        try {
            return new ResponseEntity<>(postServices.updatePost(updatePostRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }
    @GetMapping("/find all post")
    public ResponseEntity<?> findAllPosts(){
        try {
            return new ResponseEntity<>(postServices.findAll(),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }

}
