package com.demo.springboot.assignment_three.services;

import com.demo.springboot.assignment_three.dto.InstructorDTO;
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

    public Iterable<Instructor> getAllInstructors(){
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

    public Long createInstructor(InstructorDTO input){


        Instructor entity = new Instructor(input.getName(),input.getFaculty(), input.getDate_of_birth());

        instructorRepository.save(entity);


        return entity.getId();
    }

    public void updateInstructor(Long id, InstructorDTO input) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);

        Instructor instructor = new Instructor();

        if(instructorOptional.isPresent()){

            instructor = instructorOptional.get();

            instructor.setName(input.getName());
            instructor.setFaculty(input.getFaculty());
            instructor.setDateOfBirth(input.getDate_of_birth());
        }
        else{
            instructor = new Instructor(input.getName(),input.getFaculty(), input.getDate_of_birth());
        }

        instructorRepository.save(instructor);
    }

    public void patchInstructor(Long id, Instructor newInstructor ) {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructor.setName(newInstructor.getName());
        instructor.setFaculty(newInstructor.getFaculty());

        instructorRepository.save(instructor);
    }





}
