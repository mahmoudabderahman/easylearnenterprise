package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
// id, firstName, lastName, email, password

@Component
@Transactional
public class StudentMapper implements ObjectMapper<Student, StudentReqDTO, StudentRespDTO> {


    @Override
    public Student mapToEntity(StudentReqDTO request) {
        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .userType(request.getUserType())
                .role(request.getRole())
                .build();
    }

    @Override
    public Student mapToEntity(Student student, StudentReqDTO request) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setUsername(request.getUsername());
        student.setPassword(request.getPassword());
        student.setUserType(request.getUserType());
        student.setRole(request.getRole());
        return student;
    }

    @Override
    public StudentRespDTO mapToDTO(Student student) {
        return StudentRespDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .username(student.getUsername())
                .password(student.getPassword())
                .userType(student.getUserType())
                .role(student.getRole())
                .build();
    }

    @Override
    public Set<StudentRespDTO> mapToDTOs(Set<Student> students) {
        if (students == null || students.isEmpty())
            return null;

        Set<StudentRespDTO> studentsItr = new HashSet<>();
        students.forEach(student -> studentsItr.add(mapToDTO(student)));
        return studentsItr;

    }
}


