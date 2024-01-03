package com.peponapis.finalproject.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User { //implement UserDetails (later on for user auth)


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String userName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    @OneToMany
//    private List<Document> documents;
//    @OneToMany
//    private List<Folder> folders;

}
