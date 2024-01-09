package com.peponapis.finalproject.service;


import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.naming.AuthenticationException;
import java.util.Optional;

/**
 * User Service. Operations relating to users are found here.
 */

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    // Password encoder to ensure password security in database

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @param user to create or update
     * @return the new user into the user repo
     * if the username already exists, unable to create user
     */
    public User saveUser(User user){
        if (userRepo.existsByUserName(user.getUserName())){
            return null;
        }
        String password = passwordEncoder.encode((user.getPassword()));
        user.setPassword(password);
        return userRepo.save(user);
    }

    /**
     * @param id for the user
     * @return the user with given id or return null
     */
    public User getUser(int id){
        if(userRepo.findById(id).isPresent()){
            return userRepo.findById(id).get();
        }
        return null;
    }

    /**
     *
     * @param name of the user
     * @return the user with given name that exists in user repo
     */
    public User findByName(String name){
        return userRepo.findByName(name);
    }

    /**
     *
     * @param username of the user
     * @return the username with given username that exists in user repo
     */
    public Optional<User> findByUserName(String username){
        return userRepo.findByUserName(username);
    }

    /**
     *
     * @param password of the user,
     * user password is encrypted, must encrypt the password before searching,
     * @return the password that is given that exists in user repo
     */
    public User findByPassword(String password) {
        String encryptPass = passwordEncoder.encode(password);
        return userRepo.findByPassword(encryptPass);
    }

    /**
     *
     * @param username of the user
     * @param password of the user
     * @return User is authenticated
     * @throws AuthenticationException if user is not authenticated throws exception
     *                                  for username and user password
     */

    public User authenicatorUser (String username, String password) throws AuthenticationException {
        User user = userRepo.findByUserName(username)
                .orElseThrow(() -> new AuthenticationException("Username doesn't exist"));
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new AuthenticationException("Invalid Login");
        }
        return user;
    }
}
