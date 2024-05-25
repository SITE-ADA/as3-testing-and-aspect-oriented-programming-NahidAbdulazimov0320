package com.demo.springboot.assignment_three.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InstructorDTO {



    private Long id;

    @NotEmpty(message = "Name is required")
    @Size(min = 4, max = 50, message = "Name should be between 4 and 50 characters")
    private String name;

    @NotEmpty(message = "Faculty is required")
    @Size(min = 10, max = 200, message = "Faculty should be between 10 and 200 characters")
    private String faculty;

    private Date dob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) throws ParseException {
//
//        this.dob=dob;
////try {
////    this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
////}
////catch (ParseException e){
////    this.dob=null;
////}
//
//    }




    @Override
    public String toString() {
        return "InstructorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", dob=" + dob +
                '}';
    }
}
