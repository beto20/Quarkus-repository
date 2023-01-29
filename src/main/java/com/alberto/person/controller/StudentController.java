package com.alberto.person.controller;


import com.alberto.account.model.dto.AccountRequestDto;
import com.alberto.person.facade.StudentFacade;
import com.alberto.person.model.dto.EnrolledCourseRequestDto;
import com.alberto.person.model.dto.StudentResponseDto;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Tag(name = "Student")
@Path("api/v1/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class StudentController {

    @Inject
    StudentFacade studentFacade;

    @GET
    @Path("/{id}")
    public StudentResponseDto getStudent(@PathParam("id") Long studentId) {
        return studentFacade.getStudent(studentId);
    }

    @POST
    @Path("/enrollment")
    public void enrolledCourse(EnrolledCourseRequestDto enrolledCourseRequestDto) {
        studentFacade.enrolledCourse(enrolledCourseRequestDto);
    }

}
