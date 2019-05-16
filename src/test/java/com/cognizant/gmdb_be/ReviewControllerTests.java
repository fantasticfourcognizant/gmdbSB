package com.cognizant.gmdb_be;

import com.cognizant.gmdb_be.Models.Movie;
import com.cognizant.gmdb_be.Models.Review;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTests {

    @Autowired
    private MockMvc mvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void addReview() throws Exception {

        mvc.perform(post("/add-review")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
                .param("imdbId","tt0068646")
                .param("userId", "21")
                .param("reviewBody", "review body 2")
                .param("reviewTitle", "Rveiew Title 2")
                .param("lastUpdated", "2019-04-15"))
                .andExpect(status().is(200));
    }
}
