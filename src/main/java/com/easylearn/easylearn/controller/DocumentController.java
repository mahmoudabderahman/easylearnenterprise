/**
 * @Author: Mahmoud Abdelrahman
 * Document Controller is a class, in which upload and download file code
 * is implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.entity.Document;
import com.easylearn.easylearn.repository.DocumentRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/v1/documents")
public class DocumentController {

    private final DocumentRepository documentRepository;

    /**
     * Main Constructor
     *
     * @param documentRepository is an instance from the DocumentRepository class in Repositories package.
     */
    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * uploadFileToCourse method, which is responsible for uploading a file to
     * database, related to one course.
     *
     * @param file     file to be uploaded
     * @param courseId course, to which the file will be assigned
     * @return the body of the response.
     */
    @PostMapping(value = "uploadFileToCourse")
    public ResponseEntity uploadFileToCourse(@RequestParam("file") MultipartFile file, @RequestParam("courseId") Long courseId) {
        Document document = new Document();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        document.setNameOfFile(fileName);
        try {
            document.setData(file.getBytes());
            document.setCourseId(courseId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).path("/db")
                .toUriString();
        System.out.println(fileDownloadUri);
        document.setDownloadLink(fileDownloadUri);
        return ResponseEntity.ok(documentRepository.save(document));

    }

    /**
     * downloadFromDB method, which is responsible for downloading a file from
     * a database.
     *
     * @param fileName name of the file to be returned
     * @return the body of the response.
     */
    @GetMapping("/download/{file}/db")
    public ResponseEntity downloadFromDB(@PathVariable("file") String fileName) {
        Document document = documentRepository.findByNameOfFile(fileName);
        System.out.println(document.getNameOfFile());
        String contentType = "application/pdf";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(document.getData());
    }


    /**
     * findAllFiles method, which is responsible for getting all files related
     * to a course
     *
     * @param courseId
     * @return the body of the response.
     */
    @GetMapping("/{courseId}")
    public ResponseEntity findAllFiles(@PathVariable Long courseId) {
        Set<Document> documents = documentRepository.findAllByCourseId(courseId);
        if (documents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<Document> documentsResponse = new ArrayList<>(documents.size());
        documentsResponse.addAll(documents);

        return ResponseEntity.ok(documentsResponse);
    }

}
