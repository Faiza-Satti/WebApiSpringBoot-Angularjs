package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public List<Teacher> getTeachers(){

        return teacherService.getTeachers();
    }
    @GetMapping(value = "/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        return teacherService.getTeacher(id);
    }
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher person){
        return teacherService.addTeacher(person);
    }
    @PutMapping(value = "/{id}")
    public Teacher updateTeacher(@PathVariable int id,@RequestBody Teacher person){
        return teacherService.updateTeacher(id,person);
    }
    @PutMapping(value = "/updateUserId")
    public void updateUserID(@RequestBody ObjectNode objectNode){
        int userId = objectNode.get("userId").asInt();
        int id = objectNode.get("teacherId").asInt();
        teacherService.updateUserID(id,userId);
    }

    @PutMapping(value = "/updateCoursesId")
    public void updateCoursesId(@RequestBody ObjectNode objectNode){
        int CourseId = objectNode.get("courseAssigned").asInt();
        int  id= objectNode.get("teacherId").asInt();
        teacherService.updateCoursesId(CourseId,id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteTeacher(@PathVariable int id){

        teacherService.deleteTeacher(id);
    }}