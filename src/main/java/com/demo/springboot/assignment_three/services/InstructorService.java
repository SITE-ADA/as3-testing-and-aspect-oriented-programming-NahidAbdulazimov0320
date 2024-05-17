package com.demo.springboot.assignment_three.services;

import com.demo.springboot.assignment_three.entities.Instructor;
import com.demo.springboot.assignment_three.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getById(Long id){
        return instructorRepository.findById(id);
    }

    public void createInstructor(Instructor instructor){// Should it return something?
        instructorRepository.save(instructor);
    }



    public boolean deleteById(Long id){
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isPresent()) {
            instructorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Instructor updateInstructor(Long id, Instructor instructorDetails) {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructor.setName(instructorDetails.getName());
        instructor.setFaculty(instructorDetails.getFaculty());

        return instructorRepository.save(instructor);
    }

// Patch
//    public Instructor patchInstructor(Long id, Map<String, Object> updates) {
//        Instructor instructor = instructorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Instructor not found"));
//
//        if (updates.containsKey("name")) {
//            instructor.setName((String) updates.get("name"));
//        }
//        if (updates.containsKey("subject")) {
//            instructor.setSubject((String) updates.get("subject"));
//        }
//
//        return instructorRepository.save(instructor);
//    }





}
