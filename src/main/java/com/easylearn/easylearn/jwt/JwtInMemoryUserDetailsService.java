package com.easylearn.easylearn.jwt;

import com.easylearn.easylearn.EasylearnApplication;
import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.repository.ParentRepository;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    /*
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    private boolean filledOneTime = false;
    */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        if (!filledOneTime) {
            fillUsersList();
            filledOneTime = true;
        }
        */
        Set<JwtUserDetails> inMemoryUserList = EasylearnApplication.inMemoryUserList;

        System.out.println("Number of users: " + inMemoryUserList.size());
        if (!inMemoryUserList.isEmpty()) {
            Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst();

            if (!findFirst.isPresent()) {
                throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
            }
            return findFirst.get();

        }
        return null;
    }
/*
    public void fillUsersList() {
        inMemoryUserList = new HashSet<>();
        Set<Parent> parents = parentRepository.findAll(Sort.by("lastName"));
        Set<Student> students = studentRepository.findAll(Sort.by("lastName"));
        Set<Teacher> teachers = teacherRepository.findAll(Sort.by("lastName"));

        parents.stream().forEach(parent -> inMemoryUserList.add(new JwtUserDetails(parent.getId(), parent.getUsername(), encoder.encode(parent.getPassword()), "ROLE_USER_2")));
        students.forEach(student -> inMemoryUserList.add(new JwtUserDetails(student.getId(), student.getUsername(), encoder.encode(student.getPassword()), "ROLE_USER_2")));
        teachers.forEach(teacher -> inMemoryUserList.add(new JwtUserDetails(teacher.getId(), teacher.getUsername(), encoder.encode(teacher.getPassword()), "ROLE_USER_2")));



        System.out.println("Number of users: " + inMemoryUserList.size());

    }
    */
}
