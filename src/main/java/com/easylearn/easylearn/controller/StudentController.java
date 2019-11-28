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
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping(path = "create")
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

    /**
     * API to update a specific workout
     *
     * @param studentId used to get the studentId
     * @param request   used to get the request body
     * @return StudentRespDTO
     */
    @PutMapping(path = "update/{studentId}")
    public StudentRespDTO updateStudent(@PathVariable Long studentId, @Valid @RequestBody StudentReqDTO request) {
        return studentService.updateStudent(studentId, request);
    }

    @PutMapping(path = "update/{studentId}/parents/{parentId}")
    public StudentRespDTO assignStudentToParent( @PathVariable Long studentId, @PathVariable Long parentId)
    {
        return studentService.assignStudentToParent(studentId, parentId);
    }

    @PutMapping(path = "update/{studentId}/appointments/{appointmentId}")
    public StudentRespDTO assignStudentToAppointment( @PathVariable Long studentId, @PathVariable Long appointmentId)
    {
        return studentService.assignStudentToAppointment(studentId, appointmentId);
    }

    @PutMapping(path = "update/{studentId}/courses/{courseCode}")
    public StudentRespDTO assignStudentToCourse( @PathVariable Long studentId, @PathVariable String courseCode)
    {
        return studentService.assignStudentToCourse(studentId, courseCode);
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId)
    {
        return studentService.deleteStudent(studentId);
    }
}
