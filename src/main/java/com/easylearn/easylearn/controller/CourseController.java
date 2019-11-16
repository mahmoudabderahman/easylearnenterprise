package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/courses")
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

    @GetMapping(path = "/{courseCode}")
    public CourseRespDTO findCourseById(@PathVariable String courseCode) {

        return courseService.findCourseById(courseCode);
    }

    @GetMapping
    public ResponseEntity findAllCourses() {
        return courseService.findAllCourses();
    }


    /**
     * API to update a specific workout
     *
     * @param courseCode used to get the courseCode
     * @param request   used to get the request body
     * @return CourseRespDTO
     */
    @PutMapping(path = "/{courseCode}")
    public CourseRespDTO updateCourse(@PathVariable String courseCode, @Valid @RequestBody CourseReqDTO request) {
        return courseService.updateCourse(courseCode, request);
    }

    @PutMapping(path = "/{courseCode}/appointments/{appointmentId}")
    public CourseRespDTO assignCourseToAppointment( @PathVariable String courseCode, @PathVariable Long appointmentId)
    {
        return courseService.assignCourseToAppointment(courseCode, appointmentId);
    }

    @DeleteMapping(path = "/{courseCode}")
    public ResponseEntity deleteCourse(@PathVariable String courseCode) {
        return courseService.deleteCourse(courseCode);
    }
}
