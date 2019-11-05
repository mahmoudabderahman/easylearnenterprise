package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){this.studentRepository = studentRepository;}

    public ResponseEntity<StudentRespDTO> createStudent(StudentReqDTO request)
    {
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email((request.getEmail()))
                .password(request.getPassword())
                .build();

        student = studentRepository.save(student);

        StudentRespDTO response = StudentRespDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .password(student.getPassword())
                .email(student.getEmail())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
