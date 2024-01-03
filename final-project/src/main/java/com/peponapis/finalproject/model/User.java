package com.peponapis.finalproject.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {


    @Id
    private int userId;
    private String name;
    private String userName;
    private String password;
    @OneToMany
    private List<Document> documents;
    @OneToMany
    private List<Folder> folders;

}
