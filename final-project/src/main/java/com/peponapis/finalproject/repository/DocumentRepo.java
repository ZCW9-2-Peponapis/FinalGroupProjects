package com.peponapis.finalproject.repository;

import com.peponapis.finalproject.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepo extends JpaRepository<Document, Integer> {

    // Don't know if this will actually work yet, but the query
    // will look something like this.
    /**
     * @param filter user-inputted search-term to filter documents by
     * @return a list of documents containing the search-term
     */
    @Query("SELECT * FROM Document d WHERE d.title LIKE %?1% OR d.body LIKE %?1%")
    List<Document> searchDocuments(String filter);
}
