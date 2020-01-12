package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher, Long> {
    Set<Teacher> findAll(Sort sort);
    //Set<Teacher> findAllByCourseIdNul(Sort sort);
    //Set<Teacher> findAllByCourseIdNotNull(Long courseId, Sort sort);
}
