/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;
import com.easylearn.easylearn.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {
    Set<Appointment> findAllByCourseIdNull(Sort sort);
    Set<Appointment> findAllByCourseId(Long courseId, Sort sort);
    Set <Appointment> findAll(Sort sort);
}
