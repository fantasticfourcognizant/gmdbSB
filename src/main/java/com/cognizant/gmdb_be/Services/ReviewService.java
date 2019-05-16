package com.cognizant.gmdb_be.Services;

import com.cognizant.gmdb_be.Models.Movie;
import com.cognizant.gmdb_be.Models.Review;
import com.cognizant.gmdb_be.Repositories.MovieRepository;
import com.cognizant.gmdb_be.Repositories.ReviewRepository;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ReviewService {


    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository, UserRepository userRepository){
       this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public Movie addReview(String imdbId, Long userId, String reviewTitle, String reviewBody){
        Review review= new Review();
        review.setMovie(movieRepository.findMovieModelByImdbid(imdbId));
        review.setUser(userRepository.findDistinctById(userId));
        review.setReviewText(reviewBody);
        review.setReviewTitle(reviewTitle);
        review.setLastUpdated(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        reviewRepository.save(review);
        return review.getMovie();
    }

//    public Movie updateReview(String imdbId, Long reviewId, Long userId, String reviewTitle, String reviewBody){
//        Review review= new Review();
//        review.setMovie(movieRepository.findMovieModelByImdbid(imdbId));
//        review.setUser(userRepository.findDistinctById(userId));
//
//        if(review.getId().equals(reviewId)){
//            review.setReviewText(reviewBody);
//            review.setReviewTitle(reviewTitle);
//            review.setLastUpdated(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
//            reviewRepository.save(review);
//        }
//        return review.getMovie();
//    }


}
