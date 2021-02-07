/**
 * @Author: Mahmoud Abdelrahman
 * Result Controller is a class, where creating and getting results of course, student
 * is implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.entity.Result;
import com.easylearn.easylearn.repository.DocumentRepository;
import com.easylearn.easylearn.repository.ResultRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/results")
public class ResultController {

    private final ResultRepository resultRepository;

    /**
     * Main Constructor
     *
     * @param resultRepository is an instance from the ResultRepository class in Repository package.
     */
    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    /**
     * assignResultToStudent method, which is responsible for assigning result to a student
     *
     * @param resultReq is the body of the result request.
     * @return the body of the response.
     */
    @PostMapping(value = "assignResultToStudent")
    public ResponseEntity assignResultToStudent(@RequestBody Result resultReq) {
        Result result = new Result();
        result.setCourseId(resultReq.getCourseId());
        result.setStudentId(resultReq.getStudentId());
        result.setPoints(resultReq.getPoints());
        result.setMaxValue(resultReq.getMaxValue());
        return ResponseEntity.ok(resultRepository.save(result));
    }

    /**
     * getResultsOfStudentInCourse method, which is responsible for getting a
     * result of a student in a specific course.
     *
     * @param studentId is the student, to which the result will be passed.
     * @param courseId  is the course, to which the result will be passed.
     * @return the body of the response.
     */
    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity getResultsOfStudentInCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        Result result = resultRepository.findByCourseIdAndStudentId(courseId, studentId);
        if (result == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(result);
    }
}
