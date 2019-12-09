package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends BaseRepository<Course, Long> {
    Set<Course> findAll();

}
