package com.alberto.person.facade;

import com.alberto.person.model.dto.TeacherDto;
import com.alberto.person.model.dto.TeacherResponseDto;
import com.alberto.person.model.mapper.TeacherMapper;
import com.alberto.person.service.TeacherService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TeacherFacade {

    @Inject
    TeacherService teacherService;

    public TeacherResponseDto getTeacher(Long teacherId) {
        var teacherDto = teacherService.getPersonById(teacherId);
        return TeacherMapper.MAPPER.toResponseDto(teacherDto);
    }
}
