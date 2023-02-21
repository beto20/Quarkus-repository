package com.alberto.app.course.model.mapper;

import com.alberto.app.course.model.dto.CourseDto;
import com.alberto.app.course.model.dto.CourseRequest;
import com.alberto.app.course.model.dto.CourseResponse;
import com.alberto.app.course.model.entity.CourseEntity;
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
