package com.alberto.app.person.model.mapper;

import com.alberto.app.person.model.dto.TeacherDto;
import com.alberto.app.person.model.dto.TeacherResponseDto;
import com.alberto.core.person.model.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper MAPPER = Mappers.getMapper(TeacherMapper.class);

    TeacherDto toDto(TeacherEntity teacherEntity);
    TeacherResponseDto toResponseDto(TeacherDto teacherDto);
}
