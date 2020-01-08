package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.mapper.TeacherMapper;
import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.repository.TeacherRepository;
import com.easylearn.easylearn.validation.CourseValidator;
import com.easylearn.easylearn.validation.TeacherValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
@Transactional
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final TeacherValidator teacherValidator;
    private final CourseValidator courseValidator;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper, TeacherValidator teacherValidator, CourseValidator courseValidator) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.teacherValidator = teacherValidator;
        this.courseValidator = courseValidator;
    }

    public ResponseEntity<TeacherRespDTO> createTeacher(TeacherReqDTO request) {
        log.trace(" *** START OF SAVING TEACHER *** ");
        Teacher teacher = teacherMapper.mapToEntity(request);
        teacher = teacherRepository.save(teacher);
        TeacherRespDTO response = teacherMapper.mapToDTO(teacher);
        log.trace(" *** END OF SAVING TEACHER *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public TeacherRespDTO findTeacherById(Long teacherId) {
        log.info(" *** START OF FINDING TEACHER BY ID *** ");
        Teacher teacher = teacherValidator.validateExistence(teacherId);
        TeacherRespDTO response = teacherMapper.mapToDTO(teacher);
        log.info(" *** END OF FINDING TEACHER BY ID *** ");
        return response;
    }

    public ResponseEntity<List<TeacherRespDTO>> findAllTeachers() {
        log.info(" *** START OF FINDING ALL TEACHERS *** ");
        Set<Teacher> teachers = teacherRepository.findAll(Sort.by("lastName"));
        if (teachers.isEmpty())
            return ResponseEntity.noContent().build();

        List<TeacherRespDTO> teachersResponse = new ArrayList<>(teachers.size());
        teachers.forEach(teacher -> teachersResponse.add(teacherMapper.mapToDTO(teacher)));
        log.info(" *** END OF FINDING ALL TEACHERS *** ");
        return ResponseEntity.ok(teachersResponse);
    }

    public TeacherRespDTO updateTeacher(Long teacherId, TeacherReqDTO request)
    {
        log.info(" *** START OF UPDATING TEACHER BY ID *** ");
        Teacher teacher = teacherValidator.validateExistence(teacherId);
        teacher = teacherMapper.mapToEntity(teacher, request);
        teacherRepository.save(teacher);
        TeacherRespDTO response = teacherMapper.mapToDTO(teacher);
        log.info(" *** END OF UPDATING TEACHER BY ID *** ");
        return response;
    }

    public TeacherRespDTO assignCoursesToTeacher(Long teacherId, Set<Long> courseIds)
    {
        log.info(" *** START OF ASSIGNING TEACHERS TO COURSE BY ID *** ");
        Teacher teacher = teacherValidator.validateExistence(teacherId);
        Set<Course> courses = new HashSet<>();
        courseIds.forEach(courseId -> courses.add(courseValidator.validateExistence(courseId)));
        //Course course = courseValidator.validateExistence(courseId);
        teacher.addCourses(courses);
        teacherRepository.save(teacher);
        TeacherRespDTO response = teacherMapper.mapToDTO(teacher);
        log.info(" *** END OF ASSIGNING TEACHERS TO COURSE BY ID *** ");
        return response;
    }

    public ResponseEntity deleteTeacher(Long teacherId)
    {
        log.info(" *** START OF DELETING TEACHER BY ID *** ");
        Teacher teacher = teacherValidator.validateExistence(teacherId);
        teacherRepository.delete(teacher);
        log.info(" *** END OF DELETING TEACHER BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
