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
public class Student extends User{

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.STUDENT;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Course> courses;

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    public void addAppointment(Appointment appointment)
    {
        this.appointments.add(appointment);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }


}
