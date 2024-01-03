package com.peponapis.finalproject.repository;

import com.peponapis.finalproject.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, Integer> {
}
