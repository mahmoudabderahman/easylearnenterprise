package com.easylearn.easylearn.model;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.entity.Teacher;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class CourseReqDTO {
    private String courseCode;
    private String name;
    private int grade;
    private String content;
    private String description;
    private Teacher teacher;
    private Set<Appointment> appointments;
    private Set<Student> students;
}
