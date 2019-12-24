package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {

    Set<Appointment> findAll(Sort sort);

}
