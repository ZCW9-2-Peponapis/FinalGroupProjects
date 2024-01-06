package com.peponapis.finalproject.repository;

import com.peponapis.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   Optional<User> findByUserName(String userName);
   User findByName(String name);
   User findByPassword(String password);
   boolean existsByUserName (String username);

   //   User findByUserNameAndPassword(User user); See in userService - comment

}
