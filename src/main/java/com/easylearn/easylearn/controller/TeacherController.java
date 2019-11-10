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
    public TeacherRespDTO findTeacherById(@PathVariable Long teacherId) {
        return teacherService.findTeacherById(teacherId);
    }

    @GetMapping
    public ResponseEntity findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @DeleteMapping(path = "/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }
}
