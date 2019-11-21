package com.easylearn.easylearn.controller;


import com.easylearn.easylearn.service.ParentService;
import com.easylearn.easylearn.service.StudentService;
import com.easylearn.easylearn.service.TeacherService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    private  Set users;

    public UserController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;

    }


    @GetMapping
    public Set<ResponseEntity> findAllUsers() {
        users = new HashSet<>();
        users.addAll(teacherService.findAllTeachers().getBody());
        users.addAll(parentService.findAllParents().getBody());
        users.addAll(studentService.findAllStudents().getBody());
        return users;
    }
}
