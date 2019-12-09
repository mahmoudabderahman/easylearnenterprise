package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Course;
import com.easylearn.easylearn.model.CourseReqDTO;
import com.easylearn.easylearn.model.CourseRespDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class CourseMapper implements ObjectMapper<Course, CourseReqDTO, CourseRespDTO> {
    @Override
    public Course mapToEntity(CourseReqDTO request) {
        return Course.builder()
                .courseCode(request.getCourseCode())
                .name(request.getName())
                .grade(request.getGrade())
                .content(request.getContent())
                .description(request.getDescription())
                .build();
    }
// courseCode, name, grade, content, description
    @Override
    public Course mapToEntity(Course course, CourseReqDTO request) {
        course.setCourseCode(request.getCourseCode());
        course.setName(request.getName());
        course.setGrade(request.getGrade());
        course.setContent(request.getContent());
        course.setDescription(request.getDescription());
        return course;
    }

    @Override
    public CourseRespDTO mapToDTO(Course course) {
        return CourseRespDTO.builder()
                .id(course.getId())
                .courseCode(course.getCourseCode())
                .name(course.getName())
                .grade(course.getGrade())
                .content(course.getContent())
                .description(course.getDescription())
                .build();
    }

    @Override
    public Set<CourseRespDTO> mapToDTOs(Set<Course> courses) {
        if (courses == null || courses.isEmpty())
            return null;

        Set<CourseRespDTO> coursesItr = new HashSet<>();
        courses.forEach(course -> coursesItr.add(mapToDTO(course)));
        return coursesItr;
    }

}
