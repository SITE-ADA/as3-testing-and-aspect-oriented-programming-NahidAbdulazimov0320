package com.demo.springboot.assignment_three.controllers;


import com.demo.springboot.assignment_three.dto.InstructorDTO;
import com.demo.springboot.assignment_three.entities.Instructor;
import com.demo.springboot.assignment_three.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
    public ResponseEntity createInstructor(@Valid @RequestBody InstructorDTO input, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            Long newInstructorId  = instructorService.createInstructor(input);  // Assuming void return type

            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", "/instructors/" + newInstructorId).build();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


    @PutMapping("/{id}")// PUT
    public ResponseEntity updateInstructor(@PathVariable Long id, @Valid @RequestBody InstructorDTO input, BindingResult bindingResult) {

        if(!Objects.equals(id, input.getId())){
            return ResponseEntity.notFound().build();
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            instructorService.updateInstructor(id, input);
            return ResponseEntity.ok().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity patchInstructor(@PathVariable Long id, @Valid @RequestBody InstructorDTO input, BindingResult bindingResult) {

        if(!Objects.equals(id, input.getId())){
            return ResponseEntity.notFound().build();
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            instructorService.patchInstructor(id, input);
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
