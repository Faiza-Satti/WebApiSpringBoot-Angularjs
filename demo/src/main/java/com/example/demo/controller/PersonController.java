package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public List<Person> getPersons(){

        return personService.getPersons();
    }
    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }
    @PostMapping
    public Person addPerson(@RequestBody Person person){

        return personService.addPerson(person);
    }
//    @PutMapping(value = "/{id}")
//    public Person updatePerson(@PathVariable int id,@RequestBody Person person){
//        return personService.updatePerson(id,person);
//    }
    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable int id){

        personService.deletePerson(id);
    }}