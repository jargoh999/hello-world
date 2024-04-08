package org.semicolon.africa.repositories;
import org.junit.jupiter.api.Test;
import org.semicolon.africa.model.User;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class UsersTest {

private Users users;
@Test
 public void testUsersRepo(){
  User user = new User();
 users.save(user);
 assertEquals(users.count(), 1L);

}



}