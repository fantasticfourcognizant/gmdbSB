package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import com.cognizant.gmdb_be.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

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

    @PostMapping("/login")
    public String loginUser(HttpSession httpSession, ModelMap model, @RequestParam String email, @RequestParam String password ) {
        User user = userService.validateUser(email, password);

        if (user == null) {
            model.put("errorMessage", "Invalid Credentials");
            return "User not found!";
        }

        model.put("email", email);
        model.put("password", password);
        httpSession.setAttribute("screenname", user.getScreenName());
        httpSession.setAttribute("userid", user.getId());
        return "Welcome" + " " + user.getScreenName();
    }



    @DeleteMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
