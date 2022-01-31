package com.example.demo.repository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Student u set u.userid = :userId where u.student_id = :id")
    void updateStudentID(int id, int userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT into student_courses values(:StudentId,:CourseId,:sectionId)")
    void addStudentCourses(int StudentId, int CourseId,int sectionId);

}
