package com.example.demo.service;

import com.example.demo.entity.Section;
import com.example.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getSections(){

        return sectionRepository.findAll();
    }

    public Section getSection(int id){

        return sectionRepository.findById(id).orElse(null);
    }
    public Section addSection(Section person){

        sectionRepository.save(person);
        return person;
    }
    public Section updateSection(int id, Section person){
        //person.setID(id);
        sectionRepository.save(person);
        return person;
    }
    public void updateUserID(int id,int userId){
        //person.setID(id);
        sectionRepository.updateSectionID(id,userId);
//        return person;
    }

    public void deleteSection(int id){

        sectionRepository.deleteById(id);
    }
}
