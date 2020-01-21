package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

// id, firstName, lastName, email, password
@Component
@Transactional
public class TeacherMapper implements ObjectMapper<Teacher, TeacherReqDTO, TeacherRespDTO> {
    @Override
    public Teacher mapToEntity(TeacherReqDTO request) {
        return Teacher.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .userType(request.getUserType())
                .role(request.getRole())
                .build();
    }

    @Override
    public Teacher mapToEntity(Teacher teacher, TeacherReqDTO request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setUsername(request.getUsername());
        teacher.setPassword(request.getPassword());
        teacher.setUserType(request.getUserType());
        teacher.setRole(request.getRole());
        return teacher;
    }

    @Override
    public TeacherRespDTO mapToDTO(Teacher teacher) {
        return TeacherRespDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .username(teacher.getUsername())
                .password(teacher.getPassword())
                .userType(teacher.getUserType())
                .role(teacher.getRole())
                .build();
    }

    @Override
    public Set<TeacherRespDTO> mapToDTOs(Set<Teacher> teachers) {
        if (teachers == null || teachers.isEmpty())
            return null;

        Set<TeacherRespDTO> teachersItr = new HashSet<>();
        teachers.forEach(teacher -> teachersItr.add(mapToDTO(teacher)));
        return teachersItr;
    }
}
