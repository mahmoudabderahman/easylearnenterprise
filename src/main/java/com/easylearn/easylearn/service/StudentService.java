package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.mapper.StudentMapper;
import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public ResponseEntity<StudentRespDTO> createStudent(StudentReqDTO request)
    {
        log.trace(" *** START OF SAVING STUDENT *** ");
        Student student = studentMapper.mapToEntity(request);
        student = studentRepository.save(student);
        StudentRespDTO response = studentMapper.mapToDTO(student);
        log.trace(" *** END OF SAVING STUDENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
