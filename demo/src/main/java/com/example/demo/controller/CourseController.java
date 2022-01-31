package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public List<Course> getCourses(){

        return courseService.getCourses();
    }
    @GetMapping(value = "/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }
    @PostMapping
    public Course addCourse(@RequestBody Course person){
        return courseService.addCourse(person);
    }
    @PutMapping(value = "/{id}")
    public Course updateCourse(@PathVariable int id,@RequestBody Course person){
        return courseService.updateCourse(id,person);
    }
    @PutMapping(value = "/updateUserId")
    public void updateUserID(@RequestBody ObjectNode objectNode){
        int userId = objectNode.get("userId").asInt();
        int id = objectNode.get("teacherId").asInt();
        courseService.updateUserID(id,userId);
    }

    @PostMapping(value = "/getSectionCourseRecord")
    public Object getSectionCourseRecord(@RequestBody ObjectNode objectNode){
        int sectionId = objectNode.get("sectionId").asInt();
        int courseId = objectNode.get("courseId").asInt();
        return courseService.getSectionCourseRecord(sectionId,courseId);
    }

    @PostMapping(value = "/getStudentCourseRecord")
    public Object[] getStudentCourseRecord(@RequestBody ObjectNode objectNode){
        int courseId = objectNode.get("courseId").asInt();
        return courseService.getStudentCourseRecord(courseId);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourse(@PathVariable int id){

        courseService.deleteCourse(id);
    }}