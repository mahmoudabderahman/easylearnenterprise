/**
 * @Author: Mahmoud Abdelrahman
 * Appointment Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {
    Set<Appointment> findAllByCourseIdNull(Sort sort);

    Set<Appointment> findAllByCourseId(Long courseId, Sort sort);

    Set<Appointment> findAll(Sort sort);

    @Query(value = "SELECT * FROM appointment a WHERE a.course_id in (select c.id from course c WHERE(c.id in (Select course_id from course_student where course_student.student_id = :student_id))) order by a.start_date", nativeQuery = true)
    Set<Appointment> findAllAppointmentsOfStudentCourses(@Param("student_id") Long studentId);

    @Query(value = "select * from appointment a where a .course_id in (select c.id from course c where teacher_id = :teacher_id) order by a.start_date", nativeQuery = true)
    Set<Appointment> findAllAppointmentsOfTeacherCourses(@Param("teacher_id") Long teacherId);

    @Query(value="select * from appointment a where a.id in (SELECT appointment_student.appointment_id FROM appointment_student where appointment_student.student_id = :student_id) order by start_date"
            , nativeQuery =true)
    Set<Appointment> findAllAppointmentsOfStudent(@Param("student_id") Long studentId);


}
