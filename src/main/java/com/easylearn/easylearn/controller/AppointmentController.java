/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Controller is the class, where all CRUD methods implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    /**
     * Main Constructor
     * @param appointmentService is an instance from the AppointmentService class in Services package.
     */
    @Autowired
    public AppointmentController(AppointmentService appointmentService )
    {
        this.appointmentService = appointmentService;
    }

    /**
     * createAppointment method, which is responsible for creating a new Appointment (HTTP POST)
     * @param request is the content of the request passed to the POST method.
     * @return HTTP code 201 if successfully created and other codes for other behaviors.
     */
    @PostMapping
    public ResponseEntity<AppointmentRespDTO> createAppointment(@RequestBody AppointmentReqDTO request) {
        return appointmentService.createAppointment(request);
    }

    /**
     * findAppointmentById method, which is responsible for getting an appointment by its id (HTTP GET)
     * @param appointmentId is the id of the appointment, which will be returned back
     * @return HTTP code 200 and the appointment data as ResponseEntity, if successfully returned back and others code for other behaviors.
     */
    @GetMapping(path = "/{appointmentId}")
    public AppointmentRespDTO findAppointmentById(@PathVariable Long appointmentId)
    {
        return appointmentService.findAppointmentById(appointmentId);
    }

    /**
     * findAllAppointments method, which is responsible for getting all appointments stored in the database (HTTP GET)
     * @return
     */
    @GetMapping
    public ResponseEntity findAllAppointments()
    {
        return appointmentService.findAllAppointments();
    }

    @GetMapping("x")
    public ResponseEntity findAllCoursesAppointments()
    {
        return appointmentService.findAllCoursesAppointments();
    }

    /**
     * API to update a specific appointment
     *
     * @param appointmentId used to get the appointmentId
     * @param request   used to get the request body
     * @return AppointmentRespDTO
     */
    @PutMapping(path = "/{appointmentId}")
    public AppointmentRespDTO updateAppointment(@PathVariable Long appointmentId, @Valid @RequestBody AppointmentReqDTO request) {
        return appointmentService.updateAppointment(appointmentId, request);
    }

    @DeleteMapping(path = "/{appointmentId}")
    public ResponseEntity deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }
}
