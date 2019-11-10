package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentRespDTO> createStudent(@RequestBody StudentReqDTO request)
    {
        return studentService.createStudent(request);
    }

    @GetMapping(path = "/{studentId}")
    public StudentRespDTO findStudentById(@PathVariable Long studentId)
    {
        return studentService.findStudentById(studentId);
    }

    @GetMapping
    public ResponseEntity findAllStudents() {
        return studentService.findAllStudents();
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId)
    {
        return studentService.deleteStudent(studentId);
    }
}
