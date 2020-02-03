package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.entity.Document;
import com.easylearn.easylearn.model.DocumentRespDTO;
import com.easylearn.easylearn.model.Response;
import com.easylearn.easylearn.repository.DocumentRepository;
import com.easylearn.easylearn.service.DocumentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(path = "/api/v1/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentRepository documentRepository;

    public DocumentController(DocumentService documentService, DocumentRepository documentRepository) {
        this.documentService = documentService;
        this.documentRepository = documentRepository;
    }


    @PostMapping
    public ResponseEntity<Response> saveDocument(@RequestParam("file") MultipartFile file, @RequestParam("username") String username, @RequestParam("courseId") Long courseId) throws IOException {
        Document document = new ObjectMapper().readValue(username, Document.class);
        document.setData(file.getBytes());
        document.setNameOfFile(file.getOriginalFilename());
        document.setUploader(username);
        document.setCourseId(courseId);
        Document savedDocument = documentRepository.save(document);
        if (savedDocument!=null) {
            return new ResponseEntity<Response>(new Response("Document is saved"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Response>(new Response("Document could not be saved"), HttpStatus.BAD_REQUEST);

        }
    }
}
