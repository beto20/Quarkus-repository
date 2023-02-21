package com.alberto.app.person.service;

import com.alberto.app.person.model.dto.EnrolledCourseRequestDto;
import com.alberto.app.person.model.dto.StudentDto;

public interface StudentService extends GenericService<StudentDto, Long> {

    void enrolledCourse(EnrolledCourseRequestDto enrolledCourseRequestDto);
}
