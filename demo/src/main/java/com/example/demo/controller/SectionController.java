package com.example.demo.controller;

import com.example.demo.entity.Section;
import com.example.demo.service.SectionService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @GetMapping
    public List<Section> getSections(){

        return sectionService.getSections();
    }
    @GetMapping(value = "/{id}")
    public Section getSection(@PathVariable int id) {
        return sectionService.getSection(id);
    }
    @PostMapping
    public Section addSection(@RequestBody Section person){
        return sectionService.addSection(person);
    }
    @PutMapping(value = "/{id}")
    public Section updateSection(@PathVariable int id,@RequestBody Section person){
        return sectionService.updateSection(id,person);
    }
    @PutMapping(value = "/updateUserId")
    public void updateUserID(@RequestBody ObjectNode objectNode){
        int userId = objectNode.get("userId").asInt();
        int id = objectNode.get("teacherId").asInt();
        sectionService.updateUserID(id,userId);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteSection(@PathVariable int id){

        sectionService.deleteSection(id);
    }}