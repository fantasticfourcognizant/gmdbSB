package com.cognizant.gmdb_be;

import com.cognizant.gmdb_be.Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getUsers() throws Exception {
        mvc.perform(
                get("/"))
                        .andExpect(status().isOk());

    }

    @Test
    public void createNewUser() throws Exception {

        User user = new User();
        user.setEmail("md@test.com");
        user.setPassword("testing");
        user.setScreenName("md");

        String jsonInString = mapper.writeValueAsString(user);

        mvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString))
                .andExpect(status().is(201));
  }

    @Test
    public void checkExistingUser() throws Exception {

        User user = new User();
        user.setEmail("test5@test.com");
        user.setPassword("test2");
        user.setScreenName("md");

        String jsonInString = mapper.writeValueAsString(user);

        mvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString))
                .andExpect(status().is(422));
    }

}
