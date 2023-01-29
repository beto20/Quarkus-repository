package com.alberto.person.service.impl;

import com.alberto.course.model.entity.CourseEntity;
import com.alberto.course.model.mapper.CourseMapper;
import com.alberto.person.model.dto.EnrolledCourseRequestDto;
import com.alberto.person.model.dto.StudentDto;
import com.alberto.person.model.mapper.StudentMapper;
import com.alberto.person.repository.StudentRepository;
import com.alberto.person.service.StudentService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentRepository studentRepository;

    @Override
    public StudentDto getPersonById(Long id) {
        var studentEntity = studentRepository.findById(id);
        return StudentMapper.MAPPER.toDto(studentEntity);
    }

    @Transactional
    @Override
    public void enrolledCourse(EnrolledCourseRequestDto enrolledCourseRequestDto) {
        var student = studentRepository.findById(enrolledCourseRequestDto.getId());

        if (student != null) {
            var enrollmentCourses = new ArrayList<CourseEntity>();
            enrolledCourseRequestDto.getEnrolledCourse().forEach(courseDto -> {
                var courseEntity = CourseMapper.MAPPER.toEntity(courseDto);
                enrollmentCourses.add(courseEntity);
            });
            student.setEnrolledCourses(enrollmentCourses);
            studentRepository.persist(student);
        }
    }
}
