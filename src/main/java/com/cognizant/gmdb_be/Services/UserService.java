package com.cognizant.gmdb_be.Services;

import com.cognizant.gmdb_be.Models.User;
import com.cognizant.gmdb_be.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUser(String email, String password) {
        List<User> users = userRepository.findUserModelByEmail(email);
        User user = users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst().orElse(null);
        if(user == null) return null;
        else return user;
    }

    public boolean createUser(User user) {
        List<User> users = userRepository.findAll();

        for (User newUser : users) {
            if(newUser.getEmail().equals(user.getEmail())){
                return false;
            }

        }
        userRepository.save(user);
        return true;
    }
}
