package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public final class TeacherValidator extends BaseValidator<Teacher> {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherValidator(TeacherRepository teacherRepository)
    {
        super(Teacher.class);
        this.teacherRepository = teacherRepository;
    }
}
