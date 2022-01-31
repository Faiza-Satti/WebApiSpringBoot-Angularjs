package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Teacher u set u.userid = :userId where u.teacher_id = :id")
    void updateCourseID(int id, int userId);

    @Query(nativeQuery = true, value = "Select * from section_courses u where u.section_id = :sectionId and u.course_id=:courseId")
    Object findMyRecord(int sectionId, int courseId);

    @Query(nativeQuery = true, value = "Select * from student_courses u where u.course_id = :courseId")
    Object[] findMyStudentRecord(int courseId);

}
