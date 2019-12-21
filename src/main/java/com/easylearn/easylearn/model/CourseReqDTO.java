package com.easylearn.easylearn.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class CourseReqDTO {
    private String courseCode;
    private String name;
    private int grade;
    private String content;
    private String description;
}
