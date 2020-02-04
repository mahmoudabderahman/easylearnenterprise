/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * TeacherMapper class is where the code required for mapping teachers declared.
 */
package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.model.TeacherReqDTO;
import com.easylearn.easylearn.model.TeacherRespDTO;
import com.easylearn.easylearn.model.enums.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class TeacherMapper implements ObjectMapper<Teacher, TeacherReqDTO, TeacherRespDTO> {

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the creation of teachers.
     *
     * @param request is the request body, which will be passed to this method
     * @return the teacher entity object after being built.
     */
    @Override
    public Teacher mapToEntity(TeacherReqDTO request) {
        return Teacher.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .userType(UserType.TEACHER)
                .build();
    }

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the update of teachers.
     *
     * @param teacher is the already created teacher entity, which will be modified.
     * @param request is the body of the modifications.
     * @return the teacher entity after being modified.
     */
    @Override
    public Teacher mapToEntity(Teacher teacher, TeacherReqDTO request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setUsername(request.getUsername());
        teacher.setPassword(request.getPassword());
        teacher.setUserType(UserType.TEACHER);
        return teacher;
    }

    /**
     * mapToDTO method, which is responsible for mapping entities to data transfer objects,
     * used mainly for getting specific teacher
     *
     * @param teacher the student entity, that will be mapped
     * @return the teacher entity object after being built.
     */
    @Override
    public TeacherRespDTO mapToDTO(Teacher teacher) {
        return TeacherRespDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .username(teacher.getUsername())
                .password(teacher.getPassword())
                .userType(UserType.TEACHER)
                .build();
    }

    /**
     * mapToDTO method, which is responsible for mapping list of entities to data transfer objects,
     * used mainly for getting several teachers.
     *
     * @param teachers is the list of students, that will be mapped.
     * @return list of teacher entities.
     */
    @Override
    public Set<TeacherRespDTO> mapToDTOs(Set<Teacher> teachers) {
        if (teachers == null || teachers.isEmpty())
            return null;

        Set<TeacherRespDTO> teachersItr = new HashSet<>();
        teachers.forEach(teacher -> teachersItr.add(mapToDTO(teacher)));
        return teachersItr;
    }
}
