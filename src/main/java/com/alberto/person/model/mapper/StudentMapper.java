package com.alberto.person.model.mapper;

import com.alberto.person.model.dto.StudentDto;
import com.alberto.person.model.dto.StudentResponseDto;
import com.alberto.person.model.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(StudentEntity studentEntity);
    StudentResponseDto toResponseDto(StudentDto studentDto);
}
