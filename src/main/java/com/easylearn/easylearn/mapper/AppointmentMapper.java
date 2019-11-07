package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@Transactional
public class AppointmentMapper implements ObjectMapper<Appointment, AppointmentReqDTO, AppointmentRespDTO> {

    @Override
    public Appointment mapToEntity(AppointmentReqDTO request) {
        return null;
    }

    @Override
    public Appointment mapToEntity(Appointment entity, AppointmentReqDTO request) {
        return null;
    }

    @Override
    public AppointmentRespDTO mapToDTO(Appointment entity) {
        return null;
    }

    @Override
    public Set<AppointmentRespDTO> mapToDTOs(Set<Appointment> entities) {
        return null;
    }

}
