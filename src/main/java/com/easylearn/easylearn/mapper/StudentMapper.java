/**
 * @Author: Mahmoud Abdelrahman
 * StudentMapper class is where the code required for mapping students declared.
 */
package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.model.StudentReqDTO;
import com.easylearn.easylearn.model.StudentRespDTO;

import com.easylearn.easylearn.model.enums.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class StudentMapper implements ObjectMapper<Student, StudentReqDTO, StudentRespDTO> {


    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the creation of students.
     *
     * @param request is the request body, which will be passed to this method
     * @return the student entity object after being built.
     */
    @Override
    public Student mapToEntity(StudentReqDTO request) {
        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .userType(UserType.STUDENT)
                .build();
    }

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the update of students.
     *
     * @param student is the already created appointment entity, which will be modified.
     * @param request is the body of the modifications.
     * @return the student entity after being modified.
     */
    @Override
    public Student mapToEntity(Student student, StudentReqDTO request) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setUsername(request.getUsername());
        student.setPassword(request.getPassword());
        student.setUserType(UserType.STUDENT);
        return student;
    }

    /**
     * mapToDTO method, which is responsible for mapping entities to data transfer objects,
     * used mainly for getting specific appointment
     *
     * @param student the student entity, that will be mapped
     * @return the student entity object after being built.
     */
    @Override
    public StudentRespDTO mapToDTO(Student student) {
        return StudentRespDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .username(student.getUsername())
                .password(student.getPassword())
                .userType(UserType.STUDENT)
                .build();
    }

    /**
     * mapToDTO method, which is responsible for mapping list of entities to data transfer objects,
     * used mainly for getting several students.
     *
     * @param students is the list of students, that will be mapped.
     * @return list of student entities.
     */
    @Override
    public Set<StudentRespDTO> mapToDTOs(Set<Student> students) {
        if (students == null || students.isEmpty())
            return null;

        Set<StudentRespDTO> studentsItr = new HashSet<>();
        students.forEach(student -> studentsItr.add(mapToDTO(student)));
        return studentsItr;

    }
}


