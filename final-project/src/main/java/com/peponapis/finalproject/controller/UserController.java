package com.peponapis.finalproject.controller;
import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.saveUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("User registration failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authorizeLogin(@RequestBody User user) throws AuthenticationException {
            User authenticatedUser = userService.authenicatorUser(user.getUserName(), user.getPassword());
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
    }

    // users to get all documents back
    // GetMapping for method type List<Documents> getAllDocuments ()
    // get back all documents back
    // If we want to add for a

}
