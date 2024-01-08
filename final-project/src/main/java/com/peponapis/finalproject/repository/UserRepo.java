package com.peponapis.finalproject.repository;

import com.peponapis.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

/**
 * User Repository. Interacts with MySQL database for user entity.
 */
@Repository
@CrossOrigin(origins = "http://localhost:3000")
public interface UserRepo extends JpaRepository<User, Integer> {
   Optional<User> findByUserName(String userName);
   User findByName(String name);
   User findByPassword(String password);
   boolean existsByUserName (String username);

}
