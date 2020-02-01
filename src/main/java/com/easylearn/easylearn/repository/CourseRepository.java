package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Course;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends BaseRepository<Course, Long> {
    Set<Course> findAllByTeacherIdNull(Sort sort);

    Set<Course> findAllByTeacherId(Long teacherId, Sort sort);

    Set<Course> findAll(Sort sort);

    Set<Course> findAllByStudentsId(Long studentId, Sort sort);

}
