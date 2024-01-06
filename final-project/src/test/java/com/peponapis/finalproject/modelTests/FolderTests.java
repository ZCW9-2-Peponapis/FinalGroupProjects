package com.peponapis.finalproject.modelTests;

import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.Folder;
import com.peponapis.finalproject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class FolderTests {

  @Test
    public void testFolderNullConstruction(){
    Folder folder = new Folder();
    Assertions.assertNotNull(folder);
  }

  @Test
  public void testFolderConstructor(){
     String title = "title";
     int userId = 1;

    Folder folder = new Folder();

    Assertions.assertNotNull(folder);
  }


  @Test
  public void testSetFolderId(){

  }

  @Test
  public void testGetFolderId(){
    Folder folder = new Folder();
    Assertions.assertEquals(-1,folder.getFolderId());

  }

  @Test
  public void testFolderGetTitle(){

  }

  @Test
  public void testFolderSetTitle(){
    String title = "title";
    Folder folder = new Folder();

    folder.setTitle(title);

    Assertions.assertEquals(title, folder.getTitle());

  }



  @Test
  public void testFolderSetCreationDate(){

  }

  @Test
  public void testFolderGetCreationDate(){

  }

  @Test
  public void testFolderGetModification(){



  }

  @Test
  public void testFolderSetModification(){

    Folder folder = new Folder();
    Date date = new Date();

    folder.setModificationDate(date);
    Assertions.assertEquals(date, folder.getModificationDate());

  }

  @Test
  public void testFolderGetUserId() {
  }

  @Test
  public void testFolderSetUserId(){


  }

  @Test
  public void  testFolderGetDocs(){

  }

  @Test
  public void testFolderSetDocs(){

  }
}
