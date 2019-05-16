package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.Movie;
import com.cognizant.gmdb_be.Models.Review;
import com.cognizant.gmdb_be.Repositories.ReviewRepository;
import com.cognizant.gmdb_be.Services.ReviewService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/all-reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        System.out.println("we are here");
       
        List<Review> reviews = reviewRepository.findAll();

        System.out.println(reviews);
        return new ResponseEntity<>( reviews , HttpStatus.OK);
    }

    @PostMapping("/add-review")
    public ResponseEntity<String> postNewReviewPage(@RequestParam String imdbId, @RequestParam Long userId, @RequestParam String reviewTitle, @RequestParam String reviewBody){
        if(userId==null){
            return new ResponseEntity<String>("You must be logged in to add a review.", HttpStatus.FORBIDDEN);
        }

        Movie movie = reviewService.addReview(imdbId,userId,reviewTitle,reviewBody);
            return new ResponseEntity("Review added Successfully!", HttpStatus.OK);
    }
//
//    @PutMapping("/update-review")
//    public ResponseEntity updateReview(@RequestParam String imdbId, @RequestParam Long userId, @RequestParam Long reviewId, @RequestParam String reviewTitle, @RequestParam String reviewBody) {
//        if(userId==null){
//            return new ResponseEntity("You must be logged in to add a review.", HttpStatus.FORBIDDEN);
//        }
//
//        Movie movie = reviewService.updateReview(imdbId, userId, reviewId, reviewTitle, reviewBody);
//        return new ResponseEntity("Review added Successfully!", HttpStatus.OK);
//    }

}
