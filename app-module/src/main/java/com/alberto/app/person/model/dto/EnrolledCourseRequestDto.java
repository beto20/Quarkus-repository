package com.alberto.app.person.model.dto;

import com.alberto.app.course.model.dto.CourseDto;

import java.util.List;

public class EnrolledCourseRequestDto {

    private Long id;
    private List<CourseDto> enrolledCourse;

    public EnrolledCourseRequestDto() {
    }

    public EnrolledCourseRequestDto(Long id, List<CourseDto> enrolledCourse) {
        this.id = id;
        this.enrolledCourse = enrolledCourse;
    }

    public List<CourseDto> getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(List<CourseDto> enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
