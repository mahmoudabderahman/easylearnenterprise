package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Document;
import com.easylearn.easylearn.repository.DocumentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DocumentValidator extends BaseValidator<Document> {

    private DocumentRepository documentRepository;

    @Autowired
    public DocumentValidator(DocumentRepository documentRepository) {
        super(Document.class);
        this.documentRepository = documentRepository;
    }
}
