package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<Course, String> {

}
