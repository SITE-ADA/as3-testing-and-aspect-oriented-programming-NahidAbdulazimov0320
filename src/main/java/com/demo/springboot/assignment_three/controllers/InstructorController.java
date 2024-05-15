package com.demo.springboot.assignment_three.controllers;


import com.demo.springboot.assignment_three.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.assignment_three.services.InstructorService;

import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        if (instructor.isPresent()) {
            return ResponseEntity.ok(instructor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
