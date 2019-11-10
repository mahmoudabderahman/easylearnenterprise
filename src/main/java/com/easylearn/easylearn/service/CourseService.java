package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.mapper.CourseMapper;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.repository.CourseRepository;
import com.easylearn.easylearn.validation.CourseValidator;
import jdk.internal.jline.internal.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseValidator courseValidator;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper, CourseValidator courseValidator) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.courseValidator = courseValidator;
    }

    public ResponseEntity<CourseRespDTO> createCourse(String courseCode, CourseReqDTO request) {
        log.info(" *** START OF SAVING COURSE *** ");
        Course course = courseValidator.validateExistence(courseCode);
        course = courseMapper.mapToEntity(request);
        course = courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF SAVING COURSE *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public CourseRespDTO findCourseById(String courseCode)
    {
        Log.info(" *** START OF FINDING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseCode);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        Log.info(" *** END OF FINDING COURSE BY ID *** ");
        return response;
    }

    public ResponseEntity<Set<CourseRespDTO>> findAllCourses(){
        log.info(" *** START OF FINDING ALL COURSES *** ");
        Set<Course> courses = courseRepository.findAll();
        if(courses.isEmpty())
            return ResponseEntity.noContent().build();

        Set<CourseRespDTO> coursesResponse = new HashSet<>(courses.size());
        courses.forEach(course -> coursesResponse.add(courseMapper.mapToDTO(course)));
        return ResponseEntity.ok(coursesResponse);

    }

    public CourseRespDTO updateCourse(String courseCode, CourseReqDTO request) {
        Log.info(" *** START OF UPDATING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseCode);
        course = courseMapper.mapToEntity(course, request);
        courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        Log.info(" *** END OF UPDATING COURSE BY ID *** ");
        return response;
    }

    public ResponseEntity deleteCourse(String courseCode)
    {
        Log.info(" *** START OF DELETING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseCode);
        courseRepository.delete(course);
        Log.info(" *** END OF DELETING COURSE BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
