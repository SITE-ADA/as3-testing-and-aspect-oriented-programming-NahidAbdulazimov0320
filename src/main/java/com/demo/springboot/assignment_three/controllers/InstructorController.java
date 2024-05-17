package com.demo.springboot.assignment_three.controllers;


import com.demo.springboot.assignment_three.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.springboot.assignment_three.services.InstructorService;

import java.util.List;
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

    @GetMapping("/all")// GET
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @PostMapping// POST
    public ResponseEntity<Void> createInstructor(@RequestBody Instructor instructor) {
        instructorService.createInstructor(instructor);  // Assuming void return type
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/instructor/" + instructor.getId()).build();
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

    @PutMapping("/{id}")// PUT
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails) {

        try {
            Instructor updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
            return ResponseEntity.ok(updatedInstructor);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

// Patch
//    @PatchMapping("/{id}")
//    public ResponseEntity<Instructor> patchInstructor(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        try {
//            Instructor updatedInstructor = instructorService.patchInstructor(id, updates);
//            return ResponseEntity.ok(updatedInstructor);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }


}
