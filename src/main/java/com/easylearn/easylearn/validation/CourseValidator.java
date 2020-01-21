package com.easylearn.easylearn.validation;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CourseValidator extends BaseValidator<Course> {

    private CourseRepository courseRepository;

    @Autowired
    public CourseValidator(CourseRepository courseRepository) {
        super(Course.class);
        this.courseRepository = courseRepository;
    }
}
