package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(int id){

        return studentRepository.findById(id).orElse(null);
    }
    public Student addStudent(Student person){

        studentRepository.save(person);
        return person;
    }
    public Student updateStudent(int id,Student person){
        //person.setID(id);
        studentRepository.save(person);
        return person;
    }
    public void addStudentCourses(int StudentId, int CourseId,int sectionId){
        //person.setID(id);
        studentRepository.addStudentCourses(StudentId,CourseId,sectionId);
//        return person;
    }
    public void updateUserID(int id,int userId){
        //person.setID(id);
        studentRepository.updateStudentID(id,userId);
//        return person;
    }
    public void deleteStudent(int id){

        studentRepository.deleteById(id);
    }
}
