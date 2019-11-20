package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher extends User {

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.PARENT;


    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Builder
    public Teacher(Long id, String firstName, String lastName, String email, String password, Set<Role> roles, UserType userType, Set<Course> courses) {
        super(id, firstName, lastName, email, password, roles);
        this.userType = userType;
        this.courses = courses;
    }
}
