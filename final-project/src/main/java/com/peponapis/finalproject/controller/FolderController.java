package com.peponapis.finalproject.controller;

import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.Folder;
import com.peponapis.finalproject.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FolderController {

    FolderService folderService;
@Autowired
    public FolderController (FolderService folderService){
          this.folderService = folderService;
    }


@GetMapping
    public List<Document> viewDocs(int folderId){
       return this.folderService.getDocsInFolder(folderId);
    }
@GetMapping
    public Folder createFolder(Folder folder){
      return this.folderService.saveFolder(folder) ;
    }
@GetMapping
    public void deleteFolder(int folderId){
      folderService.deleteFolder(folderId);
    }

@GetMapping
    public Folder updateFolder(Folder folder){
     return folderService.saveFolder(folder);
    }
}
