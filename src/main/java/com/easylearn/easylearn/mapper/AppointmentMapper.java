package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class AppointmentMapper implements ObjectMapper<Appointment, AppointmentReqDTO, AppointmentRespDTO> {

    @Override
    public Appointment mapToEntity(AppointmentReqDTO request) {
        return Appointment.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .roomNumber(request.getRoomNumber())
                .build();
    }

    @Override
    public Appointment mapToEntity(Appointment appointment, AppointmentReqDTO request) {
        appointment.setStartDate(request.getStartDate());
        appointment.setEndDate(request.getEndDate());
        appointment.setRoomNumber(request.getRoomNumber());
        return appointment;
    }

    @Override
    public AppointmentRespDTO mapToDTO(Appointment appointment) {
        return AppointmentRespDTO.builder()
                .id(appointment.getId())
                .startDate(appointment.getStartDate())
                .endDate(appointment.getEndDate())
                .roomNumber(appointment.getRoomNumber())
                .build();
    }

    @Override
    public Set<AppointmentRespDTO> mapToDTOs(Set<Appointment> appointments) {
        if (appointments == null || appointments.isEmpty())
            return null;

        Set<AppointmentRespDTO> appointmentsItr = new HashSet<>();
        appointments.forEach(appointment -> appointmentsItr.add(mapToDTO(appointment)));
        return appointmentsItr;
    }

}
