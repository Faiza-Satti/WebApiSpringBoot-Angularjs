package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(){

        return courseRepository.findAll();
    }

    public Course getCourse(int id){

        return courseRepository.findById(id).orElse(null);
    }
    public Course addCourse(Course person){

        courseRepository.save(person);
        return person;
    }
    public Course updateCourse(int id, Course person){
        //person.setID(id);
        courseRepository.save(person);
        return person;
    }
    public void updateUserID(int id,int userId){
        //person.setID(id);
        courseRepository.updateCourseID(id,userId);
//        return person;
    }

    public Object getSectionCourseRecord(int sectionId, int courseId){

        return courseRepository.findMyRecord(sectionId,courseId);
    }

    public Object[] getStudentCourseRecord(int courseId){

        return courseRepository.findMyStudentRecord(courseId);
    }

    public void deleteCourse(int id){

        courseRepository.deleteById(id);
    }
}
