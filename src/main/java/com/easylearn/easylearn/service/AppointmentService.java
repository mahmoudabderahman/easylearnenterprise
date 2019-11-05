package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository)
    {
        this.appointmentRepository = appointmentRepository;
    }

    public ResponseEntity<AppointmentRespDTO> createAppointment(AppointmentReqDTO request)
    {
        Appointment appointment = Appointment.builder()
                .startDate(request.getStartDate())
                .endDate(request.getStartDate())
                .roomNumber(request.getRoomNumber())
                .build();

        appointment = appointmentRepository.save(appointment);

        AppointmentRespDTO response = AppointmentRespDTO.builder()
                .id(appointment.getId())
                .startDate(appointment.getStartDate())
                .endDate(appointment.getEndDate())
                .roomNumber(appointment.getRoomNumber())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
