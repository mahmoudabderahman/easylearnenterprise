package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.mapper.CourseMapper;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public ResponseEntity<CourseRespDTO> createCourse(CourseReqDTO request) {
        log.trace(" *** START OF SAVING COURSE *** ");
        Course course = courseMapper.mapToEntity(request);
        course = courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.trace(" *** END OF SAVING COURSE *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
