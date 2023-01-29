package com.alberto.person.service.impl;

import com.alberto.person.model.dto.TeacherDto;
import com.alberto.person.model.mapper.TeacherMapper;
import com.alberto.person.repository.TeacherRepository;
import com.alberto.person.service.TeacherService;

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