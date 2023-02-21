package com.alberto.app.person.model.mapper;

import com.alberto.app.person.model.dto.StudentDto;
import com.alberto.app.person.model.dto.StudentResponseDto;
import com.alberto.core.person.model.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(StudentEntity studentEntity);
    StudentResponseDto toResponseDto(StudentDto studentDto);
}
