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

    public void saveInstructor(Instructor instructor){// Should it return something?
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



}
