/**
 * @Author: Mahmoud Abdelrahman
 * Teacher Controller is a class, where all CRUD methods implemented.
 */
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

    /**
     * Main Constructor
     *
     * @param teacherService is an instance from the TeacherService class in Services package.
     */
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * createTeacher method, which is responsible for creating a new teacher
     *
     * @param request is the content of the request passed to the POST method.
     * @return the body of the response.
     */
    @PostMapping
    public ResponseEntity<TeacherRespDTO> createTeacher(@RequestBody TeacherReqDTO request) {
        return teacherService.createTeacher(request);
    }


    /**
     * findTeacherById method, which is responsible for getting a teacher by its id
     *
     * @param teacherId is the id of the teacher, which will be returned back
     * @return the teacher which was called.
     */
    @GetMapping(path = "/{teacherId}")
    public TeacherRespDTO findTeacherById(@PathVariable Long teacherId) {
        return teacherService.findTeacherById(teacherId);
    }

    /**
     * findAllTeachers method, which is responsible for getting all teachers,
     *
     * @return list of teachers which were gotten from the service instance.
     */
    @GetMapping
    public ResponseEntity findAllTeachers() {
        return teacherService.findAllTeachers();
    }


    /**
     * API to update a specific teacher
     *
     * @param teacherId used to get the teacher
     * @param request   used to get the request body
     * @return the body of the response.
     */
    @PutMapping(path = "/{teacherId}")
    public TeacherRespDTO updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherReqDTO request) {
        return teacherService.updateTeacher(teacherId, request);
    }

    /**
     * assignCoursesToTeacher method, which is responsible for assigning courses to a teacher.
     *
     * @param teacherId used to get the teacher
     * @param courseIds are the ids of the courses, that will be assigned to this teacher
     * @return the body of the response.
     */
    @PostMapping(path = "/{teacherId}/courses")
    public TeacherRespDTO assignCoursesToTeacher(@PathVariable Long teacherId, @RequestBody Set<Long> courseIds) {
        return teacherService.assignCoursesToTeacher(teacherId, courseIds);
    }

    /**
     * deleteTeacher method, which is responsible for deleting a specific teacher
     *
     * @param teacherId used to get the teacher
     * @return the body of the response.
     */
    @DeleteMapping(path = "/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }

}
