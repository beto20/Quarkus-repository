package com.alberto.person.service;

import com.alberto.person.model.dto.EnrolledCourseRequestDto;
import com.alberto.person.model.dto.StudentDto;

public interface StudentService extends GenericService<StudentDto, Long> {

    void enrolledCourse(EnrolledCourseRequestDto enrolledCourseRequestDto);
}
