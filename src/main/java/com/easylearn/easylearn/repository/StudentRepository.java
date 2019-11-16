package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {
    Set<Student> findAll();

}
