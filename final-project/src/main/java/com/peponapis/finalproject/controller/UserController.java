package com.peponapis.finalproject.controller;


import com.peponapis.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //RestController - end points
    //Controllers - pages

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public String userRegister(){
        return null;
    }
    @PostMapping("/login")
    public String userLogin(){
        return null;
    }

}
