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
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    @Override
    public Teacher mapToEntity(Teacher teacher, TeacherReqDTO request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setPassword(request.getPassword());
        return teacher;
    }

    @Override
    public TeacherRespDTO mapToDTO(Teacher teacher) {
        return TeacherRespDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .password(teacher.getPassword())
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
