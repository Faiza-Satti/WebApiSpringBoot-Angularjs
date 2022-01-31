package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT c FROM Person c WHERE c.Height>4")
    List<Person> findAll();
}
