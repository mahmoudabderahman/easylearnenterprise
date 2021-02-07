/**
 * @Author: Mahmoud Abdelrahman
 * Course Response Data Transfer Object is where the specifications required for responses declared.
 */
package com.easylearn.easylearn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class CourseRespDTO {
    private Long id;
    private String courseCode;
    private String name;
    private int grade;
    private String content;
    private String description;
}
