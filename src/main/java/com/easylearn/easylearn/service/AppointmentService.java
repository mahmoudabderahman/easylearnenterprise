package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.mapper.AppointmentMapper;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.AppointmentRepository;
import com.easylearn.easylearn.validation.AppointmentValidator;
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
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AppointmentValidator appointmentValidator;
    private final StudentValidator studentValidator;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, AppointmentValidator appointmentValidator, StudentValidator studentValidator) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.appointmentValidator = appointmentValidator;
        this.studentValidator = studentValidator;
    }

    /**
     * Method to create a new appointment
     *
     * @param request used to get the request body
     * @return ResponseEntity<AppointmentRespDTO>
     */
    public ResponseEntity<AppointmentRespDTO> createAppointment(AppointmentReqDTO request) {
        log.info(" *** START OF SAVING APPOINTMENT *** ");
        Appointment appointment = appointmentMapper.mapToEntity(request);
        appointment = appointmentRepository.save(appointment);
        AppointmentRespDTO response = appointmentMapper.mapToDTO(appointment);
        log.info(" *** END OF SAVING APPOINTMENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public AppointmentRespDTO findAppointmentById(Long appointmentId) {
        log.info(" *** START OF FINDING APPOINTMENT BY ID *** ");
        Appointment appointment = appointmentValidator.validateExistence(appointmentId);
        AppointmentRespDTO response = appointmentMapper.mapToDTO(appointment);
        log.info(" *** END OF FINDING APPOINTMENT BY ID *** ");
        return response;
    }

    public ResponseEntity<List<AppointmentRespDTO>> findAllAppointments(Long courseId) {
        log.info(" *** START OF FINDING ALL APPOINTMENTS *** ");
        Set<Appointment> appointments;
        if (courseId != null) {
            appointments = appointmentRepository.findAllByCourseId(courseId, Sort.by( "startDate"));
        }
        else {
            appointments = appointmentRepository.findAllByCourseIdNull(Sort.by( "startDate"));
        }

        if (appointments.isEmpty())
            return ResponseEntity.noContent().build();

        List<AppointmentRespDTO> appointmentsResponse = new ArrayList<>(appointments.size());
        appointments.forEach(appointment -> appointmentsResponse.add(appointmentMapper.mapToDTO(appointment)));
        log.info(" *** END OF FINDING ALL APPOINTMENTS *** ");
        return ResponseEntity.ok(appointmentsResponse);
    }

    public AppointmentRespDTO assignStudentsToAppointment(Long appointmentId, Set<Long> studentIds)
    {
        log.info(" *** START OF ASSIGNING STUDENTS TO APPOINTMENT BY ID *** ");
        Appointment appointment = appointmentValidator.validateExistence(appointmentId);
        Set<Student> students = new HashSet<>();
        studentIds.forEach(studentId -> students.add(studentValidator.validateExistence(studentId)));
        appointment.addStudents(students);
        appointmentRepository.save(appointment);
        AppointmentRespDTO response = appointmentMapper.mapToDTO(appointment);
        log.info(" *** END OF ASSIGNING STUDENTS TO APPOINTMENT BY ID *** ");
        return response;
    }



    public AppointmentRespDTO updateAppointment(Long appointmentId, AppointmentReqDTO request)
    {
        log.info(" *** START OF UPDATING APPOINTMENT BY ID *** ");
        Appointment appointment = appointmentValidator.validateExistence(appointmentId);
        appointment = appointmentMapper.mapToEntity(appointment, request);
        appointmentRepository.save(appointment);
        AppointmentRespDTO response = appointmentMapper.mapToDTO(appointment);
        log.info(" *** END OF UPDATING APPOINTMENT BY ID *** ");
        return response;
    }

    public ResponseEntity deleteAppointment(Long appointmentId)
    {
        log.info(" *** START OF DELETING APPOINTMENT BY ID *** ");
        Appointment appointment = appointmentValidator.validateExistence(appointmentId);
        appointmentRepository.delete(appointment);
        log.info(" *** END OF DELETING APPOINTMENT BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
