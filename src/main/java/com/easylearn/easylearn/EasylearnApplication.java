/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Main Class
 */
package com.easylearn.easylearn;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.jwt.JwtUserDetails;
import com.easylearn.easylearn.model.enums.UserType;
import com.easylearn.easylearn.repository.ParentRepository;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EasylearnApplication {

    public static Set<JwtUserDetails> inMemoryUserList;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    EasylearnApplication easylearnApplication;

    public static void main(String[] args) {
        SpringApplication.run(EasylearnApplication.class, args);
    }

    /**
     * In this method, all users in the database will be created as JwtUserDetails Users
     */
    @PostConstruct
    public void fillUsersList() {
        inMemoryUserList = new HashSet<>();
        Set<Parent> parents = parentRepository.findAll(Sort.by("lastName"));
        Set<Student> students = studentRepository.findAll(Sort.by("lastName"));
        Set<Teacher> teachers = teacherRepository.findAll(Sort.by("lastName"));

        if (!parents.isEmpty()) {
            for (Parent parent : parents) {
                inMemoryUserList.add(new JwtUserDetails(parent.getId(), parent.getUsername(), encoder.encode(parent.getPassword()), "ROLE_USER_2", UserType.PARENT));
            }
        }
        if (!students.isEmpty()) {
            for (Student student : students) {
                inMemoryUserList.add(new JwtUserDetails(student.getId(), student.getUsername(), encoder.encode(student.getPassword()), "ROLE_USER_2", UserType.STUDENT));
            }
        }
        if (!teachers.isEmpty()) {
            for (Teacher teacher : teachers) {
                inMemoryUserList.add(new JwtUserDetails(teacher.getId(), teacher.getUsername(), encoder.encode(teacher.getPassword()), "ROLE_USER_2", UserType.TEACHER));
            }
        }

        inMemoryUserList.add(new JwtUserDetails(999999L, "admin@easylearn.mis.com", encoder.encode("123456"), "ROLE_USER_1", UserType.ADMIN));

    }


}
