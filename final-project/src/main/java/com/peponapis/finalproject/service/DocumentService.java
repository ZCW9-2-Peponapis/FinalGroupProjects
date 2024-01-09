package com.peponapis.finalproject.service;

import com.peponapis.finalproject.dtos.DocumentDTO;
import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.UserEntity;
import com.peponapis.finalproject.repository.DocumentRepo;
import com.peponapis.finalproject.repository.UserRepo;
import com.peponapis.finalproject.security.AuthenticationFacade;
import com.peponapis.finalproject.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Document service. Operations relating to Document are found here.
 */
@Service
public class DocumentService {
    DocumentRepo documentRepo;
    UserRepo userRepo;
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    public DocumentService(DocumentRepo documentRepo, AuthenticationFacade authenticationFacade, UserRepo userRepo){
        this.documentRepo = documentRepo;
        this.authenticationFacade = authenticationFacade;
        this.userRepo = userRepo;
    }

    /**
     *
     * @param document document to create
     * @return DTO of the new document
     */
    public DocumentDTO createDocument(Document document){
        Authentication authentication = authenticationFacade.getAuthentication();
        //LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getDetails();
        User user = (User) authentication.getPrincipal();

        UserEntity docAuthor = userRepo.findByUserName(user.getUsername()).get();
        this.documentRepo.save(document);
        docAuthor.addDocument(document);
        document.setUser(docAuthor);
        this.userRepo.save(docAuthor);

        DocumentDTO doc = new DocumentDTO();
        doc.setAuthor(document.getUser().getName());
        doc.setTitle(document.getTitle());
        doc.setBody(document.getBody());
        doc.setCreationDate(document.getCreationDate());
        doc.setModificationDate(document.getModificationDate());

        return doc;
    }

    /**
     *
     * @param document document to be updated
     * @return DTO of the updated document
     */
    public DocumentDTO updateDocument(Document document){
        return new DocumentDTO(this.documentRepo.save(document));
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
