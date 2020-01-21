package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.mapper.CourseMapper;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.CourseRepository;
import com.easylearn.easylearn.validation.AppointmentValidator;
import com.easylearn.easylearn.validation.CourseValidator;
import com.easylearn.easylearn.validation.StudentValidator;
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
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseValidator courseValidator;
    private final AppointmentValidator appointmentValidator;
    private final StudentValidator studentValidator;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper, CourseValidator courseValidator, AppointmentValidator appointmentValidator, StudentValidator studentValidator) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.courseValidator = courseValidator;
        this.appointmentValidator = appointmentValidator;
        this.studentValidator = studentValidator;
    }

    public ResponseEntity<CourseRespDTO> createCourse(CourseReqDTO request) {
        log.info(" *** START OF SAVING COURSE *** ");
        Course course = courseMapper.mapToEntity(request);
        course = courseMapper.mapToEntity(request);
        course = courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF SAVING COURSE *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public CourseRespDTO findCourseById(Long courseId)
    {
        log.info(" *** START OF FINDING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseId);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF FINDING COURSE BY ID *** ");
        return response;
    }

    public ResponseEntity<List<CourseRespDTO>> findAllCourses(Long teacherId, Boolean ideal){
        log.info(" *** START OF FINDING ALL COURSES *** ");
        Set<Course> courses;// = courseRepository.findAll(Sort.by("courseCode"));
        if (teacherId != null) {
            courses = courseRepository.findAllByTeacherId(teacherId, Sort.by("courseCode"));
        }
        else if (ideal != null && ideal) {

            courses = courseRepository.findAllByTeacherIdNull(Sort.by("courseCode"));
        }
        else {
            courses = courseRepository.findAll(Sort.by("courseCode"));
        }
        if(courses.isEmpty())
            return ResponseEntity.noContent().build();

        List<CourseRespDTO> coursesResponse = new ArrayList<>(courses.size());
        courses.forEach(course -> coursesResponse.add(courseMapper.mapToDTO(course)));
        return ResponseEntity.ok(coursesResponse);

    }

    public CourseRespDTO updateCourse(Long courseId, CourseReqDTO request) {
        log.info(" *** START OF UPDATING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseId);
        course = courseMapper.mapToEntity(course, request);
        courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF UPDATING COURSE BY ID *** ");
        return response;
    }

    public CourseRespDTO assignAppointmentsToCourse(Long courseId, Set<Long> appointmentIds) {
        log.info(" *** START OF ASSIGNING COURSE TO APPOINTMENT BY ID *** ");
        Set<Appointment> appointments = new HashSet<>();
        Course course = courseValidator.validateExistence(courseId);
        appointmentIds.forEach(appointmentId -> appointments.add(appointmentValidator.validateExistence(appointmentId)));
        course.addAppointments(appointments);
        /*
        for (Appointment appointment: appointments) {
            Appointment app = appointmentValidator.validateExistence(appointment);
            app.setCourse(course);
        }
        */
        //appointment.setCourse(course);
        courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF ASSIGNING COURSE TO APPOINTMENT BY ID *** ");
        return response;
    }

    public CourseRespDTO assignStudentsToCourse(Long courseId, Set<Long> studentIds)
    {
        log.info(" *** START OF ASSIGNING STUDENTS TO COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseId);
        Set<Student> students = new HashSet<>();
        studentIds.forEach(studentId -> students.add(studentValidator.validateExistence(studentId)));
        course.addStudents(students);
        courseRepository.save(course);
        CourseRespDTO response = courseMapper.mapToDTO(course);
        log.info(" *** END OF ASSIGNING STUDENTS TO COURSE BY ID *** ");
        return response;
    }

    public ResponseEntity deleteCourse(Long courseId)
    {
        log.info(" *** START OF DELETING COURSE BY ID *** ");
        Course course = courseValidator.validateExistence(courseId);
        courseRepository.delete(course);
        log.info(" *** END OF DELETING COURSE BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
