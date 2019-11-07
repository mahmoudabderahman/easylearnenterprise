package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentRespDTO> createAppointment(@RequestBody AppointmentReqDTO request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping(path = "/{appointmentId}")
    public ResponseEntity<AppointmentRespDTO> findAppointmentById(@PathVariable Long appointmentId)
    {
        return null;
    }

    @GetMapping
    public ResponseEntity<AppointmentRespDTO> findAllAppointments()
    {
        return null;
    }

    @DeleteMapping(path = "/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {

    }
}
