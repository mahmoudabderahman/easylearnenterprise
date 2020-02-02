/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Controller is the class, where all CRUD methods implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.AppointmentReqDTO;
import com.easylearn.easylearn.model.AppointmentRespDTO;
import com.easylearn.easylearn.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/appointments")
final class AppointmentController {
    private final AppointmentService appointmentService;

    /**
     * Main Constructor
     *
     * @param appointmentService is an instance from the AppointmentService class in Services package.
     */
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * createAppointment method, which is responsible for creating a new Appointment
     *
     * @param request is the content of the request passed to the POST method.
     * @return the body of the response.
     */
    @PostMapping
    public ResponseEntity<AppointmentRespDTO> createAppointment(@RequestBody AppointmentReqDTO request) {
        return appointmentService.createAppointment(request);
    }

    /**
     * findAppointmentById method, which is responsible for getting an appointment by its id
     *
     * @param appointmentId is the id of the appointment, which will be returned back
     * @return the appointment which was called.
     */
    @GetMapping(path = "/{appointmentId}")
    public AppointmentRespDTO findAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.findAppointmentById(appointmentId);
    }


    /**
     * findAllAppointmentsAllocatedByCourse method, which is responsible for getting all appointments
     * that are allocated to a course, while assigning courseId, it will return only the appointments
     * that are assigned to this course.
     *
     * @param courseId is passed to get the appointments that are allocated to this course.
     * @return list of appointments which were allocated to a course.
     */
    @GetMapping
    public ResponseEntity findAllAppointments(@RequestParam(required = false) Long courseId,@RequestParam(required = false) Long studentId,@RequestParam(required = false) Long teacherId, @RequestParam(required = false) Boolean ideal) {
        return appointmentService.findAllAppointments(courseId, studentId, teacherId, ideal);
    }


    /**
     * assignStudentsToAppointment method, which is responsible for assigning students to an appointment
     *
     * @param appointmentId the id of the appointment, which these students will be assigned to
     * @param studentIds    list of student ids, which will be assigned to this appointment
     * @return the body of the response.
     */
    @PostMapping(path = "/{appointmentId}/students")
    public AppointmentRespDTO assignStudentsToAppointment(@PathVariable Long appointmentId, @RequestBody Set<Long> studentIds) {
        return appointmentService.assignStudentsToAppointment(appointmentId, studentIds);
    }

    /**
     * updateAppointment method, which is responsible for updating a specific appointment
     *
     * @param appointmentId the id of the appointment, which will be updated
     * @param request       is the content of the request passed to the PUT method.
     * @return the body of the response.
     */
    @PutMapping(path = "/{appointmentId}")
    public AppointmentRespDTO updateAppointment(@PathVariable Long appointmentId, @Valid @RequestBody AppointmentReqDTO request) {
        return appointmentService.updateAppointment(appointmentId, request);
    }

    /**
     * deleteAppointment method, which is responsible for deleting a specific appointment
     *
     * @param appointmentId the id of the appointment, which will be deleted.
     * @return the body of the response.
     */
    @DeleteMapping(path = "/{appointmentId}")
    public ResponseEntity deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }
}
