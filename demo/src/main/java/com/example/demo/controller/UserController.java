package com.example.demo.controller;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/account")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ApplicationUser> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping(value = "/login")
    public List<ApplicationUser> loginAccount(@RequestBody ObjectNode objectNode) {
        String username = objectNode.get("username").asText();
        String password = objectNode.get("password").asText();
        String role = objectNode.get("role").asText();
        System.out.println(username);
        return userService.getUsers(username,password,role);
    }
//    @GetMapping(value = "/login")
//    public List<ApplicationUser> loginAccount(){
//        String username="Faiza", password="12345";
//        return userService.getUsers(username,password);
//    }

    @PostMapping
    public ApplicationUser registerUser(@RequestBody ObjectNode objectNode){
        String username = objectNode.get("username").asText();
        String password = objectNode.get("password").asText();
        String role = objectNode.get("role").asText();
        ApplicationUser user=new ApplicationUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        System.out.println(password);
        return userService.addUser(user);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id){

        userService.deleteUser(id);
    }
    @GetMapping(value = "/{id}")
    public ApplicationUser getUser(@PathVariable int id){
        return userService.getUser(id);
    }
}
