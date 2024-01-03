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

//    @OneToMany
//    private List<Document> documents;
//    @OneToMany
//    private List<Folder> folders;

}
