package com.demo.springboot.assignment_three.controllers;


import com.demo.springboot.assignment_three.dto.InstructorDTO;
import com.demo.springboot.assignment_three.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.springboot.assignment_three.services.InstructorService;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/{id}")// GET
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {// Change this return type and check for differences
        Optional<Instructor> instructor = instructorService.getById(id);
        if (instructor.isPresent()) {
            return ResponseEntity.ok(instructor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")// GET/All
    public Iterable<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }


    @PostMapping// POST
    public ResponseEntity<Void> createInstructor(@RequestBody InstructorDTO input) {
        Long newInstructorId  = instructorService.createInstructor(input);  // Assuming void return type

         return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/instructors/" + newInstructorId).build();
    }


    @PutMapping("/{id}")// PUT
    public ResponseEntity<Void> updateInstructor(@PathVariable Long id, @RequestBody InstructorDTO input) {

        try {
           instructorService.updateInstructor(id, input);
           return ResponseEntity.ok().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchInstructor(@PathVariable Long id, @RequestBody Instructor newInstructor) {
        try {
            instructorService.patchInstructor(id, newInstructor);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") // DELETE
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        boolean deleted = instructorService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content on successful deletion
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found if instructor not found
        }
    }

}
