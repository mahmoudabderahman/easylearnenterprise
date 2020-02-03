package com.easylearn.easylearn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class DocumentRespDTO {
    private long id;
    private String nameOfFile;
    private byte[] data;
    private String uploader;
}
