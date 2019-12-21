package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
@Entity
public class Teacher extends User {

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.PARENT;


    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public void addCourse(Course course) {
        courses.add(course);
    }


}
