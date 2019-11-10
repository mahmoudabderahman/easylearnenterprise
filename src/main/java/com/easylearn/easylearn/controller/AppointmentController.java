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

    @Autowired
    public AppointmentController(AppointmentService appointmentService )
    {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentRespDTO> createAppointment(@RequestBody AppointmentReqDTO request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping(path = "/{appointmentId}")
    public AppointmentRespDTO findAppointmentById(@PathVariable Long appointmentId)
    {
        return appointmentService.findAppointmentById(appointmentId);
    }

    @GetMapping
    public ResponseEntity findAllAppointments()
    {
        return appointmentService.findAllAppointments();
    }

    /**
     * API to update a specific workout
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
