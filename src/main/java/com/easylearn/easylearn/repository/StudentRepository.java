package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {
    Set<Student> findAll(Sort sort);

    /*
    @Query(value = "select * from student where parent_id = null order by student.last_name", nativeQuery = true)
    Set<Student> findAllAvailableStudentsForParentAllocation();

    @Query(value = "select * from student where parent_id != null and parent_id = :parentId order by student.last_name", nativeQuery = true)
    Set<Student> findAllStudentsAllocatedToParent(@Param("parentId") Long parentId);
        */
    Set<Student> findAllByParentId(Long parentId, Sort sort);

    Set<Student> findAllByParentIdNull(Sort sort);

    @Query(value = "select * from student s WHERE(s.id not in (Select student_id from appointment_student where appointment_student.appointment_id = :apptId)) order by s.last_name", nativeQuery = true)
    Set<Student> findAllStudentsNotInAppointment(@Param("apptId") Long appointmentId);

    @Query(value = "select * from student s WHERE(s.id in (Select student_id from appointment_student where appointment_student.appointment_id = :apptId)) order by s.last_name", nativeQuery = true)
    Set<Student> findAllByAppointmentIdNotNull(@Param("apptId") Long appointmentId);

    @Query(value = "select * from student s WHERE(s.id not in (Select student_id from course_student where course_student.course_id = :courseId)) order by s.last_name", nativeQuery = true)
    Set<Student> findAllStudentsNotInCourse(@Param("courseId") Long courseId);

    @Query(value = "select * from student s WHERE(s.id in (Select student_id from course_student where course_student.course_id = :courseId)) order by s.last_name", nativeQuery = true)
    Set<Student> findAllByCourseIdNotNull(@Param("courseId") Long courseId);
}
