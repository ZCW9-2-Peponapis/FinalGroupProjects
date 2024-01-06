package com.peponapis.finalproject.serviceTests;

import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.repository.UserRepo;
import com.peponapis.finalproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    void testSaveUser() {
        // Arrange
        User userToSave = new User("John Doe", "johndoe", "password");
        when(userRepo.save(userToSave)).thenReturn(userToSave);

        // Act
        User savedUser = userService.saveUser(userToSave);

        // Assert
        assertEquals(userToSave, savedUser);
        verify(userRepo, times(1)).save(userToSave);
    }

    @Test
    void testFindByName() {
        // Arrange
        String name = "John Doe";
        User expectedUser = new User(name, "johndoe", "password");
        when(userRepo.findByName(name)).thenReturn(expectedUser);

        // Act
        User foundUser = userService.findByName(name);

        // Assert
        assertEquals(expectedUser, foundUser);
        verify(userRepo, times(1)).findByName(name);
    }

    @Test
    void testFindByUserName() {
        // Arrange
        String username = "johndoe";
        Optional<User> expectedUser = Optional.of(new User("John Doe", username, "password"));
        when(userRepo.findByUserName(username)).thenReturn(expectedUser);

        // Act
        Optional<User> foundUser = userService.findByUserName(username);

        // Assert
        assertEquals(expectedUser, foundUser);
        verify(userRepo, times(1)).findByUserName(username);
    }

    @Test
    void testFindByPassword() {
        // Arrange
        String password = "password";
        User expectedUser = new User("John Doe", "johndoe", password);
        when(userRepo.findByPassword(password)).thenReturn(expectedUser);

        // Act
        User foundUser = userService.findByPassword(password);

        // Assert
        assertEquals(expectedUser, foundUser);
        verify(userRepo, times(1)).findByPassword(password);
    }
}
