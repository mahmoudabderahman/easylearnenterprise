package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher, Long> {
    Set<Teacher> findAll();

}
