package com.example.demo.service;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<ApplicationUser> getUsers(String username, String password, String role){

        return userRepository.findAll(username,password,role);
    }
    public void deleteUser(int id){

        userRepository.deleteById(id);
    }
    public List<ApplicationUser> getAllUsers(){

        return userRepository.findAllUsers();
    }

    public ApplicationUser getUser(int id){

        return userRepository.findById(id).orElse(null);
    }

    //registering user
    public ApplicationUser addUser(ApplicationUser user){

        userRepository.save(user);
        return user;
    }
//    public Person updatePerson(int id,Person person){
//        //person.setID(id);
//        personRepository.save(person);
//        return person;
//    }
//    public void deletePerson(int id){
//
//        personRepository.deleteById(id);
//    }
}
