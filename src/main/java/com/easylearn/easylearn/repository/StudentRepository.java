package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Student;

import java.util.Set;

public interface StudentRepository extends BaseRepository<Student, Long> {
    Set<Student> findAll();

}
