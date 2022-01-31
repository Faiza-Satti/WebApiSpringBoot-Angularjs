package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sectionId;
    private String SectionName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "section_courses",
            joinColumns = {@JoinColumn(name = "sectionId")},
            inverseJoinColumns = {@JoinColumn(name = "courseId")})
    private List<Course> courses;
}
