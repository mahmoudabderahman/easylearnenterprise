package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public  class StudentValidator extends BaseValidator<Student> {

    private StudentRepository studentRepository;

    @Autowired
    public StudentValidator(StudentRepository studentRepository)
    {
        super(Student.class);
        this.studentRepository = studentRepository;
    }
}
