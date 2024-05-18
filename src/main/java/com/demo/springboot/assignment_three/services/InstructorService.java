package com.demo.springboot.assignment_three.services;

import com.demo.springboot.assignment_three.entities.Instructor;
import com.demo.springboot.assignment_three.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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



    public boolean deleteById(Long id){
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isPresent()) {
            instructorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public void createInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public void updateInstructor(Long id, Instructor newInstructor) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        newInstructor.setId(instructor.getId());
        instructorRepository.save(newInstructor);
    }

    public void patchInstructor(Long id, Instructor newInstructor ) {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructor.setName(newInstructor.getName());
        instructor.setFaculty(newInstructor.getFaculty());

        instructorRepository.save(instructor);
    }





}
