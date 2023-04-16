package com.alberto.app.course.service.impl;

import com.alberto.app.course.model.dto.CourseDto;
import com.alberto.app.course.model.dto.CustomPaginationResponse;
import com.alberto.app.course.model.mapper.CourseMapper;
import com.alberto.app.course.service.CourseService;
import com.alberto.app.course.util.PaginationUtil;
import com.alberto.core.course.model.entity.CourseEntity;
import com.alberto.core.course.repository.CourseRepository;
import io.quarkus.panache.common.Page;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CourseServiceImpl implements CourseService {

    @ConfigProperty(name = "enabled.mock.data", defaultValue = "true")
    boolean mockDataEnabled;

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

    public CustomPaginationResponse getCourseCustomPagination(int pageIndex, int pageSize) {
        if (pageIndex < 0 || pageSize <= 0) {
            pageIndex = 0;
            pageSize = 1;
        }

        var content = courseRepository.findAll().page(Page.of(pageIndex, pageSize)).list();
        var hasPrevious = courseRepository.findAll().page(pageIndex, pageSize).hasPreviousPage();
        var hasNext = courseRepository.findAll().page(pageIndex, pageSize).hasNextPage();
        var totalPages = courseRepository.findAll().page(pageIndex, pageSize).pageCount();
        var contentSize = content.size();
        var totalElements = courseRepository.findAll().stream().count();
        var numberPage = courseRepository.findAll().page(pageIndex, pageSize).page().index;
        var totalPagesSize = courseRepository.findAll().page(pageIndex, pageSize).page().size;


        return PaginationUtil.buildCustomPagination(content, hasPrevious, hasNext, totalPages, totalElements, numberPage, totalPagesSize, contentSize);
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
        if (mockDataEnabled) {
            for (int i = 0; i < 20; i++) {
                var courseEntity = new CourseEntity();
                courseEntity.setName("math " + i);
                courseEntity.setDescription("description " + i);
                courseEntity.setCategory("cate" + i);
                courseRepository.persist(courseEntity);
            }
        } else {
            var courseEntity = CourseMapper.MAPPER.toEntity(courseDto);
            courseRepository.persist(courseEntity);
        }
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
