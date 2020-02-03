package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Document;
import com.easylearn.easylearn.mapper.DocumentMapper;

import com.easylearn.easylearn.model.DocumentReqDTO;
import com.easylearn.easylearn.model.DocumentRespDTO;
import com.easylearn.easylearn.repository.DocumentRepository;
import com.easylearn.easylearn.validation.StudentValidator;
import com.easylearn.easylearn.validation.TeacherValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final StudentValidator studentValidator;
    private final TeacherValidator teacherValidator;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, DocumentMapper documentMapper, StudentValidator studentValidator, TeacherValidator teacherValidator) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;

        this.studentValidator = studentValidator;
        this.teacherValidator = teacherValidator;
    }

    public ResponseEntity<DocumentRespDTO> createDocument(DocumentReqDTO request) {
        log.info(" *** START OF SAVING DOCUMENT *** ");
        Document document = documentMapper.mapToEntity(request);
        document = documentRepository.save(document);
        DocumentRespDTO response = documentMapper.mapToDTO(document);
        log.info(" *** END OF SAVING DOCUMENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
