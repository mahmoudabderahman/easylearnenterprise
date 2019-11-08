package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.mapper.AppointmentMapper;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.repository.AppointmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
public class AppointmentService  {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper)
    {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }
    /**
     * Method to create a new appointment
     *
     * @param request used to get the request body
     * @return ResponseEntity<AppointmentRespDTO>
     */
    public ResponseEntity<AppointmentRespDTO> createAppointment(AppointmentReqDTO request)
    {
        log.trace(" *** START OF SAVING APPOINTMENT *** ");
        Appointment appointment = appointmentMapper.mapToEntity(request);
        appointment = appointmentRepository.save(appointment);
        AppointmentRespDTO response = appointmentMapper.mapToDTO(appointment);
        log.trace(" *** END OF SAVING APPOINTMENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /*
    public AppointmentRespDTO findAppointmentById(Long appointmentId)
    {
        log.trace(" *** START OF FINDING APPOINTMENT BY ID *** ");
        //AppointmentRespDTO response = appointmentMapper.mapToDTO()
    }
    */
    /*
    public Page<AppointmentRespDTO> findAllAppointments(Long appointmentId, Pageable pageable)
    {
        log.trace(" *** START OF FINDING ALL APPOINTMENTS *** ");

    }
    */
}
