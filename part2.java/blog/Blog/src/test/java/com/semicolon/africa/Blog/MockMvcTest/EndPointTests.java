package com.semicolon.africa.Blog.MockMvcTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.Blog.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EndPointTests {
private MockMvc mockMvc;
@Autowired
private WebApplicationContext webApplicationContext;
ObjectMapper mapper = new ObjectMapper();

@BeforeEach
   public void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
}
//
//@Test
//  public void testThatUsersCanSignUp() throws JsonProcessingException {
//    User user = new User();
//    user.setPassword("password");
//    user.setUserName("user");
//    user.setLastName("lastName");
//    user.setFirstName("firstName");
//    user.setUserName("userName");
//    String jsonRequest = mapper.writeValueAsString(user);
//    MvcResult result = this.mockMvc.perform(post("/user/signup").accept(MediaType.APPLICATION_JSON)).content(jsonRequest)
//





}
