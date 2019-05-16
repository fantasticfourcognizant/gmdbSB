package com.cognizant.gmdb_be.Controllers;


import com.cognizant.gmdb_be.Models.Movie;
import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.MovieRepository;
import com.cognizant.gmdb_be.Services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieService movieService) { this.movieService = movieService; }

    @GetMapping("/allmovies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();

    }

    @GetMapping("/movie/title")
    public List<Movie> getMoviebyTitle(@RequestParam(value="title") String title) {
        return movieRepository.findMovieByTitle(title);

    }


    @GetMapping("/movie/year")
    public List<Movie> getMovieByYear(@RequestParam(value="year") String year) {
        return movieRepository.findMovieByYear(year);

    }

    @PostMapping("/movie")
    public ResponseEntity createMovie(@RequestBody Movie movie) {

        boolean movieExists = false;

        List<Movie> movies = movieRepository.findAll();

        for (Movie movie1 : movies) {
            if(movie1.getTitle().equals(movie.getTitle())){
                movieExists = true;
            }

        }
        if(!movieExists){
            movieRepository.save(movie);
            return new ResponseEntity("Movie added!!", HttpStatus.CREATED);
        }else{
            return new ResponseEntity("Movie already exists!!", HttpStatus.ALREADY_REPORTED);
        }

    }

}
