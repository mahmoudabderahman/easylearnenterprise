package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends BaseRepository<Course, Long> {
    Set<Course> findAllByTeacherIdNull(Sort sort);

    Set<Course> findAllByTeacherId(Long teacherId, Sort sort);

    Set<Course> findAll(Sort sort);

    Set<Course> findAllByStudentsId(Long studentId, Sort sort);

    @Query(value = "select * from course c where c.id in (select course_student.course_id from course_student where course_student.course_id = c.id and\n" +
            "\t\t\t\t\t\t\t\t\t  course_student.student_id in (select s.id from student s where parent_id = :parent_id)) order by course_code", nativeQuery = true)
    Set<Course> findAllCoursesOfParentsStudents(@Param("parent_id") Long parentId);
}
