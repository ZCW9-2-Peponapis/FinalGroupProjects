package com.peponapis.finalproject.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany(mappedBy = "userDocument")
    @JsonManagedReference
    private List<Document> documents;
    @OneToMany(mappedBy = "userFolder")
    @JsonManagedReference
    private List<Folder> folders;

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(int userId, String name, String userName, String password, List<Document> documents, List<Folder> folders) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.documents = documents;
        this.folders = folders;
    }

    public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

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

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
