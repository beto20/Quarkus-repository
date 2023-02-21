package com.alberto.app.person.service.impl;

import com.alberto.app.person.model.dto.TeacherDto;
import com.alberto.app.person.model.mapper.TeacherMapper;
import com.alberto.app.person.service.TeacherService;
import com.alberto.core.person.repository.TeacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {

    @Inject
    TeacherRepository teacherRepository;

    @Override
    public TeacherDto getPersonById(Long id) {
        var teacherEntity = teacherRepository.findById(id);
        return TeacherMapper.MAPPER.toDto(teacherEntity);
    }
}
