package com.alberto.course.model.mapper;

import com.alberto.course.model.dto.CourseDto;
import com.alberto.course.model.dto.CourseRequest;
import com.alberto.course.model.dto.CourseResponse;
import com.alberto.course.model.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    CourseEntity toEntity(CourseDto courseDto);
    CourseResponse toWebResponse(CourseDto courseDto);
    CourseDto toRequestDto(CourseRequest courseRequest);
    CourseDto toDto(CourseEntity courseEntity);
    List<CourseResponse> toWebResponseList(List<CourseDto> courseDtoList);
    List<CourseDto> toDtoList(List<CourseEntity> courseEntityList);

}
