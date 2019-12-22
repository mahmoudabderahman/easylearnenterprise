package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.mapper.ParentMapper;
import com.easylearn.easylearn.mapper.StudentMapper;
import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.repository.ParentRepository;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.validation.ParentValidator;
import com.easylearn.easylearn.validation.StudentValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@Service
@Transactional
public class ParentService {
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    private final ParentValidator parentValidator;
    private final StudentValidator studentValidator;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public ParentService(ParentRepository parentRepository, ParentMapper parentMapper, ParentValidator parentValidator, StudentValidator studentValidator, StudentRepository studentRepository, StudentMapper studentMapper) {
        this.parentRepository = parentRepository;
        this.parentMapper = parentMapper;
        this.parentValidator = parentValidator;
        this.studentValidator = studentValidator;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public ResponseEntity<ParentRespDTO> createParent(ParentReqDTO request) {
        log.trace(" *** START OF SAVING APPOINTMENT *** ");
        Parent parent = parentMapper.mapToEntity(request);
        parent = parentRepository.save(parent);
        ParentRespDTO response = parentMapper.mapToDTO(parent);
        log.trace(" *** END OF SAVING APPOINTMENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ParentRespDTO findParentById(Long parentId) {
        log.info(" *** START OF FINDING PARENT BY ID *** ");
        Parent parent = parentValidator.validateExistence(parentId);
        ParentRespDTO response = parentMapper.mapToDTO(parent);
        log.info(" *** END OF FINDING PARENT BY ID *** ");
        return response;
    }

    public ResponseEntity<Set<ParentRespDTO>> findAllParents() {
        log.info(" *** START OF FINDING ALL PARENTS *** ");
        Set<Parent> parents = parentRepository.findAll();
        if (parents.isEmpty())
            return ResponseEntity.noContent().build();

        Set<ParentRespDTO> parentsResponse = new HashSet<>(parents.size());
        parents.forEach(parent -> parentsResponse.add(parentMapper.mapToDTO(parent)));
        log.info(" *** END OF FINDING ALL PARENTS *** ");
        return ResponseEntity.ok(parentsResponse);
    }

    public ParentRespDTO updateParent(Long parentId, ParentReqDTO request)
    {
        log.info(" *** START OF UPDATING PARENT BY ID *** ");
        Parent parent = parentValidator.validateExistence(parentId);
        parent = parentMapper.mapToEntity(parent, request);
        parentRepository.save(parent);
        ParentRespDTO response = parentMapper.mapToDTO(parent);
        log.info(" *** END OF UPDATING PARENT BY ID *** ");
        return response;
    }

    public StudentRespDTO assignStudentToParent(Long studentId, Long parentId)
    {
        log.info(" *** START OF ASSIGNING STUDENT TO PARENT BY ID *** ");
        Parent parent = parentValidator.validateExistence(parentId);
        Student student = studentValidator.validateExistence(studentId);
        student.setParent(parent);
        studentRepository.save(student);
        StudentRespDTO response = studentMapper.mapToDTO(student);
        log.info(" *** END OF ASSIGNING STUDENT TO PARENT BY ID *** ");
        return response;
    }

    public ResponseEntity deleteParent(Long parentId){
        log.info(" *** START OF DELETING PARENT BY ID *** ");
        Parent parent = parentValidator.validateExistence(parentId);
        parentRepository.delete(parent);
        log.info(" *** END OF DELETING PARENT BY ID *** ");
        return ResponseEntity.noContent().build();
    }
}
