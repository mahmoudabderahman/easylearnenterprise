package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/students")
final class StudentController {
    private StudentService studentService;

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
    public ResponseEntity findAllStudents(@RequestParam(required = false) Long parentId) {
        return studentService.findAllStudents(parentId);
    }

    /**
     * API to update a specific workout
     *
     * @param studentId used to get the studentId
     * @param request   used to get the request body
     * @return StudentRespDTO
     */
    @PutMapping(path = "/{studentId}")
    public StudentRespDTO updateStudent(@PathVariable Long studentId, @Valid @RequestBody StudentReqDTO request) {
        return studentService.updateStudent(studentId, request);
    }







    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId)
    {
        return studentService.deleteStudent(studentId);
    }
}
