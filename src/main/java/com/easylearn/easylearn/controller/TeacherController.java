package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /**
     * API to update a specific workout
     *
     * @param teacherId used to get the teacherId
     * @param request   used to get the request body
     * @return TeacherRespDTO
     */
    @PutMapping(path = "/{teacherId}")
    public TeacherRespDTO updateTeacher(@PathVariable Long teacherId, @Valid @RequestBody TeacherReqDTO request) {
        return teacherService.updateTeacher(teacherId, request);
    }


    @PutMapping(path = "/{courseCode}/{teacherId}")
    public TeacherRespDTO assignTeacherToCourse( @PathVariable Long teacherId, @PathVariable String courseCode)
    {
        return teacherService.assignTeacherToCourse(teacherId, courseCode);
    }
    @DeleteMapping(path = "/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }
}
