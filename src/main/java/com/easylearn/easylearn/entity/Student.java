package com.easylearn.easylearn.entity;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student extends User{


    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.STUDENT;


    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    public void addAppointment(Appointment appointment)
    {
        this.appointments.add(appointment);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Builder
    public Student(Long id, String firstName, String lastName, String email, String password, Set<Role> roles, UserType userType, Set<Appointment> appointments, Set<Course> courses, Parent parent) {
        super(id, firstName, lastName, email, password, roles);
        this.userType = userType;
        this.appointments = appointments;
        this.courses = courses;
        this.parent = parent;
    }
}
