package com.alberto.course.facade;

import com.alberto.course.model.dto.CourseRequest;
import com.alberto.course.model.dto.CourseResponse;
import com.alberto.course.model.mapper.CourseMapper;
import com.alberto.course.service.CourseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CourseFacade {

    @Inject
    CourseService courseService;


    public List<CourseResponse> getCourses() {
        var courseDtoList = courseService.getAll();
        return CourseMapper.MAPPER.toWebResponseList(courseDtoList);
    }
    public CourseResponse getCoursesById(Integer id) {
        var courseDto = courseService.getById(id);
        return CourseMapper.MAPPER.toWebResponse(courseDto);
    }
    public CourseResponse getCoursesByTitle(String name) {
        return null;
    }
    public void saveCourse(CourseRequest courseRequest) {
        courseService.save(CourseMapper.MAPPER.toRequestDto(courseRequest));
    }
    public CourseResponse updateCourse(CourseRequest courseRequest) {
        var courseDto = courseService.update(CourseMapper.MAPPER.toRequestDto(courseRequest));
        return CourseMapper.MAPPER.toWebResponse(courseDto);
    }
    public void deleteCourseById(Integer id) {
        courseService.delete(id);
    }
}
