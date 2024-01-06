package com.peponapis.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Document entity used to model all the information for the documents in the program.
 */
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id; // unique id for the document
    String title; // name/title of the document
    String body; // the text within the document
    Date creationDate; // date that document is created
    Date modificationDate; // date that document is modified

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    User user; // user who created the document

    @OneToOne
    Folder folder; // folder the document is in

    /**
     *
     * TODO: ADD A METHOD/ENDPOINT FOR GETTING ALL DOCUMENTS CREATED BY A USER
     */


    public Document(){
        this.id = -1;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }

    public Document(String title, String body, int userId){
        this.title = title;
        this.body = body;
        // the dates will be automatically created upon
        // call to constructor
        this.creationDate = new Date();
        this.modificationDate = new Date();
        this.user = user;
    }

    public int getId() {
        return id;
    }

    // public void setId(int id) { this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    // public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
