package com.cognizant.gmdb_be.Repositories;

import com.cognizant.gmdb_be.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
}
