package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

//    @GetMapping("/id")
//    public List<User> getUserByID(User user) {
//       return userRepository.findBy;
//    }

    @PostMapping("/signup")
    public String createUser(@RequestBody User user) {
        List<User> users = userRepository.findAll();
        String message = "";
        Boolean found = false;


        for (User newUser : users) {
            if(newUser.getEmail() == user.getEmail()){
                // Don't allow to create user
                //send message back to frontend
                found = true;
                message =  "User with that Email already Exist!!!";
                break;
            }
        }

        if (!found) {
            userRepository.save(user);
            message = "Account Created Successfully!!";
        }

        return message;
    }

    @DeleteMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
//
//    @PostMapping("/create-account")
//    public ResponseEntity postCreateUser(HttpSession httpSession, @RequestBody User user){
//        System.out.println("in create");
//        if(service.createUser(user)){
//            httpSession.setAttribute("screenname", user.getScreenName());
//            return new ResponseEntity("Account successfully created", HttpStatus.CREATED);
//        }
//        return new ResponseEntity("Can't create user account", HttpStatus.UNPROCESSABLE_ENTITY);
//    }


}
