/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * CourseMapper class is where the code required for mapping courses declared.
 */
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

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the creation of courses.
     *
     * @param request is the request body, which will be passed to this method
     * @return the course entity object after being built.
     */
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


    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the update of courses.
     *
     * @param course is the already created appointment entity, which will be modified.
     * @param request     is the body of the modifications.
     * @return the course entity after being modified.
     */
    @Override
    public Course mapToEntity(Course course, CourseReqDTO request) {
        course.setCourseCode(request.getCourseCode());
        course.setName(request.getName());
        course.setGrade(request.getGrade());
        course.setContent(request.getContent());
        course.setDescription(request.getDescription());
        return course;
    }


    /**
     * mapToDTO method, which is responsible for mapping entities to data transfer objects,
     * used mainly for getting specific appointment
     *
     * @param course the appointment entity, that will be mapped
     * @return the course entity object after being built.
     */
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

    /**
     * mapToDTO method, which is responsible for mapping list of entities to data transfer objects,
     * used mainly for getting several appointments.
     *
     * @param courses is the list of appointments, that will be mapped.
     * @return list of courses entities.
     */
    @Override
    public Set<CourseRespDTO> mapToDTOs(Set<Course> courses) {
        if (courses == null || courses.isEmpty())
            return null;

        Set<CourseRespDTO> coursesItr = new HashSet<>();
        courses.forEach(course -> coursesItr.add(mapToDTO(course)));
        return coursesItr;
    }

}
