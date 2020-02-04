/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Student Service class is where the code responsible for implementing the student controller methods
 * implemented.
 */
package com.easylearn.easylearn.service;


import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.mapper.StudentMapper;
import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.validation.AppointmentValidator;
import com.easylearn.easylearn.validation.CourseValidator;
import com.easylearn.easylearn.validation.ParentValidator;
import com.easylearn.easylearn.validation.StudentValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentValidator studentValidator;
    private final ParentValidator parentValidator;
    private final AppointmentValidator appointmentValidator;
    private final CourseValidator courseValidator;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, StudentValidator studentValidator, ParentValidator parentValidator, AppointmentValidator appointmentValidator, CourseValidator courseValidator) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.studentValidator = studentValidator;
        this.parentValidator = parentValidator;
        this.appointmentValidator = appointmentValidator;
        this.courseValidator = courseValidator;
    }

    public ResponseEntity<StudentRespDTO> createStudent(StudentReqDTO request) {
        log.trace(" *** START OF SAVING STUDENT *** ");
        Student student = studentMapper.mapToEntity(request);
        student = studentRepository.save(student);
        StudentRespDTO response = studentMapper.mapToDTO(student);
        log.trace(" *** END OF SAVING STUDENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public StudentRespDTO findStudentById(Long studentId) {
        log.info(" *** START OF FINDING STUDENT BY ID *** ");
        Student student = studentValidator.validateExistence(studentId);
        StudentRespDTO response = studentMapper.mapToDTO(student);
        log.info(" *** END OF FINDING STUDENT BY ID *** ");
        return response;
    }

    public ResponseEntity<List<StudentRespDTO>> findAllStudents(Long parentId,
                                                                Long appointmentId,
                                                                Long courseId,
                                                                Boolean parentAllocated,
                                                                Boolean appointmentAllocated,
                                                                Boolean courseAllocated
    ) {
        log.info(" *** START OF FINDING ALL STUDENTS *** ");
        Set<Student> students;
        if (parentId != null && (parentAllocated != null && parentAllocated)) {
            students = studentRepository.findAllByParentId(parentId, Sort.by("lastName"));
        } else if (parentId == null && (parentAllocated != null && !parentAllocated)) {
            students = studentRepository.findAllByParentIdNull(Sort.by("lastName"));
        } else if (appointmentId != null && (appointmentAllocated != null && appointmentAllocated)) {
            students = studentRepository.findAllByAppointmentIdNotNull(appointmentId);
        } else if (appointmentId != null && (appointmentAllocated != null && !appointmentAllocated)) {
            students = studentRepository.findAllStudentsNotInAppointment(appointmentId);
        } else if (courseId != null && (courseAllocated != null && courseAllocated)) {
            students = studentRepository.findAllByCourseIdNotNull(courseId);
        } else if (courseId != null && (courseAllocated != null && !courseAllocated)) {
            students = studentRepository.findAllStudentsNotInCourse(courseId);
        } else {
            students = studentRepository.findAll(Sort.by("lastName"));
        }
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<StudentRespDTO> studentsResponse = new ArrayList<>(students.size());
        students.forEach(student -> {
            studentsResponse.add(studentMapper.mapToDTO(student));
        });
        log.info(" *** END OF FINDING ALL STUDENTS *** ");
        return ResponseEntity.ok(studentsResponse);
    }

    public StudentRespDTO updateStudent(Long studentId, StudentReqDTO request) {
        log.info(" *** START OF UPDATING STUDENT BY ID *** ");
        Student student = studentValidator.validateExistence(studentId);
        student = studentMapper.mapToEntity(student, request);
        studentRepository.save(student);
        StudentRespDTO response = studentMapper.mapToDTO(student);
        log.info(" *** END OF UPDATING STUDENT BY ID *** ");
        return response;
    }

    public ResponseEntity deleteStudent(Long studentId) {
        log.info(" *** START OF DELETING STUDENT BY ID *** ");
        Student student = studentValidator.validateExistence(studentId);
        studentRepository.delete(student);
        log.info(" *** END OF DELETING STUDENT BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
