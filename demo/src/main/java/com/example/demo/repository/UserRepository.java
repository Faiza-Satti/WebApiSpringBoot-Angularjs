package com.example.demo.repository;

import com.example.demo.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<ApplicationUser,Integer>  {
//    @Query("FROM User AS u LEFT JOIN u.id AS cm WHERE cm = 1")
    @Query(nativeQuery = true, value = "select * from User as c where c.role=:roleName and c.username=:userUsername and c.password=:userPassword")
    List<ApplicationUser> findAll(String userUsername, String userPassword, String roleName);

    @Query(nativeQuery = true, value = "SELECT * FROM User")
    List<ApplicationUser> findAllUsers();
}
