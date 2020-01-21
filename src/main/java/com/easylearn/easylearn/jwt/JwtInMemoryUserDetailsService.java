package com.easylearn.easylearn.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.easylearn.easylearn.controller.UserController;
import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.repository.ParentRepository;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.repository.TeacherRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService{
    List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;



    /*
    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
                "$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));

        //$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
    }
    */




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fillUsersList();
        System.out.println("Number of users: " + inMemoryUserList.size());
        if (!inMemoryUserList.isEmpty()){
            Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst();

            if (!findFirst.isPresent()) {
                throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
            }
            return findFirst.get();

        }
        return null;
    }

    public void fillUsersList() {

        Set<Parent> parents = parentRepository.findAll(Sort.by("lastName"));
        Set<Student> students = studentRepository.findAll(Sort.by("lastName"));
        Set<Teacher> teachers = teacherRepository.findAll(Sort.by("lastName"));
        if (!parents.isEmpty()) {
            List<Parent> parentsResponse = new ArrayList<>(parents.size());
            parents.forEach(parent -> parentsResponse.add(parent));
        }
        if (!students.isEmpty()) {
            List<Student> studentsResponse = new ArrayList<>(students.size());
            students.forEach(student -> studentsResponse.add(student));
        }
        if (!teachers.isEmpty()) {
            List<Teacher> teachersResponse = new ArrayList<>(teachers.size());
            teachers.forEach(teacher -> teachersResponse.add(teacher));
        }

        for (Parent parent: parents) {
            inMemoryUserList.add(new JwtUserDetails(parent.getId(), parent.getUsername(), encoder.encode(parent.getPassword()), "ROLE_USER_2"));
        }
        for (Student student: students) {
            inMemoryUserList.add(new JwtUserDetails(student.getId(), student.getUsername(), encoder.encode(student.getPassword()), "ROLE_USER_2"));
        }
        for (Teacher teacher: teachers) {
            inMemoryUserList.add(new JwtUserDetails(teacher.getId(), teacher.getUsername(), encoder.encode(teacher.getPassword()), "ROLE_USER_2"));
        }

        System.out.println("Number of users: " + inMemoryUserList.size());

    }
}
