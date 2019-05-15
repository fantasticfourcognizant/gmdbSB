package com.cognizant.gmdb_be.Controllers;

import com.cognizant.gmdb_be.Models.Login;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.*;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/alluser")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for(User user1 : users){
            System.out.println(user1.getEmail());
        }
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity createUser(@RequestBody User user) {
        boolean response = userService.createUser(user);

        if (response == false) {
            return new ResponseEntity("User already exists!!", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity("User created!!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(HttpSession httpSession, ModelMap model, @RequestBody Login login) {
        User user = userService.validateUser(login.getEmail(), login.getPassword());

        if (user == null) {
            model.put("errorMessage", "Invalid Credentials");
            return new ResponseEntity("User not found!", HttpStatus.NOT_FOUND);
        }

        model.put("email", login.getEmail());
        model.put("password", login.getPassword());
        httpSession.setAttribute("screenname", user.getScreenName());
        httpSession.setAttribute("userid", user.getId());

        ObjectMapper mapper = new ObjectMapper();
        String json = new String();
        try{
            json = mapper.writeValueAsString(user);
        }catch (Exception  e) {
            // catch various errors
            e.printStackTrace();
        }


        return new ResponseEntity<>(json, HttpStatus.OK);
    }



    @DeleteMapping("/deleteUsers")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
