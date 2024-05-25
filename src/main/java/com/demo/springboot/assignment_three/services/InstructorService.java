package com.demo.springboot.assignment_three.services;

import com.demo.springboot.assignment_three.controllers.InstructorController;
import com.demo.springboot.assignment_three.dto.InstructorDTO;
import com.demo.springboot.assignment_three.entities.Instructor;
import com.demo.springboot.assignment_three.mapper.InstructorMapper;
import com.demo.springboot.assignment_three.repository.InstructorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorMapper instructorMapper;

    Logger logger = LoggerFactory.getLogger(InstructorController.class);

    public Iterable<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }


    DateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS");

    public Optional<Instructor> getById(Long id) {


        logger.info("Service started time: "+(df.format(new Date())));

        Optional<Instructor> instructorOptional = instructorRepository.findById(id);

        logger.info("Service ended time: "+df.format(new Date()));

        return instructorOptional;
    }

    public boolean deleteById(Long id) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isPresent()) {
            instructorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Long createInstructor(InstructorDTO input) {
        Instructor entity = instructorMapper.instructorDTOToInstructor(input);
        Instructor newEntity = instructorRepository.save(entity);
        return newEntity.getId();
    }

    public void updateInstructor(Long id, InstructorDTO input) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        Instructor instructor = new Instructor();

        if (instructorOptional.isPresent()) {
            instructor = instructorOptional.get();
            instructorMapper.instructorDTOToInstructor(input, instructor);
        } else {
            instructor = instructorMapper.instructorDTOToInstructor(input);
        }

        instructorRepository.save(instructor);
    }

    public void patchInstructor(Long id, InstructorDTO input) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        instructorMapper.instructorDTOToInstructor(input, instructor);
        instructorRepository.save(instructor);
    }
}
