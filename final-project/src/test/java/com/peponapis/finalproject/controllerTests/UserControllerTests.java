package com.peponapis.finalproject.controllerTests;

import com.peponapis.finalproject.controller.UserController;
import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.service.UserService;
import org.hibernate.engine.spi.ExceptionConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    void contextLoads(){

    }

    @Test
    public void registerUserTest() throws Exception {
        when(userService.findByUserName("userTest")).thenReturn( new User());
        when(userService.findByPassword("testPassword")).thenReturn(new User());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                .param("userName", "userTest")
                .param("password", "testPassword"));
    }

    @Test
    public void loginUserTest() throws Exception {
        when(userService.findByUserName("userTest")).thenReturn( new User());
        when(userService.findByPassword("testPassword")).thenReturn(new User());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/login")
                .param("userName", "userTest")
                .param("password", "testPassword"));

    }
}
