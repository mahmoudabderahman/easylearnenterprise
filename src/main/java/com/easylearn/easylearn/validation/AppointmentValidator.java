/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Validator class is where the code responsible for implementing the appointment validator methods
 * implemented.
 * Extends the BaseValidator class.
 */
package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.repository.AppointmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AppointmentValidator extends BaseValidator<Appointment> {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentValidator(AppointmentRepository appointmentRepository)
    {
        super(Appointment.class);
        this.appointmentRepository = appointmentRepository;
    }
}
