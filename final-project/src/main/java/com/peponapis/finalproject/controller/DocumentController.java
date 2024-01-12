package com.peponapis.finalproject.controller;

import com.peponapis.finalproject.dtos.DocumentDTO;
import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Document controller. Endpoints for the possible document operations are here.
 */
@RestController
@RequestMapping("/document")
@CrossOrigin (origins = "http://localhost:3000")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService){

        this.documentService = documentService;
//        this.authenticationFacade = authenticationFacade;
    }

    /**
     *
     * @return all documents in the db
     */
    @GetMapping("/getAll")
    public List<DocumentDTO> viewAllDocuments(){
        return this.documentService.getAllDocuments();
    }

    /**
     *
     * @param id id of the document
     * @return document associated with given id
     */
    @GetMapping("/view/{id}")
    public DocumentDTO viewDocument(@PathVariable("id") int id){
        return this.documentService.getDocument(id);
    }

    /**
     *
     * @param document Document with values to update
     * @return Document with updated values
     */
    @PatchMapping("/update")
    public DocumentDTO saveDocument(@RequestBody Document document){
        return this.documentService.updateDocument(document);
    }

    /**
     *
     * @param document new document to add to db
     * @return document that was added to db
     */
    @PostMapping("/create")
    public DocumentDTO createDocument(@RequestBody Document document){
        return this.documentService.createDocument(document);
    }

    /**
     *
     * @param filter search-term given by the user to filter through documents
     * @return list of documents matching the search-term
     */
    @GetMapping("/search")
    public List<DocumentDTO> searchDocuments(@RequestParam(value = "filter") String filter){
        return this.documentService.searchDocuments(filter);
    }

//    taking this out... DocRepo for explanation
//    @GetMapping("/allByUser")
//    public List<Document> getAllDocumentsByUserId(@RequestParam(value = "userId") int userId){
//        return this.documentService.getAllDocumentsByUser(userId);
//    }
}
