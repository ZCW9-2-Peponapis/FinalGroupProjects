package com.peponapis.finalproject.service;


import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    public User saveUser(User user){
        if (userRepo.existsByUserName(user.getUserName())){
            return null;
        }
        String password = passwordEncoder.encode((user.getPassword()));
        user.setPassword(password);

        return userRepo.save(user);
    }
    public User findByName(String name){
        return userRepo.findByName(name);
    }
    public Optional<User> findByUserName(String username){
        return userRepo.findByUserName(username);
    }
    public User findByPassword(String password) {
        return userRepo.findByPassword(password);
    }

    public User authenicatorUser (String username, String password) throws AuthenticationException {
        User user = userRepo.findByUserName(username)
                .orElseThrow(() -> new AuthenticationException("Username doesn't exist"));
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new AuthenticationException("Invalid Login");
        }
        return user;
    }
}
