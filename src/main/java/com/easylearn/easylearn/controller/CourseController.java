/**
 * @Author: Mahmoud Abdelrahman
 * Course Controller is a class, where all CRUD methods implemented.
 */
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

    /**
     * Main Constructor
     *
     * @param courseService is an instance from the CourseService class in Services package.
     */
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * createCourse method, which is responsible for creating a new course
     *
     * @param request is the content of the request passed to the POST method.
     * @return the body of the response.
     */
    @PostMapping
    public ResponseEntity<CourseRespDTO> createCourse(@RequestBody CourseReqDTO request) {
        return courseService.createCourse(request);
    }

    /**
     * findCourseById method, which is responsible for getting a course by its id
     *
     * @param courseId is the id of the course, which will be returned back
     * @return the course which was called.
     */
    @GetMapping(path = "/{courseId}")
    public CourseRespDTO findCourseById(@PathVariable Long courseId) {

        return courseService.findCourseById(courseId);
    }

    /**
     * findAllCourses method, which is responsible for getting all courses,
     * response is depending on the parameter which will be passed.
     *
     * @param teacherId by passing it, it will return the courses,
     *                  that this teacher is teaching.
     * @param studentId by passing it, it will return the courses of this
     *                  student.
     * @param parentId  by passing it, it will return the courses of this parents
     *                  students.
     * @param ideal     by passing it, it will return all courses, not looking at their
     *                  relations with other entities.
     * @return list of courses which were gotten from the service instance.
     */
    @GetMapping
    public ResponseEntity findAllCourses(@RequestParam(required = false) Long teacherId, @RequestParam(required = false) Long studentId,
                                         @RequestParam(required = false) Long parentId, Boolean ideal) {
        return courseService.findAllCourses(teacherId, studentId, parentId, ideal);
    }


    /**
     * updateCourse method, which is responsible for updating a specific course
     *
     * @param courseId the id of the course, which will be updated
     * @param request  is the content of the request passed to the PUT method.
     * @return the body of the response.
     */
    @PutMapping(path = "/{courseId}")
    public CourseRespDTO updateCourse(@PathVariable Long courseId, @Valid @RequestBody CourseReqDTO request) {
        return courseService.updateCourse(courseId, request);
    }


    /**
     * assignAppointmentsToCourse method, which is responsible for assigning appointments to a student.
     *
     * @param courseId       the id of the course, to which these appointments will be passed.
     * @param appointmentIds the list of the appointments, which
     *                       will be passed to this course.
     * @return the body of the response.
     */
    @PostMapping(path = "/{courseId}/appointments")
    public CourseRespDTO assignAppointmentsToCourse(@PathVariable Long courseId, @RequestBody Set<Long> appointmentIds) {
        return courseService.assignAppointmentsToCourse(courseId, appointmentIds);
    }

    /**
     * assignStudentsToCourse method, which is responsible for
     * assigning students to a specific appointment course.
     *
     * @param courseId    the id of the course, to which these students will be passed.
     * @param studentsIds the list of students, which will be passed to this course.
     * @return the body of the response.
     */
    @PostMapping(path = "/{courseId}/students")
    public CourseRespDTO assignStudentsToCourse(@PathVariable Long courseId, @RequestBody Set<Long> studentsIds) {
        return courseService.assignStudentsToCourse(courseId, studentsIds);
    }

    /**
     * deleteCourse method, which is responsible for deleting a specific course
     *
     * @param courseId is the id of the course, to be deleted.
     * @return the body of the response.
     */
    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable Long courseId) {
        return courseService.deleteCourse(courseId);
    }
}
