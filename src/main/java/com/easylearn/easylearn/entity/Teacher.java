package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Teacher extends User {

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.PARENT;

    @JoinColumn(name = "teacher_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Course> courses;

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addCourses(Set<Course> courses) {
        this.courses.addAll(courses);
    }

}
