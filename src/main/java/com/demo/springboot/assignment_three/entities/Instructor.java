package com.demo.springboot.assignment_three.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty(message = "Name is required")
    @Size(min = 4, max = 50, message = "Name should be between 4 and 50 characters")
    private String name;

    @Column
    @NotEmpty(message = "Faculty is required")
    @Size(min = 10, max = 200, message = "Faculty should be between 10 and 200 characters")
    private String faculty;

    @Column
    private Date dob;


    public Instructor() {
    }

    public Instructor(String name, String faculty, Date dob){
        this.name = name;
        this.faculty = faculty;
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
