package com.peponapis.finalproject.dtos;

import com.peponapis.finalproject.model.UserEntity;

public class UserDTO {
    int id;
    String name;

    public UserDTO(UserEntity user){
        this.id = user.getUserId();
        this.name = user.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
