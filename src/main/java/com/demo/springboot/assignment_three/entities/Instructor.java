package com.demo.springboot.assignment_three.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String faculty;

    @Column
    private Date date_of_birth;

    public Instructor() {
    }

    public Instructor(String name, String faculty, Date date_of_birth){
        this.name = name;
        this.faculty = faculty;
        this.date_of_birth = date_of_birth;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
