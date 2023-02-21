package com.alberto.app.person.facade;

import com.alberto.app.person.model.dto.TeacherResponseDto;
import com.alberto.app.person.model.mapper.TeacherMapper;
import com.alberto.app.person.service.TeacherService;

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
