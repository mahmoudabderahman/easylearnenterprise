package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/courses")
final class CourseController {
    private final CourseService courseService;

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
    public ResponseEntity findAllCourses(@RequestParam(required = false) Long teacherId, @RequestParam(required = false) Long studentId,
                                         @RequestParam(required = false) Long parentId, Boolean ideal) {
        return courseService.findAllCourses(teacherId, studentId, parentId, ideal);
    }


    /**
     * API to update a specific workout
     *
     * @param courseId to get the courseCode
     * @param request  used to get the request body
     * @return CourseRespDTO
     */
    @PutMapping(path = "/{courseId}")
    public CourseRespDTO updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseReqDTO request) {
        return courseService.updateCourse(courseId, request);
    }

    @PostMapping(path = "/{courseId}/appointments")
    public CourseRespDTO assignAppointmentsToCourse(@PathVariable Long courseId, @RequestBody Set<Long> appointmentIds) {
        return courseService.assignAppointmentsToCourse(courseId, appointmentIds);
    }

    @PostMapping(path = "/{courseId}/students")
    public CourseRespDTO assignStudentsToCourse(@PathVariable Long courseId, @RequestBody Set<Long> studentsIds) {
        return courseService.assignStudentsToCourse(courseId, studentsIds);
    }

    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable Long courseId) {
        return courseService.deleteCourse(courseId);
    }
}
