package com.peponapis.finalproject.controller;

import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Document controller. Endpoints for the possible document operations are here.
 */
@Controller
@RequestMapping("document")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService){
        this.documentService = documentService;
    }

    /**
     *
     * @return all documents in the db
     */
    @GetMapping("/view/")
    public List<Document> viewAllDocuments(){
        return this.documentService.getAllDocuments();
    }

    /**
     *
     * @param id id of the document
     * @return document associated with given id
     */
    @GetMapping("/view/{id}")
    public Document viewDocument(@PathVariable("id") int id){
        return this.documentService.getDocument(id);
    }

    /**
     *
     * @param document Document with values to update
     * @return Document with updated values
     */
    @PatchMapping("/update")
    public Document saveDocument(Document document){
        return this.documentService.saveDocument(document);
    }

    /**
     *
     * @param document new document to add to db
     * @return document that was added to db
     */
    @PostMapping("/create")
    public Document creatDocument(Document document){
        return this.documentService.saveDocument(document);
    }

    /**
     *
     * @param filter search-term given by the user to filter through documents
     * @return list of documents matching the search-term
     */
    @GetMapping("/search")
    public List<Document> searchDocuments(@RequestParam(value = "filter") String filter){
        return this.documentService.searchDocuments(filter);
    }
}
