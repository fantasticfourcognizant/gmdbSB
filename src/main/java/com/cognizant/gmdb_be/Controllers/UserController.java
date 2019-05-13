package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUser() {
        return userRepository.findAll();
    }

//    @GetMapping("/id")
//    public List<User> getUserByID(User user) {
//       return userRepository.findBy;
//    }

    @PostMapping("/")
    public void postUser(@RequestBody User user) {
        userRepository.save(user);
    }

}
