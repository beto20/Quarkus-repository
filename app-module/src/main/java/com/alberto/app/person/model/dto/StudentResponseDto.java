package com.alberto.app.person.model.dto;

import com.alberto.app.course.model.dto.CourseDto;

import java.io.Serializable;
import java.util.List;

public class StudentResponseDto extends StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public StudentResponseDto(String id, String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive, List<CourseDto> enrolledCourses ) {
        super(id, name, lastName, code, email, password, country, province, district, isActive, enrolledCourses);
    }
}
