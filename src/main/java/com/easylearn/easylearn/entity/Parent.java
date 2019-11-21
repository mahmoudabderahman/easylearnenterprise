package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.ParentType;
import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;

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
public class Parent extends User {

    @Enumerated(value = EnumType.STRING)
    private ParentType type;

    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.TEACHER;

    @OneToMany(mappedBy = "parent")
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Builder

    public Parent(Long id, String firstName, String lastName, String email, String password, ParentType type, UserType userType, Set<Student> students) {
        super(id, firstName, lastName, email, password);
        this.type = type;
        this.userType = userType;
        this.students = students;
    }
}

