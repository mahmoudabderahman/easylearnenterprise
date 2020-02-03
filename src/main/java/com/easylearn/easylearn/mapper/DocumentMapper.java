package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Document;
import com.easylearn.easylearn.model.DocumentReqDTO;
import com.easylearn.easylearn.model.DocumentRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Component
@Transactional
public class DocumentMapper implements ObjectMapper<Document, DocumentReqDTO, DocumentRespDTO> {
    @Override
    public Document mapToEntity(DocumentReqDTO request) {
        return Document.builder()
                .uploader(request.getUploader())
                .data(request.getData())
                .nameOfFile(request.getNameOfFile())
                .build();
    }

    @Override
    public Document mapToEntity(Document document, DocumentReqDTO request) {
        document.setUploader(request.getUploader());
        document.setData(request.getData());
        document.setNameOfFile(request.getNameOfFile());
        return document;
    }

    @Override
    public DocumentRespDTO mapToDTO(Document document) {
        return DocumentRespDTO.builder()
                .id(document.getId())
                .uploader(document.getUploader())
                .data(document.getData())
                .nameOfFile(document.getNameOfFile())
                .build();
    }

    @Override
    public Set<DocumentRespDTO> mapToDTOs(Set<Document> documents) {
        if (documents == null || documents.isEmpty())
            return null;

        Set<DocumentRespDTO> documentsItr = new HashSet<>();
        documents.forEach(document -> documentsItr.add(mapToDTO(document)));
        return documentsItr;
    }
}
