package com.alberto.course.service.impl;

import com.alberto.course.model.dto.CourseDto;
import com.alberto.course.model.mapper.CourseMapper;
import com.alberto.course.repository.CourseRepository;
import com.alberto.course.service.CourseService;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CourseServiceImpl implements CourseService {
    @Inject
    CourseRepository courseRepository;


    @Override
    public List<CourseDto> getAll() {
        var courseEntityList = courseRepository.findAll().list();
        return CourseMapper.MAPPER.toDtoList(courseEntityList);
    }

    @Override
    public List<CourseDto> getCoursePagination(int pageIndex, int pageSize) {
        if (pageIndex < 0 || pageSize <= 0) {
            pageIndex = 0;
            pageSize = 1;
        }
        var list= courseRepository.findAll().page(Page.of(pageIndex, pageSize)).list();
        return CourseMapper.MAPPER.toDtoList(list);
    }

    @Override
    public CourseDto getById(Integer id) {
        var courseEntity = courseRepository.findById(id);
        return CourseMapper.MAPPER.toDto(courseEntity);
    }

    @Override
    public CourseDto getByTitle(String name) {
//        return courseRepository.findByName(name);
        return null;
    }

    @Override
    @Transactional
    public void save(CourseDto courseDto) {
        var courseEntity = CourseMapper.MAPPER.toEntity(courseDto);
        courseRepository.persist(courseEntity);
    }

    @Override
    @Transactional
    public CourseDto update(CourseDto courseDto) {

        var courseFounded = courseRepository.findById(courseDto.getId());
        courseFounded.setName(courseDto.getName());
        courseFounded.setDescription(courseDto.getDescription());
        courseFounded.setCategory(courseDto.getCategory());

        courseRepository.persist(courseFounded);

        return CourseMapper.MAPPER.toDto(courseFounded);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }
}
