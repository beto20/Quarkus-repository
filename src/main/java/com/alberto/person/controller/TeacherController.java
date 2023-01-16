package com.alberto.person.controller;


import com.alberto.person.facade.TeacherFacade;
import com.alberto.person.model.dto.TeacherResponseDto;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Tag(name = "Teacher")
@Path("api/v1/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TeacherController {

    @Inject
    TeacherFacade teacherFacade;

    @GET
    @Path("/{id}")
    public TeacherResponseDto getStudent(@PathParam("id") Long teacherId) {
        return teacherFacade.getTeacher(teacherId);
    }

}
