package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.DocumentReqDTO;
import com.easylearn.easylearn.model.DocumentRespDTO;
import com.easylearn.easylearn.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping(path = "/api/v1/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PostMapping
    public ResponseEntity<DocumentRespDTO> saveDocument(@RequestBody DocumentReqDTO request)  {
        return documentService.createDocument(request);
    }
}
