package com.alberto.person.model.dto;

import com.alberto.course.model.dto.CourseDto;

import java.io.Serializable;
import java.util.List;

public class StudentDto extends PersonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<CourseDto> enrolledCourses;

    public StudentDto(String id, String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive, List<CourseDto> enrolledCourses) {
        super(id, name, lastName, code, email, password, country, province, district, isActive);
        this.enrolledCourses = enrolledCourses;
    }

    public List<CourseDto> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourseDto> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
