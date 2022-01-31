package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){

        return teacherRepository.findAll();
    }

    public Teacher getTeacher(int id){

        return teacherRepository.findById(id).orElse(null);
    }
    public Teacher addTeacher(Teacher person){

        teacherRepository.save(person);
        return person;
    }
    public Teacher updateTeacher(int id,Teacher person){
        //person.setID(id);
        teacherRepository.save(person);
        return person;
    }
    public void updateUserID(int id,int userId){
        //person.setID(id);
        teacherRepository.updateTeacherID(id,userId);
//        return person;
    }

    public void updateCoursesId(int CourseId,int id){
        //person.setID(id);
        teacherRepository.updateCoursesId(CourseId,id);
//        return person;
    }

    public void deleteTeacher(int id){

        teacherRepository.deleteById(id);
    }
}
