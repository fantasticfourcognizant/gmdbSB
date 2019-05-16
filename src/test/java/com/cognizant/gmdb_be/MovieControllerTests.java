package com.cognizant.gmdb_be;

import com.cognizant.gmdb_be.Models.Login;
import com.cognizant.gmdb_be.Models.Movie;
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

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTests {

    @Autowired
    private MockMvc mvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getMovies() throws Exception {
        mvc.perform(
                get("/allmovies"))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnMovieStatus() throws Exception{

        mvc.perform(
                get("/movie/title?title=Avengers: Endgame")).andExpect(status().isOk());
    }

    @Test
    public void getMovieByTitle() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/movie/title?title=Avengers: Endgame")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", is("Avengers: Endgame")));
    }


    @Test
    public void getMovieByYear() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/movie/year?year=2017")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].year").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].year", is("2017")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", is("Guardians of the Galaxy Vol. 2")));
    }


}

