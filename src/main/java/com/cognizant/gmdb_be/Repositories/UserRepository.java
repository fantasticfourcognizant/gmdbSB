package com.cognizant.gmdb_be.Repositories;

import com.cognizant.gmdb_be.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
