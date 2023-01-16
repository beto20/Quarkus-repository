package com.alberto.person.service;

import com.alberto.person.model.dto.StudentDto;
import com.alberto.person.model.mapper.StudentMapper;
import com.alberto.person.repository.StudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentRepository studentRepository;

    @Override
    public StudentDto getPersonById(Long id) {
        var studentEntity = studentRepository.findById(id);
        return StudentMapper.MAPPER.toDto(studentEntity);
    }
}
