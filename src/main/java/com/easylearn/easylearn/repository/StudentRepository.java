package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Appointment;
import com.easylearn.easylearn.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {
    Set<Student> findAll(Sort sort);
    Set<Student> findAllByParentIdNull(Sort sort);
    Set<Student> findAllByParentIdNotNull(Long parentId, Sort sort);
    //Set<Student> findAllByAppointmentsNotNull(Sort sort);
    Set<Student> findAllByAppointmentsNull(Sort sort);
    //Set<Student> findAllByCoursesNotNull(Sort sort);
    Set<Student> findAllByCoursesNull(Sort sort);
    //Set<Student> findAllByAppointmentsNull(Sort sort);
    //Set<Student> findAllByAppointmentsNotNull()
}
