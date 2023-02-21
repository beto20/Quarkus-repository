package com.alberto.app.person.facade;

import com.alberto.app.person.model.dto.EnrolledCourseRequestDto;
import com.alberto.app.person.model.dto.StudentResponseDto;
import com.alberto.app.person.model.mapper.StudentMapper;
import com.alberto.app.person.service.StudentService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StudentFacade {

    @Inject
    StudentService studentService;

    public StudentResponseDto getStudent(Long studentId) {
        var studentDto = studentService.getPersonById(studentId);
        return StudentMapper.MAPPER.toResponseDto(studentDto);
    }

    public void enrolledCourse(EnrolledCourseRequestDto enrolledCourseRequestDto) {
        studentService.enrolledCourse(enrolledCourseRequestDto);
    }
}
