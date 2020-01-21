package com.easylearn.easylearn.controller;


import com.easylearn.easylearn.service.ParentService;
import com.easylearn.easylearn.service.StudentService;
import com.easylearn.easylearn.service.TeacherService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private TeacherService teacherService;
    private StudentService studentService;
    private ParentService parentService;

    private List users;

    public UserController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;

    }

    public UserController() {

    }


    @GetMapping
    public List<ResponseEntity> findAllUsers() {
        users = new ArrayList();
        users.addAll(teacherService.findAllTeachers().getBody());
        users.addAll(parentService.findAllParents().getBody());
        users.addAll(studentService.findAllStudents(null, null, null, null, null, null).getBody());
        return users;
    }

    public List getUsers() {
        return this.users;
    }
}
