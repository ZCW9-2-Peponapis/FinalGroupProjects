package com.peponapis.finalproject.service;


import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public User saveUser(User user){
        return userRepo.save(user);
    }
    public User findByName(String name){
        return userRepo.findByName(name);
    }
    public User findByUserName(String username){
        return userRepo.findByUserName(username);
    }
    public User findByPassword(String password) {
        return userRepo.findByPassword(password);
    }

    //    public User findByUserNameAndPassword(User info){
//        return userRepo.findByUserNameAndPassword(info);
//    }  Planning to implement later *** Need to see if controller is needed for this method
}
