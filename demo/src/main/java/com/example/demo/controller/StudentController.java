package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Student;
import com.example.demo.service.PersonService;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getStudents(){

        return studentService.getStudents();
    }
    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student person){

        return studentService.addStudent(person);
    }

    @PutMapping(value = "/addStudentCourses")
    public void addStudentCourses(@RequestBody ObjectNode objectNode){
        int studentId = objectNode.get("studentId").asInt();
        int courseId = objectNode.get("courseId").asInt();
        int sectionId = objectNode.get("sectionId").asInt();
        studentService.addStudentCourses(studentId,courseId,sectionId);
    }

    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student person){
        return studentService.updateStudent(id,person);
    }
    @PutMapping(value = "/updateUserId")
    public void updateUserID(@RequestBody ObjectNode objectNode){
        int userId = objectNode.get("userId").asInt();
        int id = objectNode.get("teacherId").asInt();
        studentService.updateUserID(id,userId);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable int id){

        studentService.deleteStudent(id);
    }}