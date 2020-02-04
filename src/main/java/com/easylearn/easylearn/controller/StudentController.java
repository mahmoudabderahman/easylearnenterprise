/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Student Controller is a class, where all CRUD methods implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/students")
final class StudentController {
    private StudentService studentService;

    /**
     * Main Constructor
     *
     * @param studentService is an instance from the StudentService class in Services package.
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * createStudent method, which is responsible for creating a new student
     *
     * @param request is the content of the request passed to the POST method.
     * @return the body of the response.
     */
    @PostMapping
    public ResponseEntity<StudentRespDTO> createStudent(@RequestBody StudentReqDTO request) {
        return studentService.createStudent(request);
    }

    /**
     * findCourseById method, which is responsible for getting a student by its id
     *
     * @param studentId is the id of the student, which will be returned back
     * @return the student which was called.
     */
    @GetMapping(path = "/{studentId}")
    public StudentRespDTO findStudentById(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId);
    }

    /**
     * findAllStudents method, which is responsible for getting all students,
     * response is depending on the parameter which will be passed.
     *
     * @param parentId              by passing it, it will return the students,
     *                              to which this parent is allocated.
     * @param appointmentId         by passing it, it will return all students,
     *                              to which this appointment is allocated.
     * @param courseId              by passing it, it will return all students,
     *                              to which course is allocated.
     * @param appointmentsAllocated to decide, if it is about getting allocatedAppointments or not
     *                              allocated ones.
     * @param parentAllocated       to decide, if it is about getting allocatedParents or not allocated
     *                              ones.
     * @param courseAllocated       to decide, if it is about getting allocatedCourses or not allocated
     *                              ones.
     * @return list of students which were gotten from the service instance.
     */

    @GetMapping
    public ResponseEntity findAllStudents(@RequestParam(required = false) Long parentId,
                                          @RequestParam(required = false) Long appointmentId,
                                          @RequestParam(required = false) Long courseId,
                                          @RequestParam(required = false) Boolean parentAllocated,
                                          @RequestParam(required = false) Boolean appointmentsAllocated,
                                          @RequestParam(required = false) Boolean courseAllocated) {
        return studentService.findAllStudents(parentId, appointmentId, courseId, parentAllocated, appointmentsAllocated, courseAllocated);
    }

    /**
     * API to update a specific student
     *
     * @param studentId used to get the studentId
     * @param request   used to get the request body
     * @return the body of the response.
     */
    @PutMapping(path = "/{studentId}")
    public StudentRespDTO updateStudent(@PathVariable Long studentId, @Valid @RequestBody StudentReqDTO request) {
        return studentService.updateStudent(studentId, request);
    }

    /**
     * deleteStudent method, which is responsible for deleting a specific student
     *
     * @param studentId the id of the student, which will be deleted.
     * @return the body of the response.
     */
    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }
}
