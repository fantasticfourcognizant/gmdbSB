package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for(User user1 : users){
            System.out.println(user1.getEmail());
        }
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity createUser(@RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User newUser : users) {
            System.out.println(newUser);
            if(newUser.getEmail().equals(user.getEmail())){
                return new ResponseEntity("User already exists!!", HttpStatus.UNPROCESSABLE_ENTITY);
            }

        }

        userRepository.save(user);
        return new ResponseEntity("User created!!", HttpStatus.CREATED);
    }



    @DeleteMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
