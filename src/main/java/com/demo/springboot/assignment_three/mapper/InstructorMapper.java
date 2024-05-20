package com.demo.springboot.assignment_three.mapper;

import com.demo.springboot.assignment_three.dto.InstructorDTO;
import com.demo.springboot.assignment_three.entities.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO instructorToInstructorDTO(Instructor instructor);
    Instructor instructorDTOToInstructor(InstructorDTO instructorDTO);
    void instructorDTOToInstructor(InstructorDTO instructorDTO, @MappingTarget Instructor instructor);



    @Mapping(target = "id", ignore = true)
    InstructorDTO createInstructorDTOWithoutId(Instructor instructor);
}
