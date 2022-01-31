package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SectionRepository extends JpaRepository<Section,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Teacher u set u.userid = :userId where u.teacher_id = :id")
    void updateSectionID(int id, int userId);
}
