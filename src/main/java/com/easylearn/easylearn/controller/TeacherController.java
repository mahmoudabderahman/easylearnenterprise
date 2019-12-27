package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/teachers")
final class TeacherController {
    final TeacherService teacherService;

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
    public TeacherRespDTO updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherReqDTO request) {
        return teacherService.updateTeacher(teacherId, request);
    }

    @PostMapping(path = "/{teacherId}/courses")
    public TeacherRespDTO assignCoursesToTeacher( @PathVariable Long teacherId, @RequestBody Set<Long> courseIds)
    {
        return teacherService.assignCoursesToTeacher(teacherId, courseIds);
    }

    @DeleteMapping(path = "/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }

}
