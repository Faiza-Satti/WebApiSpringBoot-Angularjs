package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons(){

        return personRepository.findAll();
    }

    public Person getPerson(int id){

        return personRepository.findById(id).orElse(null);
    }
    public Person addPerson(Person person){

        personRepository.save(person);
        return person;
    }
    public Person updatePerson(int id,Person person){
        //person.setID(id);
        personRepository.save(person);
        return person;
    }
    public void deletePerson(int id){

        personRepository.deleteById(id);
    }
}
