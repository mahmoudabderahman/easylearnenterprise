package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.mapper.TeacherMapper;
import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@Service
@Transactional
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public ResponseEntity<TeacherRespDTO> createTeacher(TeacherReqDTO request) {
        log.trace(" *** START OF SAVING TEACHER *** ");
        Teacher teacher = teacherMapper.mapToEntity(request);
        teacher = teacherRepository.save(teacher);
        TeacherRespDTO response = teacherMapper.mapToDTO(teacher);
        log.trace(" *** END OF SAVING TEACHER *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
