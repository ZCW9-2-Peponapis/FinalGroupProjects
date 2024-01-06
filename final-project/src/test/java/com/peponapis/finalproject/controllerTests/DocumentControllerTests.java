package com.peponapis.finalproject.controllerTests;

import com.peponapis.finalproject.controller.DocumentController;
import com.peponapis.finalproject.model.Document;
import com.peponapis.finalproject.service.DocumentService;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.Doc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DocumentController.class)
public class DocumentControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DocumentService documentService;

    DocumentController documentController;

    @BeforeEach
    public void setUp(){
        this.documentController = new DocumentController(this.documentService);
    }

    @Test
    public void testDocumentControllerConstructor(){
        Assertions.assertThat(this.documentController).isNotNull();
    }

    @Test
    public void testDocumentControllerViewAllDocuments() throws Exception {
        // given
        List<Document> documentList = Arrays.asList(new Document("Test1", "Body1", 123), new Document("Test2", "Body2", 321));

        // when
        when(this.documentService.getAllDocuments()).thenReturn(documentList);

        // assert
        this.mockMvc.perform(get("/document/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testDocumentControllerViewDocument() throws Exception {
        // given
        int id = 2;
        Document document = new Document("Title1", "Body1", 123);

        // when
        when(this.documentService.getDocument(id)).thenReturn(document);

        // assert
        this.mockMvc.perform(get("/document/view/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testDocumentControllerSaveDocument() throws Exception {
        // given
        Document document = new Document("Title1", "Body1", 123);
        String requestBody = "{\"id\":1, \"title\":\"Title1\", \"body\":\"Body1\", \"userId\":123}";
        // when
        when(this.documentService.saveDocument(document)).thenReturn(document);

        // assert
        this.mockMvc.perform(patch("/document/update")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk());

    }

    @Test
    public void testDocumentControllerCreateDocument() throws Exception {
        // given
        Document document = new Document("Title1", "Body1", 123);
        String requestBody = "{\"id\":1, \"title\":\"Title1\", \"body\":\"Body1\", \"userId\":123}";
        // when
        when(this.documentService.saveDocument(document)).thenReturn(document);

        // assert
        this.mockMvc.perform(patch("/document/update")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testDocumentControllerSearchDocument() throws Exception {
        // given
        List<Document> documentList = Arrays.asList(new Document("Test1", "Body1", 123), new Document("Test2", "Body2", 321));
        String filter = "test";

        //when
        when(this.documentService.searchDocuments(filter)).thenReturn(documentList);

        // assert
        this.mockMvc.perform(get("/document/search")
                        .param("filter", filter)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

//    @Test
//    public void testDocumentControllerGetAllByUser() throws Exception {
//        // given
//        List<Document> documentList = Arrays.asList(new Document("Test1", "Body1", 123), new Document("Test2", "Body2", 123));
//        int userId = 123;
//
//        // when
//        when(this.documentService.getAllDocumentsByUser(userId)).thenReturn(documentList);
//
//        // assert
//        this.mockMvc.perform(get("/document/allByUser")
//                .param("userId", String.valueOf(userId)))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//    }

}
