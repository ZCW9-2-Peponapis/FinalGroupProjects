package com.peponapis.finalproject.serviceTests;

import com.peponapis.finalproject.dtos.DocumentDTO;
import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.model.UserEntity;
import com.peponapis.finalproject.repository.DocumentRepo;
import com.peponapis.finalproject.repository.UserRepo;
import com.peponapis.finalproject.security.AuthenticationFacade;
import com.peponapis.finalproject.service.DocumentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceTests {
    @Mock
    DocumentRepo documentRepo;
    @Mock
    AuthenticationFacade authenticationFacade;

    @Mock
    UserRepo userRepo;

    private DocumentService documentService;

    @BeforeEach
    public void setUp(){
        this.documentService = new DocumentService(this.documentRepo, authenticationFacade, this.userRepo);
    }

    @Test
    public void testDocumentServiceConstructor(){
        Assertions.assertThat(this.documentService).isNotNull();
    }

    @Test
    public void testDocumentServiceSaveDocument(){
        // given
        Document documentToSave = Mockito.mock(Document.class);
        UserEntity user = Mockito.mock(UserEntity.class);
        DocumentDTO dto = Mockito.mock(DocumentDTO.class);

        // when
        when(this.documentRepo.save(documentToSave)).thenReturn(documentToSave);
        Mockito.mockConstruction(DocumentDTO.class, (mock, context) -> {});

        // assert
        Assertions.assertThat(this.documentService.updateDocument(documentToSave)).isNotNull();
    }

    @Test
    public void testDocumentServiceGetAllDocuments(){
        // given
        List<Document> documentList = Mockito.mock();

        // when
        when(this.documentRepo.findAll()).thenReturn(documentList);

        // asssert
        Assertions.assertThat(this.documentService.getAllDocuments()).isEqualTo(documentList);

    }

    @Test
    public void testDocumentServiceGetDocument(){
        // given
        Document document = Mockito.mock(Document.class);

        // when
        when(this.documentRepo.findById(1)).thenReturn(Optional.ofNullable(document));

        // assert
        Assertions.assertThat(this.documentService.getDocument(1)).isEqualTo(document);
    }

    @Test
    public void testDocumentServiceGetDocumentNull(){
        // when
        when(this.documentRepo.findById(123)).thenReturn(Optional.empty());

        // assert
        Assertions.assertThat(this.documentService.getDocument(123)).isNull();
    }

    @Test
    public void testDocumentServiceSearchDocuments(){
        // given
        List<Document> list = Mockito.mock();
        String filter = Mockito.anyString();

        // when
        when(this.documentRepo.searchDocuments(filter)).thenReturn(list);

        // assert
        Assertions.assertThat(this.documentService.searchDocuments(filter)).isEqualTo(list);
    }

//    @Test
//    public void testDocumentServiceGetAllByUser(){
//        // given
//        List<Document> list = Mockito.mock();
//        int userId = 1;
//
//        // when
//        when(this.documentRepo.getAllDocumentsByUserId(userId)).thenReturn(list);
//
//        // assert
//        Assertions.assertThat(this.documentService.getAllDocumentsByUser(userId)).isEqualTo(list);
//    }

}
