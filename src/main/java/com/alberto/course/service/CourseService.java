package com.alberto.course.service;

import com.alberto.course.model.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> getAll();
    List<CourseDto> getCoursePagination(int pageIndex, int pageSize);
    CourseDto getById(Integer id);
    CourseDto getByTitle(String name);
    void save(CourseDto courseDto);
    CourseDto update(CourseDto courseDto);
    void delete(Integer id);
}
