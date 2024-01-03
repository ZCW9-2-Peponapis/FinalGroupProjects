package com.peponapis.finalproject.controller;
import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public User userRegister(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("/login")
    public User userLogin(@RequestBody User user){
        if((userService.findByUserName(user.getUserName()).equals(user.getUserName()))
                && (userService.findByPassword(user.getPassword()).equals(user.getPassword()))){
            return user;
        }
            return null;  // Login does not exist for user.
    }
}
