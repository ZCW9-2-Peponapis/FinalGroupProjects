package com.peponapis.finalproject.modelTests;

import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.Folder;
import com.peponapis.finalproject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {

    @Test
    public void getAndSetUserId() {

        User user = new User();

        user.setUserId(1);

        Integer expected = 1;

        Assertions.assertEquals(expected, user.getUserId());
    }
    @Test
    public void getAndSetName() {

        User user = new User();
        user.setName("Bob");

        String expected = "Bob";

        Assertions.assertEquals(expected, user.getName());
    }
    @Test
    public void getAndSetUserName() {

        User user = new User();
        user.setUserName("username");

        String expected = "username";

        Assertions.assertEquals(expected, user.getUserName());
    }
    @Test
    public void getAndSetPassword() {

        User user = new User();
        user.setPassword("FacebookStoresItInATextFile");

        String expected = "FacebookStoresItInATextFile";

        Assertions.assertEquals(expected, user.getPassword());
    }
    @Test
    public void getAndSetUserDocuments() {

        User user = new User();

        Document document = new Document();

        // How to set up test for getting document.
    }
    @Test
    public void getAndSetUserFolders() {

        User user = new User();

        Folder folder = new Folder();

        //How to set up test for getting folders and also place documents in.
    }

}
