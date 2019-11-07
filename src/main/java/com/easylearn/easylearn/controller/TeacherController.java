package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherRespDTO> createTeacher(@RequestBody TeacherReqDTO request) {
        return teacherService.createTeacher(request);
    }

    @GetMapping(path = "/{teacherId}")
    public ResponseEntity<TeacherRespDTO> findTeacherById(@PathVariable Long teacherId) {
        return null;
    }

    @GetMapping
    public ResponseEntity<TeacherRespDTO> findAllTeachers() {
        return null;
    }

    @DeleteMapping(path = "/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {

    }
}
