package com.easylearn.easylearn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class DocumentReqDTO {
    private String nameOfFile;
    private byte[] data;
    private String uploader;
}
