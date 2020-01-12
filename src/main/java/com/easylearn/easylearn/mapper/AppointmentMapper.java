/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * AppointmentMapper class is where the code required for mapping appointments declared.
 */
package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class AppointmentMapper implements ObjectMapper<Appointment, AppointmentReqDTO, AppointmentRespDTO> {
    private final CourseMapper courseMapper;

    @Autowired
    public AppointmentMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the creation of appointments.
     * @param request is the request body, which will be passed to this method
     * @return the appointment entity object after being built.
     */
    @Override
    public Appointment mapToEntity(AppointmentReqDTO request) {
        return Appointment.builder()
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .roomNumber(request.getRoomNumber())
                .build();
    }

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the update of appointments.
     * @param appointment is the already created appointment entity, which will be modified.
     * @param request is the body of the modifications.
     * @return the appointment entity after being modified.
     */
    @Override
    public Appointment mapToEntity(Appointment appointment, AppointmentReqDTO request) {
        appointment.setStartDate(request.getStartDate());
        appointment.setEndDate(request.getEndDate());
        appointment.setRoomNumber(request.getRoomNumber());
        return appointment;
    }

    /**
     * mapToDTO method, which is responsible for mapping entities to data transfer objects,
     * used mainly for getting specific appointment
     * @param appointment the appointment entity, that will be mapped
     * @return the appointment entity object after being built.
     */
    @Override
    public AppointmentRespDTO mapToDTO(Appointment appointment) {
        return AppointmentRespDTO.builder()
                .id(appointment.getId())
                .startDate(appointment.getStartDate())
                .endDate(appointment.getEndDate())
                .roomNumber(appointment.getRoomNumber())
                .course((appointment.getCourse() != null) ? courseMapper.mapToDTO(appointment.getCourse()) : null)
                .build();
    }

    /**
     * mapToDTO method, which is responsible for mapping list of entities to data transfer objects,
     * used mainly for getting several appointments.
     * @param appointments is the list of appointments, that will be mapped.
     * @return list of appointment entities.
     */
    @Override
    public Set<AppointmentRespDTO> mapToDTOs(Set<Appointment> appointments) {
        if (appointments == null || appointments.isEmpty())
            return null;

        Set<AppointmentRespDTO> appointmentsItr = new HashSet<>();
        appointments.forEach(appointment -> appointmentsItr.add(mapToDTO(appointment)));
        return appointmentsItr;
    }

}
