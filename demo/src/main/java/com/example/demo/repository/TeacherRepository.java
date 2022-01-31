package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Teacher u set u.userid = :userId where u.teacher_id = :id")
    void updateTeacherID(int id, int userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Teacher u set u.assignedCourse = :CourseId where u.teacher_id = :id")
    void updateCoursesId(int CourseId,int id);


}
