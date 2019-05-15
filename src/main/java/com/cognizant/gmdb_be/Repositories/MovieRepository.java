package com.cognizant.gmdb_be.Repositories;

import com.cognizant.gmdb_be.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {



    List<Movie> findMovieByTitle(String title);

//    List<Movie> findMovieByYear(String year);

}
