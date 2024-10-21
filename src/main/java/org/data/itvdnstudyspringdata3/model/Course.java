package org.data.itvdnstudyspringdata3.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
