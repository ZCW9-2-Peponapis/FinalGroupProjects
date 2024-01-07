package com.peponapis.finalproject.service;

import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.User;
import com.peponapis.finalproject.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

/**
 * Document service. Operations relating to Document are found here.
 */
@Service
public class DocumentService {
    DocumentRepo documentRepo;

    @Autowired
    public DocumentService(DocumentRepo documentRepo){
        this.documentRepo = documentRepo;
    }

    /**
     *
     * @param document document to update
     * @return the new document
     */
    public Document saveDocument(Document document){
        return this.documentRepo.save(document);
    }

    /**
     *
     * @return all documents within the db as a list
     */
    public List<Document> getAllDocuments(){
        return this.documentRepo.findAll();
    }

    /**
     *
     * @param id id of the document
     * @return the document with the given id, or null
     */
    public Document getDocument(int id){
        if(this.documentRepo.findById(id).isPresent()) {
            return this.documentRepo.findById(id).get();
        }
        return null;
    }

//    Probably don't need this, it's the same as saveDocument
//    public Document createDocument(Document document){
//        return this.documentRepo.save(document);
//    }

    /**
     *
     * @param filter search-term to filter documents by
     * @return list of documents containing that search-term
     */
    public List<Document> searchDocuments(String filter){
        return this.documentRepo.searchDocuments(filter);
    }

    // Taking this out... DocRepo for explanation
//    public List<Document> getAllDocumentsByUser(int userId){
//        return this.documentRepo.getAllDocumentsByUserId(userId);
//    }
}
