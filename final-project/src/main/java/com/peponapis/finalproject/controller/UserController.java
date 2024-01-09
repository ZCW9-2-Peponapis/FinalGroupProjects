package com.peponapis.finalproject.controller;
import com.peponapis.finalproject.model.UserEntity;
import com.peponapis.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

/**
 * User Controller. End points for user registration and user login with authentication
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private final UserService userService;
    AuthenticationManager authenticationManager;
    public UserController(UserService userService, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    /**
     *
     * @param userEntity new user to add to db
     * @return user that was added to db
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity) {
        try {
            UserEntity newUserEntity = userService.saveUser(userEntity);
            return new ResponseEntity<>(newUserEntity, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("User registration failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param userEntity takes in a username and password for user login
     * @return user able to log in with authentication with correct username and password
     * @throws AuthenticationException if user is not authenticated with username or password
     */
    @PostMapping("/login")
    public ResponseEntity<?> authorizeLogin(@RequestBody UserEntity userEntity) throws AuthenticationException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getUserName(), userEntity.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch(BadCredentialsException e){
            System.out.println("Bad Credentials!");
        }
        UserEntity authenticatedUserEntity = userService.authenicatorUser(userEntity.getUserName(), userEntity.getPassword());
            return new ResponseEntity<>(authenticatedUserEntity, HttpStatus.OK);
    }


    /** Method for users to get all documents created by user
     * May need to implement later as need */

    // @GetMapping for method type List<Documents> getAllDocuments();

}
