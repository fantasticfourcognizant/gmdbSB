package com.cognizant.gmdb_be.Services;


import com.cognizant.gmdb_be.Models.Movie;
import com.cognizant.gmdb_be.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }






}
