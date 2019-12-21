package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.ParentType;
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
@Entity
@SuperBuilder

public class Parent extends User {

    @Enumerated(value = EnumType.STRING)
    private ParentType type;

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.TEACHER;

    @OneToMany(mappedBy = "parent")
    private Set<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

}

