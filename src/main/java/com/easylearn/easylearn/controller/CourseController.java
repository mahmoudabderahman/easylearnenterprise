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

    @GetMapping(path = "/{courseId}")
    public CourseRespDTO findCourseById(@PathVariable Long courseId) {

        return courseService.findCourseById(courseId);
    }

    @GetMapping
    public ResponseEntity findAllCourses() {
        return courseService.findAllCourses();
    }


    /**
     * API to update a specific workout
     *
     * @param courseId to get the courseCode
     * @param request   used to get the request body
     * @return CourseRespDTO
     */
    @PutMapping(path = "/{courseId}")
    public CourseRespDTO updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseReqDTO request) {
        return courseService.updateCourse(courseId, request);
    }

    @PutMapping(path = "/{courseId}/appointments/{appointmentId}")
    public CourseRespDTO assignCourseToAppointment( @PathVariable Long courseId, @PathVariable Long appointmentId)
    {
        return courseService.assignCourseToAppointment(courseId, appointmentId);
    }

    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable Long courseId) {
        return courseService.deleteCourse(courseId);
    }
}
