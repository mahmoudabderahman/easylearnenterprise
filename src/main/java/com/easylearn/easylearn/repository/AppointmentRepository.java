package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Appointment;

import java.util.List;
import java.util.Set;

public interface AppointmentRepository extends BaseRepository<Appointment, Long> {

    Set<Appointment> findAll();
}
