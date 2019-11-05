package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/courses/")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseRespDTO> createCourse(@RequestBody CourseReqDTO request) {
        return courseService.createCourse(request);
    }

    @GetMapping(path = "/{couseCode}")
    public ResponseEntity<CourseRespDTO> findCourseById(@PathVariable String courseCode) {
        return null;
    }

    @GetMapping
    public ResponseEntity<CourseRespDTO> findAllCourses() {
        return null;
    }

    @DeleteMapping(path = "/{courseCode}")
    public void deleteCourse(@PathVariable String courseCode) {

    }
}
